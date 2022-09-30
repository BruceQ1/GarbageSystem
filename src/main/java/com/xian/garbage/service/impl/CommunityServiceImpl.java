package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Community;
import com.xian.garbage.dao.CommunityDao;
import com.xian.garbage.service.CommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Community)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Service("communityService")
public class CommunityServiceImpl implements CommunityService {
    @Resource
    private CommunityDao communityDao;

    @Override
    public int count() {
        return this.communityDao.count();
    }

    @Override
    public List<Community> queryAll(Community community) {
        return this.communityDao.queryAll(community);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param communityId 主键
     * @return 实例对象
     */
    @Override
    public Community queryById(Integer communityId) {
        return this.communityDao.queryById(communityId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Community> queryAllByLimit(int offset, int limit) {
        return this.communityDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param community 实例对象
     * @return 实例对象
     */
    @Override
    public Community insert(Community community) {
        this.communityDao.insert(community);
        return community;
    }

    /**
     * 修改数据
     *
     * @param community 实例对象
     * @return 实例对象
     */
    @Override
    public Community update(Community community) {
        this.communityDao.update(community);
        return this.queryById(community.getCommunityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param communityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer communityId) {
        return this.communityDao.deleteById(communityId) > 0;
    }
}