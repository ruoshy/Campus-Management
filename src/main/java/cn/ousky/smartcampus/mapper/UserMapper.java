package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.User;
import cn.ousky.smartcampus.model.Login;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select `User`.*,School.name sname,Administrators.id aid from `User`,School,Administrators where `User`.school_id = School.id and School.id = Administrators.school_id and " +
            "`User`.`user`=#{user} and `User`.`password`=#{password} and School.`name`=#{name}")
    @Results({
            @Result(property = "school.name",column = "sname"),
            @Result(property = "school.administrators.id",column = "aid"),
    })
    User login(Login login);

    @Select("<script>select * from `User` where 1=1" +
            "<if test='id!=null'> and id=#{id}</if>" +
            "<if test='name!=null'> and name=#{name}</if>" +
            "<if test='user!=null'> and user=#{user}</if>" +
            "<if test='year!=null'> and year=#{year}</if>" +
            "<if test='school_id!=null'> and school_id=#{school_id}</if>" +
            "<if test='classs_id!=null'> and classs_id=#{classs_id}</if>" +
            " order by `user`" +
            "</script>")
    List<User> select(User user);

    /**
     * 根据学校id查询全部学生账号
     *
     * @param schoolId 学生id
     * @return
     */
    @Select("select * from `User` where school_id=#{schoolId}")
    List<User> findAllBySchoolId(int schoolId);


    /**
     * 根据班级id查询全部学生账号
     *
     * @param classsId 班级id
     * @return
     */
    @Select("select * from `User` where classs_id=#{classsId}")
    List<User> findAllByClassId(int classsId);

    /**
     * 根据系部id查询全部学生账号
     *
     * @param departmentId 系部id
     * @return
     */
    @Select("select * from `User` where department_id=#{departmentId}")
    List<User> findAllByDepartmentId(int departmentId);


    /**
     * 添加学生账号
     *
     * @param user 学生账号信息
     * @return
     */
    @Insert("insert into `User`(`name`,`user`,`password`,`year`,school_id,classs_id,department_id) " +
            "values(#{name},#{user},#{password},#{year},#{school_id},#{classs_id},#{department_id})")
    int insert(User user);


    /**
     * 更新学生账号信息
     *
     * @param user 学生账号信息
     * @return
     */
    @Update("update `User` set `name`=#{name},`user`=#{user},`password`=#{password} " +
            "where id=#{id}")
    int update(User user);

    /**
     * 删除学生账号信息
     *
     * @param user 学生账号信息
     * @return
     */
    @Delete("<script>" +
            "delete from `User` where id=#{id}" +
            "<if test='classs_id!=null'>" +
            " or classs_id=#{classs_id}" +
            "</if>" +
            "</script>")
    int delete(User user);
}
