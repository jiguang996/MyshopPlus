package com.jiguang.myshopplus.business;

import com.google.common.collect.Maps;
import com.jiguang.myshopplus.commons.utils.MapperUtils;
import com.jiguang.myshopplus.commons.utils.OkHttpClientUtil;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

/**
 * @Author ji
 * @Date 2019/11/25 21:58
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OKHttpTest {

    @Test
    public  void testGet() {
        String url = "https://t.bilibili.com/?spm_id_from=333.851.b_696e7465726e6174696f6e616c486561646572.31";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void  testUtils(){
        Map<String,String> map= Maps.newHashMap();
        map.put("username", "admin");
        map.put("password", "123456");
        map.put("grant_type", "password");
        map.put("client_id", "client");
        map.put("client_secret", "secret");
        try {
            Response response = OkHttpClientUtil.getInstance().postData("http://localhost:9001/oauth/token", map);
            String jsonString=response.body().string();
            Map<String,Object> jsonMap= MapperUtils.json2map(jsonString);
            String token= String.valueOf(jsonMap.get("access_token"));
            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
