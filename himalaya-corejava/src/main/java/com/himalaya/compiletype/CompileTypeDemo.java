package com.himalaya.compiletype;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年6月23日 下午1:23:46
* Java字节码技术
* 采用JavaAssist实现
*/
public class CompileTypeDemo {

	public static void main(String[] args) throws Exception {
		
		ClassPool pool = ClassPool.getDefault();
		
		CtClass cc = pool.makeClass("com.himalaya.compiletype.autogen.Entity");
	
		// create field
		CtField fname = CtField.make("private String name;", cc);
		CtField fid = CtField.make("private int id;", cc);
		cc.addField(fname);
		cc.addField(fid);
		// create method
		CtMethod mSetName = CtMethod.make("public void setName(String name){$0.name = $1;}", cc);
		CtMethod mSetId = CtMethod.make("public void setId(String id){$0.id = $1;}", cc);
		CtMethod mGetName = CtMethod.make("public String getName(){return $0.name;}", cc);
		CtMethod mGetId = CtMethod.make("public int getId(){return $0.id;}", cc);
		cc.addMethod(mSetName);
		cc.addMethod(mSetId);
		cc.addMethod(mGetName);
		cc.addMethod(mGetId);
		
		// add constructor
		CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
		constructor.setBody("{$0.id = $1;$0.name = $2;}");
		cc.addConstructor(constructor);
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(path);
		cc.writeFile(path);
		System.out.println("Class generated successful");
	}
}
