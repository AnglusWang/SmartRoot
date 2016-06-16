package com.angluswang.smartrobot.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;

/**
 * Created by Jeson on 2016/6/16.
 * 发送Http请求
 */

public class HttpUtils {

    private static final String URL = "http://www.tuling123.com/openapi/api";
    private static final String API_KEY = "c3083e3eeece9db67d3be980fa97d059";

    public static String doGet(String msg) {

        String result = "";
        String url = setParams(msg);
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            java.net.URL urlNet = new java.net.URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlNet.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);

            is = conn.getInputStream();
            int len = -1;
            byte[] buf = new byte[128];
            baos = new ByteArrayOutputStream();

            while ((len = is.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }

            baos.flush();
            result = new String(baos.toByteArray());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return result;
    }

    private static String setParams(String msg) {

        String url = null;
        try {
            url = URL + "?key=" + API_KEY + "&info=" + URLEncoder.encode(msg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }
}
