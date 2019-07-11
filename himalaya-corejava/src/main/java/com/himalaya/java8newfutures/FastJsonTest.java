package com.himalaya.java8newfutures;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author Fred
 * @Create on 2019/7/6.
 * @Description com.himalaya
 */
public class FastJsonTest {

    static String jsonStr = "{" +
            "\"batNo\":\"201906170987\"," +
            "\"cisReport\":[" +
            "{" +
            "\"node20100\":{" +
            "   \"result\": \"dsfasdfakdsfaksfasdf\"" +
            "}" +
            "}]}";

    static String jsonArrayStr = "[{\"key\":\"1111\"},{\"key\":\"2222\"},{\"key\":\"3333\"}]";

    public static void main(String[] args){
        JSONObject json = JSON.parseObject(jsonStr);
        JSONArray jsonArray = (JSONArray)json.get("cisReport");
        if (jsonArray.size()>0){
            JSONObject report = (JSONObject)jsonArray.get(0);
            System.out.println(report.get("node20100"));
        }

        JSONArray jsonArray1 = JSONObject.parseArray(jsonArrayStr);
        for (Object jsobj: jsonArray1) {
            JSONObject jsonArrayObject = (JSONObject)jsobj;
            System.out.println(jsonArrayObject);
        }
//        System.out.println(json);
    }
}
