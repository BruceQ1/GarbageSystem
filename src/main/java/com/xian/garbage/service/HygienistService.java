package com.xian.garbage.service;

import com.xian.garbage.entity.Hygienist;
import java.util.List;

/**
 * (Hygienist)表服务接口
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public interface HygienistService {

    //卫生员数量
    int count();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param hygienist 实例对象
     * @return 对象列表
     */
    List<Hygienist> queryAll(Hygienist hygienist);

    /**
     * 通过ID查询单条数据
     *
     * @param hygienistId 主键
     * @return 实例对象
     */
    Hygienist queryById(Integer hygienistId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hygienist> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param hygienist 实例对象
     * @return 实例对象
     */
    Hygienist insert(Hygienist hygienist);

    /**
     * 修改数据
     *
     * @param hygienist 实例对象
     * @return 实例对象
     */
    Hygienist update(Hygienist hygienist);

    /**
     * 通过主键删除数据
     *
     * @param hygienistId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer hygienistId);

}