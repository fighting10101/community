package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        String url = "https://github.com/login/oauth/access_token";
        String json = JSON.toJSONString(accessTokenDTO);
        String result = null;

        try {
            MediaType mediaType = MediaType.get("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder().url(url).post(body).build();
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public GithubUser getGithubUserMsg(String access_token) {

        String url = "https://api.github.com/user?access_token="+access_token;
        GithubUser githubUser = null;

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            String responseResult = response.body().string();
            githubUser = JSON.parseObject(responseResult,GithubUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return githubUser;
    }
}
