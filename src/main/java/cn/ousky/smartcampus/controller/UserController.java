package cn.ousky.smartcampus.controller;

import cn.ousky.smartcampus.model.Login;
import cn.ousky.smartcampus.service.UserService;
import cn.ousky.smartcampus.util.TokenUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(allowCredentials="true")
@RestController
@RequestMapping("/login")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private TokenUtil tokenUtil;

    @RequestMapping(value = "/adm")
    public String adminLogin(@RequestBody Login login, HttpServletResponse response) {
        String json = JSON.toJSONString(userService.adminLogin(login));
        if (!json.equals("null")) {
            tokenUtil.addCookie(login,response);
        }
        return json;
    }

    @RequestMapping(value = "/sl")
    public String likeSchoolName(String name) {
        return JSON.toJSONString(userService.likeSchoolName(name));
    }

    @RequestMapping(value = "/stu")
    public String studentLogin(@RequestBody Login login, HttpServletResponse response){
        String json = JSON.toJSONString(userService.userLogin(login));
        if (!json.equals("null")) {
            tokenUtil.addCookie(login,response);
        }
        return json;
    }

}
