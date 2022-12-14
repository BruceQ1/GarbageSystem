package com.xian.garbage.dao;

import com.xian.garbage.entity.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Repair)表数据库访问层
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Mapper
public interface RepairDao {

    //维修记录数量
    int count();
    /**
     * 通过ID查询单条数据
     *
     * @param repairId 主键
     * @return 实例对象
     */
    Repair queryById(Integer repairId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Repair> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param repair 实例对象
     * @return 对象列表
     */
    List<Repair> queryAll(Repair repair);

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 影响行数
     */
    int insert(Repair repair);

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 影响行数
     */
    int update(Repair repair);

    /**
     * 通过主键删除数据
     *
     * @param repairId 主键
     * @return 影响行数
     */
    int deleteById(Integer repairId);

}