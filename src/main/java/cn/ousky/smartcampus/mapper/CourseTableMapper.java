package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.CourseTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface CourseTableMapper {

    /**
     * 插入课程表
     * @param courseTable 课程表信息
     * @return
     */
    @Insert("insert into CourseTable(name,date) values(#{name},#{date})")
    @Options(useGeneratedKeys=true,keyProperty = "id",keyColumn = "id")
    int insert(CourseTable courseTable);

    /**
     * 删除课程表
     * @param courseTable 课程表信息
     * @return
     */
    @Delete("delete from CourseTable where id=#{id}")
    int delete(CourseTable courseTable);
}
