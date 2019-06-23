package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    /**
     * 删除对应条件课程
     *
     * @param course 课程信息
     */
    @Delete("<script>" +
            "delete from Course where id=#{id}" +
            "<if test='course_table_id!=null'>" +
            " or course_table_id=#{course_table_id}" +
            "</if>" +
            "</script>")
    int delete(Course course);

    /**
     * 插入课程
     *
     * @param course 课程信息
     */
    @Insert("insert into Course(name,sort_time,course_table_id," +
            "classroom_id,subadministrator_id) " +
            "values(#{name},#{sort_time},#{course_table_id},#{classroom_id},#{subadministrator_id})")
    int insert(Course course);

    /**
     * 查询条件对应课程
     *
     * @param course 课程信息
     */
    @Select("<script>" +
            "select * from Course where 1=1" +
            "<if test='course_table_id!=null'>" +
            " and course_table_id=#{course_table_id}" +
            "</if>" +
            "</script>")
    List<Course> select(Course course);

    /**
     * 查询课程表对应课程
     *
     * @param course 课程信息
     */
    @Select("select * from Course where " +
            "course_table_id=#{course_table_id}")
    @Results({
            @Result(property = "classroom", column = "classroom_id",
                    one = @One(select = "cn.ousky.smartcampus.mapper.ClassroomMapper.findById")),
            @Result(property = "subadministrator", column = "subadministrator_id",
                    one = @One(select = "cn.ousky.smartcampus.mapper.SubadministratorMapper.findById"))
    })
    List<Course> findInfoByCourseTableId(Course course);

}
