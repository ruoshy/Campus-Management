package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Classs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClasssMapper {

    /**
     * 查询班级信息
     * @param classs 班级信息
     * @return
     */
    @Select("<script>" +
            "select * from Classs where 1=1" +
            "<if test='id!=null'>" +
            " and id=#{id}" +
            "</if>" +
            "<if test='number!=null'>" +
            " and number=#{number}" +
            "</if>" +
            "<if test='year!=null'>" +
            " and year=#{year}" +
            "</if>" +
            "<if test='course_table_id!=null'>" +
            " and course_table_id=#{course_table_id}" +
            "</if>" +
            "<if test='major_id!=null'>" +
            " and major_id=#{major_id}" +
            "</if>" +
            "order by number" +
            "</script>")
    List<Classs> select(Classs classs);

    /**
     * 查询系部所属班级
     * @param departmentId 系部id
     * @return
     */
    @Select("select Classs.*,Major.`name` from Department,Major,Classs " +
            "where Department.id = Major.department_id and Major.id = Classs.major_id " +
            "and Department.id = #{departmentId} order by `year`,`name`,number")
    @Results({
            @Result(property = "major.name", column = "name")
    })
    List<Classs> findAllByDepId(int departmentId);

    /**
     * 插入班级
     * @param classs 班级信息
     * @return
     */
    @Insert("insert into Classs(number,`year`,course_table_id,major_id) values(#{number},#{year},#{course_table_id},#{major_id})")
    int insert(Classs classs);

    /**
     * 删除班级
     * @param classs 班级信息
     * @return
     */
    @Delete("delete from Classs where id=#{id}")
    int delete(Classs classs);
}