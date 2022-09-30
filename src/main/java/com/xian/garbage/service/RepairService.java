package com.xian.garbage.service;

import com.xian.garbage.entity.Repair;
import java.util.List;

/**
 * (Repair)表服务接口
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public interface RepairService {

    //维修记录数量
    int count();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param repair 实例对象
     * @return 对象列表
     */
    List<Repair> queryAll(Repair repair);
    /**
     * 通过ID查询单条数据
     *
     * @param repairId 主键
     * @return 实例对象
     */
    Repair queryById(Integer repairId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Repair> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair insert(Repair repair);

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair update(Repair repair);

    /**
     * 通过主键删除数据
     *
     * @param repairId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer repairId);

}