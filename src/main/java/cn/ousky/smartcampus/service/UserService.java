package cn.ousky.smartcampus.service;

import cn.ousky.smartcampus.entity.Administrators;
import cn.ousky.smartcampus.entity.School;
import cn.ousky.smartcampus.entity.User;
import cn.ousky.smartcampus.mapper.AdministratorsMapper;
import cn.ousky.smartcampus.mapper.SchoolMapper;
import cn.ousky.smartcampus.mapper.UserMapper;
import cn.ousky.smartcampus.model.Login;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private AdministratorsMapper administratorsMapper;

    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private UserMapper userMapper;

    /**
     * 管理员账号查询
     * @param login 登录信息
     * @return
     */
    public Administrators adminLogin(Login login){
        return administratorsMapper.login(login);
    }

    /**
     * 学校查询
     * @param name 学校名字
     * @return
     */
    public List<School> likeSchoolName(String name){
        return schoolMapper.likeName(name);
    }

    /**
     * 学生账号查询
     * @return
     */
    public User userLogin(Login login){
        return userMapper.login(login);
    }

}
