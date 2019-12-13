package life.majiang.community.controller;

import life.majiang.community.Mapper.UserMapper;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.model.User;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String redirect_uri;


    @RequestMapping("/callback")
    public String authorize(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state,
                            HttpServletRequest request, HttpServletResponse response) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accessTokenAll = githubProvider.getAccessToken(accessTokenDTO);
        String accessToken = accessTokenAll.split("&")[0].split("=")[1];
        GithubUser githubUser = githubProvider.getGithubUserMsg(accessToken);

        if (githubUser != null) {
            //登录成功
            //1.创建session
            HttpSession session = request.getSession();
            session.setAttribute("user",githubUser);
            //2.登录信息写入数据
            String token = UUID.randomUUID().toString();
            User user = new User();
            user.setAccount_id(githubUser.getId());
            user.setName(githubUser.getLogin());
            user.setToken(token);
            user.setGmt_creat(System.currentTimeMillis());
            user.setGmt_modified(System.currentTimeMillis());
            userMapper.addUser(user);
            //3.把登录生成的令牌放到cookie中
            response.addCookie(new Cookie("token",token));
        } else {
            //登录失败
        }
        return "redirect:/";
    }
}
