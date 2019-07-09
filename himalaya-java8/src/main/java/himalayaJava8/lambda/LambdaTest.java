package himalayaJava8.lambda;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: anna
 * @create on: 2019-07-09 10:35 PM
 * @description:
 */
public class LambdaTest {

    public static void main(String[] args) {
        test1();
    }

    /**
     * test lambda expression
     */
    public static void test1(){
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.forEach(LambdaTest::print);
    }

    public static void print(String str){
        System.out.println(str);
    }
}
