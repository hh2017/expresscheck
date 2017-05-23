package com.zzptc.fox.expresscheck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by wanderders on 2016/10/17.
 */
public class Utils {
    /**
     * @param httpUrl:请求接口
     * @param httpArg:参数
     * @return 返回结果
     */
    private static String mExpressCheckJson = "[{\"EMS\":\"EMS\"},{\"国通快递\":\"GTO\"},{\"汇丰物流\":\"HFWL\"},{\"天天快递\":\"HHTT\"},{\"百世快递\":\"HTKY\"},{\"顺丰快递\":\"SF\"},{\"申通快递\":\"STO\"},{\"韵达快递\":\"YD\"},{\"圆通速递\":\"YTO\"},{\"中通速递\":\"ZTO\"},{\"宅急送\":\"ZJS\"}]";

    public static HashMap<String, String> mExpressMap = new HashMap<>();

    public static void init(){
        try {
            JSONArray jsonArray = new JSONArray(mExpressCheckJson);
            for(int i = 0; i < jsonArray.length(); i ++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                //通过获取键值对来添加到hasmap里
                Iterator<String> iterator = jsonObject.keys();
                if(iterator.hasNext()){
                    String key = iterator.next();
                    String value = jsonObject.getString(key);
                    mExpressMap.put(key, value);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * Request string.
     *
     * @param httpUrl the http url
     * @param httpArg the http arg
     * @return the string
     */
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "a6d1281e-c395-4c71-87f3-a4078bbd3b87");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
