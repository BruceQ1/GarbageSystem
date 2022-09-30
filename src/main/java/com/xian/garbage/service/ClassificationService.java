package com.xian.garbage.service;

import com.xian.garbage.entity.Classification;
import java.util.List;

/**
 * (Classification)表服务接口
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public interface ClassificationService {

    //垃圾分类数量
    int count();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param classification 实例对象
     * @return 对象列表
     */
    List<Classification> queryAll(Classification classification);
    /**
     * 通过ID查询单条数据
     *
     * @param classificationId 主键
     * @return 实例对象
     */
    Classification queryById(Integer classificationId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Classification> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    Classification insert(Classification classification);

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    Classification update(Classification classification);

    /**
     * 通过主键删除数据
     *
     * @param classificationId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer classificationId);

}