package Annotations.httpclient;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Silver & Bullet
 *         on 二月-21
 */
public class OkHttpTry {
    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        String url = null;
        Request build = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(build).execute();
        String string = response.body().string();

String json =null;
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html"), json);

        Request post = new Request.Builder().url(url).post(requestBody).build();
        String postString = okHttpClient.newCall(post).execute().body().string();
    }
}
