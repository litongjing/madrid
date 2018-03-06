package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:50 2018/2/26
 */
public class Util {

    @Test
    public void test_1(){
        String access_token_url = "https://oapi.dingtalk.com/gettoken?corpid=CorpID&corpsecret=SECRET";
        String requestUrl = access_token_url
                .replace("CorpID", "ding10dfcbc0c7dabea235c2f4657eb6378f").replace("SECRET", "gpcpE2w46l9dmofWcUYcWtQsUKjCmgptjW05Q5IDIJMmFWq-12ef3NmAcjA0Nnh_");
        StopWatch stopWatch=new StopWatch();
        stopWatch.start("getToken");
        JSONObject jsonObject = request(requestUrl, "GET", null);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(jsonObject);
    }

    @Test
    public void test_2(){
        //9f8c477337053066a481feb4f3cbae9f
        String access_token_url="https://oapi.dingtalk.com/user/get?access_token=ACCESS_TOKEN&userid=zhangsan";
        String requestUrl = access_token_url
                .replace("ACCESS_TOKEN", "9f8c477337053066a481feb4f3cbae9f").replace("zhangsan", "10143988");
        System.out.println(requestUrl);
        JSONObject jsonObject = request(requestUrl, "GET", null);
        System.out.println(jsonObject);
    }

    private JSONObject request(String request, String RequestMethod, String output) {
        System.out.println("请求参数："+output);
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 建立连接
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(RequestMethod);
            connection.setRequestProperty("Content-Type", "application/json");
            if (output != null) {
                OutputStream out = connection.getOutputStream();
                out.write(output.getBytes("UTF-8"));
                out.close();
            }
            // 流处理
            InputStream input = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input,"UTF-8");
            BufferedReader reader = new BufferedReader(inputReader);
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            // 关闭连接、释放资源
            reader.close();
            inputReader.close();
            input.close();
            input = null;
            connection.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    @Test
    public void test_other() throws ParseException {
        Double db=10.00;
        System.out.println(new BigDecimal(db));
        System.out.println(new Date().getTime());
        JSONObject jsonObject=null;
        System.out.println(jsonObject==null?null:jsonObject.toString());
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd");
        Date date=sf.parse("2018-01-01");
        System.out.println(date.getTime());
        System.out.println(JSON.parseObject(null));
    }
}
