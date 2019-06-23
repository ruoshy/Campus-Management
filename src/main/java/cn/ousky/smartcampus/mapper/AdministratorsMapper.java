package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Administrators;
import cn.ousky.smartcampus.model.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdministratorsMapper {

    @Select("select admin.id,admin.`user`,admin.`name`,sl.id school_id from Administrators admin,School sl " +
            "where admin.school_id = sl.id and " +
            "sl.id=#{id} and admin.`user` = #{user} and " +
            "admin.`password`=#{password}")
    Administrators login(Login login);
}
