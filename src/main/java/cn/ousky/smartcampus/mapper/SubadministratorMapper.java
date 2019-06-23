package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Subadministrator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubadministratorMapper {


    @Select("select * from Subadministrator where id=#{id}")
    Subadministrator findById(Integer id);

    /**
     * 通过系部id查询教师账号信息
     *
     * @param departmentId 系部id
     * @return
     */
    @Select("select * from Subadministrator where department_id=#{departmentId}")
    List<Subadministrator> findAllByDepId(int departmentId);

    /**
     * 添加教师账号
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @Insert("insert into Subadministrator(`name`,`user`,`password`,administrators_id,department_id) " +
            "values(#{name},#{user},#{password},#{administrators_id},#{department_id})")
    int insert(Subadministrator subadministrator);

    /**
     * 删除教师账号
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @Delete("delete from Subadministrator where id = #{id}")
    int delete(Subadministrator subadministrator);


    /**
     * 修改教师账号信息
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @Update("update Subadministrator " +
            "set `name`=#{name},`user`=#{user},`password`=#{password} where id = #{id}")
    int update(Subadministrator subadministrator);

    /**
     * 模糊查询教师账号信息
     *
     * @param subadministrator 教师账号信息
     * @return
     */
    @Select("select * from Subadministrator where `name` like concat(#{name},'%')")
    List<Subadministrator> likeName(Subadministrator subadministrator);
}
