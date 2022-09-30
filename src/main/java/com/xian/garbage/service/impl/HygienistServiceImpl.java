package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.dao.HygienistDao;
import com.xian.garbage.service.HygienistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hygienist)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Service("hygienistService")
public class HygienistServiceImpl implements HygienistService {
    @Resource
    private HygienistDao hygienistDao;

    @Override
    public int count() {
        return this.hygienistDao.count();
    }

    @Override
    public List<Hygienist> queryAll(Hygienist hygienist) {
        return this.hygienistDao.queryAll(hygienist);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param hygienistId 主键
     * @return 实例对象
     */
    @Override
    public Hygienist queryById(Integer hygienistId) {
        return this.hygienistDao.queryById(hygienistId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Hygienist> queryAllByLimit(int offset, int limit) {
        return this.hygienistDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hygienist 实例对象
     * @return 实例对象
     */
    @Override
    public Hygienist insert(Hygienist hygienist) {
        this.hygienistDao.insert(hygienist);
        return hygienist;
    }

    /**
     * 修改数据
     *
     * @param hygienist 实例对象
     * @return 实例对象
     */
    @Override
    public Hygienist update(Hygienist hygienist) {
        this.hygienistDao.update(hygienist);
        return this.queryById(hygienist.getHygienistId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hygienistId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer hygienistId) {
        return this.hygienistDao.deleteById(hygienistId) > 0;
    }
}