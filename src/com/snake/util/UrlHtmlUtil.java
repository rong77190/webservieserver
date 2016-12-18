//package com.snake.util;
//
//
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Scanner;
//
//public class UrlHtmlUtil {
//     private static final String prefix = "http://api.map.baidu.com/geocoder?location=";
//     private static final String key = "ba376eda799ae16ffb8492c9b44af443";
//     public static JSONObject getHtmlJsonByUrl(String urlTemp){
//        URL url = null;
//        InputStreamReader input = null;
//        HttpURLConnection conn;
//        JSONObject jsonObj = null;
//        try {
//           url = new URL(urlTemp);
//           conn = (HttpURLConnection) url.openConnection();
//           input = new InputStreamReader(conn.getInputStream(),"utf-8");
//           Scanner inputStream = new Scanner(input);
//           StringBuffer sb = new StringBuffer();
//           while (inputStream.hasNext()) {
//                 sb.append(inputStream.nextLine());
//           }
//          jsonObj = JSONObject.fromObject(sb.toString());
//       } catch (Exception e) {
//            System.out.println(e.getMessage());
//      }
//
//         return jsonObj;
//
// }
// public static void main(String[] args) {
//  String uri = prefix + 23.137466 + "," + 113.352425 + "&output=json&key=" + key;
//
//  JSONObject jsonObject = UrlHtmlUtil.getHtmlJsonByUrl（uri );
//  System.out.println(jsonObject.get("result"));
////  JSONObject resultJson = JSONObject.fromObject(jsonObject);
// }
//
//}