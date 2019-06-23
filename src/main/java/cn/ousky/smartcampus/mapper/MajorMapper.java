package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Major;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorMapper {

    /**
     * 查询系部全部专业
     *
     * @param departmentId 系部id
     * @return
     */
    @Select("select * from Major where department_id=#{departmentId} order by number")
    List<Major> findAllByDepId(int departmentId);

    /**
     * 删除专业
     *
     * @param major 专业信息
     * @return
     */
    @Delete("delete from Major where id=#{id}")
    int delete(Major major);

    /**
     * 插入专业
     *
     * @param major 专业信息
     * @return
     */
    @Insert("insert into Major(name,number,department_id) values(#{name},#{number},#{department_id})")
    int insert(Major major);
}
