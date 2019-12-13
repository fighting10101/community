package life.majiang.community.controller;

import life.majiang.community.Mapper.UserMapper;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response){

        //1.从cookie中获取到令牌
        String token = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getName())){
                    token = cookie.getValue();
                    break;
                }
            }
        }
        //2.验证用户是否已经登录
        if(token!=null){
            //判断令牌对应的用户是否存在,存在则存入cookie
            User user = userMapper.findToken(token);
            if(user!=null){
                request.getSession().setAttribute("user",user);
            }
        }
        return "index";
    }
}
