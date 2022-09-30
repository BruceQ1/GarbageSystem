package com.xian.garbage.service;

import com.xian.garbage.entity.Complain;
import java.util.List;

/**
 * (Complain)表服务接口
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public interface ComplainService {

    //投诉记录数量
    int count();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param complain 实例对象
     * @return 对象列表
     */
    List<Complain> queryAll(Complain complain);
    /**
     * 通过ID查询单条数据
     *
     * @param complainId 主键
     * @return 实例对象
     */
    Complain queryById(Integer complainId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Complain> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    Complain insert(Complain complain);

    /**
     * 修改数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    Complain update(Complain complain);

    /**
     * 通过主键删除数据
     *
     * @param complainId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer complainId);

}