package com.xian.garbage.service;

import com.xian.garbage.entity.Transport;
import java.util.List;

/**
 * (Transport)表服务接口
 *
 * @author guo
 * @since 2022-03-27 10:16:51
 */
public interface TransportService {

    //运输记录数量
    int count();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param transport 实例对象
     * @return 对象列表
     */
    List<Transport> queryAll(Transport transport);
    /**
     * 通过ID查询单条数据
     *
     * @param transportId 主键
     * @return 实例对象
     */
    Transport queryById(Integer transportId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Transport> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param transport 实例对象
     * @return 实例对象
     */
    Transport insert(Transport transport);

    /**
     * 修改数据
     *
     * @param transport 实例对象
     * @return 实例对象
     */
    Transport update(Transport transport);

    /**
     * 通过主键删除数据
     *
     * @param transportId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer transportId);

}