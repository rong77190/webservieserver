package com.snake.util;


import com.snake.bean.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class RESTClient {


    public static List<User> getPHPScore(String uri) {
//        uri = "http://localhost:8080/good/getAllGood";
        String json = loadJson(uri);  //获得json字符串
        System.out.println(json);   //检测是否正确获得
//        JSONObject jsonObject= JSONObject.fromObject(json);
        JSONArray jsonArray = JSONArray.fromObject(json);
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < jsonArray.size();i ++){
            User user = new User();
            user.setId(i);
            user.setUserName(jsonArray.getJSONObject(i).getString("name"));
            user.setScore(jsonArray.getJSONObject(i).getInt("score"));
//            System.out.println(":::::::::::::::::::::::::::");
//            System.out.println(user.toString());
//            System.out.println(":::::::::::::::::::::::::::");
            list.add(user);
        }
        return list;
    }

    public static String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlObject.openConnection();
            httpURLConnection.setRequestProperty("content-type", "application/json");
//            httpURLConnection.
//            httpURLConnection.setRequestMethod("Get");

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        String url = "http://119.29.213.224/snake";
        String json1 = loadJson(url);
        System.out.println(json1);

//        String uri = "http://localhost:8080/good/getAllGood";
//        String json = loadJson(uri);  //获得json字符串
//        System.out.println(json);   //检测是否正确获得
//        JSONObject jsonObject= JSONObject.fromObject(json);
//        JSONArray jsonArray = jsonObject.getJSONArray("data");
//        List<Good> goodList = new ArrayList<Good>();
//        for (int i = 0; i < jsonArray.size();i ++){
//            Good good = new Good();
//            good.setBeginPrice(jsonArray.getJSONObject(i).getDouble("beginPrice"));
//            good.setBuyerId(jsonArray.getJSONObject(i).getInt("buyerId"));
//            good.setClick(jsonArray.getJSONObject(i).getInt("click"));
////            good.getCompleteTime();
//            good.setGoodName(jsonArray.getJSONObject(i).getString("goodName"));
//
//            good.setGoodId(jsonArray.getJSONObject(i).getInt("goodId"));
//            good.setSubCategoryId(jsonArray.getJSONObject(i).getInt("subCategoryId"));
//            goodList.add(good);
//        }
//
//        System.out.println(jsonObject.get("status"));  //其中id为json中某个key，检测是否可以获得value值
//        System.out.println("/////////////////////");
//        System.out.println(goodList.size());
//
//        for (Good good:goodList){
//            System.out.println("::::::::::::::::::::::::::::;;");
//            System.out.println(good.getBeginPrice());
//            System.out.println("::::::::::::::::::::::::::::;;");
//        }
    }































//    private WebClient client;
//
//    public static void main(String[] args) throws IOException {
//        String s ="[{\"username\": \"your name\", \"user_json\": {\"username\": \"your name\", \"nickname\": \"your nickname\"}}]";
//        JSONArray resultArray = new JSONArray(s);
//        JSONObject resultObj = resultArray.optJSONObject(0);
//
////获取数据项
//        String username = resultObj.getString("username");
//        System.out.println(username);
////获取数据对象
//        JSONObject user = resultObj.getJSONObject("user_json");
//        String nickname = user.getString("nickname");
//        System.out.println(nickname);
//    }



}