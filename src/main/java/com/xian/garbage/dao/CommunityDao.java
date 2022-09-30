package com.xian.garbage.dao;

import com.xian.garbage.entity.Community;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Community)表数据库访问层
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Mapper
public interface CommunityDao {

    //小区数量
    int count();
    /**
     * 通过ID查询单条数据
     *
     * @param communityId 主键
     * @return 实例对象
     */
    Community queryById(Integer communityId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Community> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param community 实例对象
     * @return 对象列表
     */
    List<Community> queryAll(Community community);

    /**
     * 新增数据
     *
     * @param community 实例对象
     * @return 影响行数
     */
    int insert(Community community);

    /**
     * 修改数据
     *
     * @param community 实例对象
     * @return 影响行数
     */
    int update(Community community);

    /**
     * 通过主键删除数据
     *
     * @param communityId 主键
     * @return 影响行数
     */
    int deleteById(Integer communityId);

}