package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolMapper {

    @Select("select id,`name` from School where `name` like concat(#{name},'%')")
    List<School> likeName(String name);
}
