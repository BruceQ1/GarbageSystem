package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Complain;
import com.xian.garbage.dao.ComplainDao;
import com.xian.garbage.service.ComplainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Complain)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Service("complainService")
public class ComplainServiceImpl implements ComplainService {
    @Resource
    private ComplainDao complainDao;

    @Override
    public int count() {
        return this.complainDao.count();
    }

    @Override
    public List<Complain> queryAll(Complain complain) {
        return this.complainDao.queryAll(complain);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param complainId 主键
     * @return 实例对象
     */
    @Override
    public Complain queryById(Integer complainId) {
        return this.complainDao.queryById(complainId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Complain> queryAllByLimit(int offset, int limit) {
        return this.complainDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    @Override
    public Complain insert(Complain complain) {
        this.complainDao.insert(complain);
        return complain;
    }

    /**
     * 修改数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    @Override
    public Complain update(Complain complain) {
        this.complainDao.update(complain);
        return this.queryById(complain.getComplainId());
    }

    /**
     * 通过主键删除数据
     *
     * @param complainId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer complainId) {
        return this.complainDao.deleteById(complainId) > 0;
    }
}