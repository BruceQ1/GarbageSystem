package com.xian.garbage.dao;

import com.xian.garbage.entity.Hygienist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Hygienist)表数据库访问层
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Mapper
public interface HygienistDao {

    //卫生员数量
    int count();
    /**
     * 通过ID查询单条数据
     *
     * @param hygienistId 主键
     * @return 实例对象
     */
    Hygienist queryById(Integer hygienistId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hygienist> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param hygienist 实例对象
     * @return 对象列表
     */
    List<Hygienist> queryAll(Hygienist hygienist);

    /**
     * 新增数据
     *
     * @param hygienist 实例对象
     * @return 影响行数
     */
    int insert(Hygienist hygienist);

    /**
     * 修改数据
     *
     * @param hygienist 实例对象
     * @return 影响行数
     */
    int update(Hygienist hygienist);

    /**
     * 通过主键删除数据
     *
     * @param hygienistId 主键
     * @return 影响行数
     */
    int deleteById(Integer hygienistId);

}