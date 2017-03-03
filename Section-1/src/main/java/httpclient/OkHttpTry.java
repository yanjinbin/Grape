package httpclient;

import com.google.common.net.MediaType;

import java.io.IOException;

/**
 * http://dwz.cn/5mqkTw
 * <p>
 * http://dwz.cn/5mqmYF
 * <p>
 * http://dwz.cn/5mqtUF
 * okhttp client使用
 *
 * @author Silver & Bullet
 *         on 二月-21
 */
public class OkHttpTry {
    public static void main(String[] args) throws IOException {

//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        String url = null;
//        Request build = new Request.Builder().url(url).build();
//        Response response = okHttpClient.newCall(build).execute();
//        String string = response.body().string();
//
//String json =null;
//        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html"), json);
//
//        Request post = new Request.Builder().url(url).post(requestBody).build();
//        String postString = okHttpClient.newCall(post).execute().body().string();
//        String userAgent = HTTP.USER_AGENT;
//        String connClose = HTTP.CONN_CLOSE;
        String s = MediaType.JSON_UTF_8.toString();
        String type = s;
        System.out.println(type);
    }
}
