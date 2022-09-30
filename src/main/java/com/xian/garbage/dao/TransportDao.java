package com.xian.garbage.dao;

import com.xian.garbage.entity.Transport;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Transport)表数据库访问层
 *
 * @author guo
 * @since 2022-03-27 10:16:50
 */
public interface TransportDao {

    //运输记录数量
    int count();
    /**
     * 通过ID查询单条数据
     *
     * @param transportId 主键
     * @return 实例对象
     */
    Transport queryById(Integer transportId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Transport> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param transport 实例对象
     * @return 对象列表
     */
    List<Transport> queryAll(Transport transport);

    /**
     * 新增数据
     *
     * @param transport 实例对象
     * @return 影响行数
     */
    int insert(Transport transport);

    /**
     * 修改数据
     *
     * @param transport 实例对象
     * @return 影响行数
     */
    int update(Transport transport);

    /**
     * 通过主键删除数据
     *
     * @param transportId 主键
     * @return 影响行数
     */
    int deleteById(Integer transportId);

}