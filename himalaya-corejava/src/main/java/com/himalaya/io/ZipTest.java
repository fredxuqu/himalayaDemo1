package com.himalaya.io;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @Author Fred
 * @Create on 2019/7/11.
 * @Description com.himalaya.io
 */
public class ZipTest {

    public static void readZipFile(File file){
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> zipEntryEnums = zipFile.entries();
            while (zipEntryEnums.hasMoreElements()){
                ZipEntry zipEntry = zipEntryEnums.nextElement();
                System.out.println(zipEntry.getName());
                if (zipEntry.getName().equals("abc.json")) {
                    InputStream is = zipFile.getInputStream(zipEntry);
                    int length = is.available();
                    byte[] bytes = new byte[length];
                    is.read(bytes);
                    String jsonStr = new String(bytes);
                    System.out.println(jsonStr);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readZipFileBytes(File file){
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(bytes));
//            BufferedInputStream bis = new BufferedInputStream(zis);
            ZipEntry zipEntry = null;
            while((zipEntry = zis.getNextEntry())!=null){
                int entrySize = (int)zipEntry.getSize();
                byte[] buf = new byte[entrySize];
                int num;
                // 将二进制输出到字节输出流，相当于一个缓存
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((num = zis.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                System.out.println(zipEntry.getName());
                System.out.println(zipEntry.getSize());
                if (zipEntry.getName().equals("abc.json")) {
                    // 从字节输出流中获取到字节数组
                    String jsonStr = new String(baos.toByteArray());
                    System.out.println("================================");
                    System.out.println(jsonStr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readZip(File file){
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            BufferedInputStream bis = new BufferedInputStream(zis);
            ZipEntry entry = null;
            while((entry = zis.getNextEntry())!=null && !entry.isDirectory()){
                System.out.println(entry.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        URL url = Thread.currentThread().getContextClassLoader().getResource("result.zip");
        File file = new File(url.getPath());
        readZip(file);
        readZipFile(file);
        readZipFileBytes(file);
    }
}
