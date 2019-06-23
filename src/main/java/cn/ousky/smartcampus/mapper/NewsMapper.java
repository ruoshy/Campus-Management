package cn.ousky.smartcampus.mapper;

import cn.ousky.smartcampus.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {

    /**
     * 根据给定信息进行查询
     *
     * @param news 新闻信息
     * @return
     */
    @Select("<script>" +
            "select * from News where 1=1" +
            "<if test='id!=null'>" +
            " and id=#{id}" +
            "</if>" +
            "<if test='administrators_id!=null'>" +
            " and administrators_id=#{administrators_id}" +
            "</if>" +
            "</script>")
    List<News> select(News news);

    /**
     * 插入新闻
     *
     * @param news 新闻信息
     * @return
     */
    @Insert("insert into News(name,resource,date,administrators_id) " +
            "values(#{name},#{resource},#{date},#{administrators_id})")
    int insert(News news);

    /**
     * 删除新闻
     *
     * @param news 新闻信息
     * @return
     */
    @Delete("delete from News where id=#{id} and administrators_id=#{administrators_id}")
    int delete(News news);

    /**
     * 更新新闻信息
     *
     * @param news 新闻信息
     * @return
     */
    @Update("update News set name=#{name},resource=#{resource} " +
            "where id=#{id} and administrators_id=#{administrators_id}")
    int update(News news);
}
