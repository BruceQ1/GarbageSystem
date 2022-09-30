package com.xian.garbage.service;

import com.xian.garbage.entity.Community;
import java.util.List;

/**
 * (Community)表服务接口
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public interface CommunityService {
    //小区数量
    int count();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param community 实例对象
     * @return 对象列表
     */
    List<Community> queryAll(Community community);

    /**
     * 通过ID查询单条数据
     *
     * @param communityId 主键
     * @return 实例对象
     */
    Community queryById(Integer communityId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Community> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param community 实例对象
     * @return 实例对象
     */
    Community insert(Community community);

    /**
     * 修改数据
     *
     * @param community 实例对象
     * @return 实例对象
     */
    Community update(Community community);

    /**
     * 通过主键删除数据
     *
     * @param communityId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer communityId);

}