package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Classification;
import com.xian.garbage.dao.ClassificationDao;
import com.xian.garbage.service.ClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classification)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Service("classificationService")
public class ClassificationServiceImpl implements ClassificationService {
    @Resource
    private ClassificationDao classificationDao;

    @Override
    public int count() {
        return this.classificationDao.count();
    }

    @Override
    public List<Classification> queryAll(Classification classification) {
        return this.classificationDao.queryAll(classification);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param classificationId 主键
     * @return 实例对象
     */
    @Override
    public Classification queryById(Integer classificationId) {
        return this.classificationDao.queryById(classificationId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Classification> queryAllByLimit(int offset, int limit) {
        return this.classificationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    @Override
    public Classification insert(Classification classification) {
        this.classificationDao.insert(classification);
        return classification;
    }

    /**
     * 修改数据
     *
     * @param classification 实例对象
     * @return 实例对象
     */
    @Override
    public Classification update(Classification classification) {
        this.classificationDao.update(classification);
        return this.queryById(classification.getClassificationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param classificationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer classificationId) {
        return this.classificationDao.deleteById(classificationId) > 0;
    }
}