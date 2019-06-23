package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.Classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassroomMapper {

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from Classroom where id=#{id}")
    Classroom findById(Integer id);

    /**
     * 查询学校所有教室
     *
     * @param schoolId 教室信息
     * @return
     */
    @Select("select * from Classroom where school_id = #{schoolId} order by address,`name`")
    List<Classroom> findAllBySchoolId(Integer schoolId);

    /**
     * 插入教室
     *
     * @param classroom 教室信息
     * @return
     */
    @Insert("insert into Classroom(name,address,volume,school_id) values(#{name},#{address},#{volume},#{school_id})")
    int insert(Classroom classroom);

    /**
     * 删除教室
     *
     * @param classroom 教室信息
     * @return
     */
    @Delete("delete from Classroom where id=#{id}")
    int delete(Classroom classroom);

    /**
     * 更新教室信息
     *
     * @param classroom 教室信息
     * @return
     */
    @Update("update Classroom set volume=#{volume} where id=#{id}")
    int update(Classroom classroom);


    /**
     * 获得学校全部教学楼
     *
     * @param classroom 教室信息
     * @return
     */
    @Select("select * from Classroom where school_id=#{school_id}")
    List<Classroom> getAddress(Classroom classroom);
}
