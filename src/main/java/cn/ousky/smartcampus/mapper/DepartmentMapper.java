package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    /**
     * 通过学校id查找所属系部
     * @param schoolId 学校id
     * @return
     */
    @Select("select * from Department where Department.school_id = #{schoolId} order by number")
    List<Department> findDepartmentBySchoolId(Integer schoolId);

    /**
     * 添加系部
     * @param department 系部信息
     * @return
     */
    @Insert("insert into Department(`name`,school_id,number) values(#{name},#{school_id},#{number})")
    int insert(Department department);

    /**
     * 更新系部信息
     * @param department 系部信息
     * @return
     */
    @Update("update Department set name=#{name},number=#{number} where id=#{id}")
    int update(Department department);

    /**
     * 删除系部
     * @param department 系部信息
     * @return
     */
    @Delete("delete from Department where id=#{id}")
    int delete(Department department);
}
