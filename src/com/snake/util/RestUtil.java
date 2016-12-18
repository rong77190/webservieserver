package com.snake.util;

import org.apache.xml.res.XMLErrorResources_it;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17/017.
 */
public class RestUtil {

    public static String string2Json(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }

        } return sb.toString();
    }
    public static void main(String[] args)throws Exception {

        //使用http连接调用CXF rest风格的web服务
            try {
                String base = "http://localhost:8080";// "http://localhost/pm/api";//http://192.168.0.100/pm/api/
                String authPath = base + "/good/getAllGood";
                HttpURLConnection conn = (HttpURLConnection) new URL(authPath).openConnection();
                conn.setRequestProperty("Accept", "application/json");
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                int code = conn.getResponseCode();
                //调用web服务
                if (code == 200) {
                    InputStream inStream1 = conn.getInputStream();
                    String jsonResult = getResponseString(inStream1);
                    System.out.println(jsonResult);
                    //解析返回的json
//                    System.out.println("jsonResult = " +string2Json(jsonResult));
//                    String json = string2Json(jsonResult);
                    String  json2 ="{\"data\":[{\"goodId\":1,\"subCategoryId\":13,\"goodName\":\"Daisy Perume\",\"price\":500.0,\"currPrice\":270.0,\"beginPrice\":200.0,\"image\":\"1\",\"introduction\":\"1\",\"createTime\":1470076514000,\"isDelete\":0,\"upTime\":1480948801000,\"goodState\":2,\"completeTime\":1481035194000,\"sellerId\":5,\"buyerId\":3,\"click\":1},{\"goodId\":2,\"subCategoryId\":17,\"goodName\":\"1\",\"price\":80.0,\"currPrice\":65.0,\"beginPrice\":55.0,\"image\":\"1\",\"introduction\":\"1\",\"createTime\":1471926672000,\"isDelete\":0,\"upTime\":1480948745000,\"goodState\":2,\"completeTime\":1481018400000,\"sellerId\":2,\"buyerId\":1,\"click\":3},{\"goodId\":3,\"subCategoryId\":16,\"goodName\":\"1\",\"price\":500.0,\"currPrice\":390.0,\"beginPrice\":300.0,\"image\":\"1\",\"introduction\":\"1\",\"createTime\":1478832572000,\"isDelete\":0,\"upTime\":1480948755000,\"goodState\":2,\"completeTime\":1480042176000,\"sellerId\":2,\"buyerId\":3,\"click\":5}],\"error\":\"\",\"status\":1}";
                    jsonResult = jsonResult.replace(" ","");
                    System.out.println(json2.equals(jsonResult));
                    JSONObject jsonObject = new JSONObject(jsonResult);

                    JSONObject jsonObj = new JSONObject(json2);

                    System.out.println(jsonObj.getJSONArray("data"));

                    JSONArray jsonArray = jsonObj.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length();i ++){
                        System.out.println(jsonArray.getJSONObject(i).getInt("goodId"));
                        System.out.println(jsonArray.getJSONObject(i).getInt("subCategoryId"));
                    }
//                    JSONObject.quote()
////                    String personId = jObj.getJSONObject("Response").getString("name");
////                    int score = jObj.getJSONObject("Response").getInt("score");
//                    int result = jsonObject.getJSONObject("status").getInt("status");
//                    System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+result);



//                    String path = base + "/getscore";
//                    URL url = new URL(path);
//                    conn = (HttpURLConnection) url.openConnection();
//                    conn.setRequestProperty("Accept", "application/json");
////                    conn.setRequestProperty("sessionId", sessionId);
////                    conn.setRequestProperty("personId", personId);
//                    conn.setConnectTimeout(5000);
//                    conn.setRequestMethod("GET");
//                    //调用web服务
//                    if (conn.getResponseCode() == 200) {
//                        InputStream inStream = conn.getInputStream();
//                        jsonResult = getResponseString(inStream);
//                        System.out.println(jsonResult);
////                        JSONArray array = new JSONObject(jsonResult).getJSONObject("Response").getJSONObject("business").getJSONArray("businessList");
//                        JSONArray array = new JSONObject(jsonResult).getJSONObject("Response").getJSONArray("");
//                        for (int i = 0; i < array.length(); i++) {
//                            System.out.println(" id:" + array.getJSONObject(i).getInt("id"));
//                            System.out.println(" name:" + array.getJSONObject(i).getString("name"));
//                            System.out.println(" score:" + array.getJSONObject(i).getInt("score"));
//                        }
//                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    /*
     *初始化RestTemplate，RestTemplate会默认添加HttpMessageConverter
     * 添加的StringHttpMessageConverter非UTF-8
     * 所以先要移除原有的StringHttpMessageConverter，
     * 再添加一个字符集为UTF-8的StringHttpMessageConvert
     * */
//        private static void resetCnMessageConverter(RestTemplate restTemplate) {
//            List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
//            HttpMessageConverter<?> converterTarget = null;
//            for (HttpMessageConverter<?> item : converterList) {
//                if (item.getClass() == StringHttpMessageConverter.class) {
//                    converterTarget = item;
//                    break;
//                }
//            }
//
//
//            if (converterTarget != null) {
//                converterList.remove(converterTarget);
//            }
//            HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
//            converterList.add(converter);
//        }

    private static String getResponseString(InputStream inStream) throws Exception {
        byte[] data = read(inStream);
        String objectstring = new String(data);
        System.out.println("???>?????????????????");
        System.out.println(objectstring);
        System.out.println("???>?????????????????");
        return objectstring;
    }

    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer);
        }
        inStream.close();
        return outputStream.toByteArray();
    }

}
