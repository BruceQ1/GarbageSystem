package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Repair;
import com.xian.garbage.dao.RepairDao;
import com.xian.garbage.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Repair)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Service("repairService")
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairDao repairDao;

    @Override
    public int count() {
        return this.repairDao.count();
    }

    @Override
    public List<Repair> queryAll(Repair repair) {
        return this.repairDao.queryAll(repair);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param repairId 主键
     * @return 实例对象
     */
    @Override
    public Repair queryById(Integer repairId) {
        return this.repairDao.queryById(repairId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Repair> queryAllByLimit(int offset, int limit) {
        return this.repairDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair insert(Repair repair) {
        this.repairDao.insert(repair);
        return repair;
    }

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair update(Repair repair) {
        this.repairDao.update(repair);
        return this.queryById(repair.getRepairId());
    }

    /**
     * 通过主键删除数据
     *
     * @param repairId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer repairId) {
        return this.repairDao.deleteById(repairId) > 0;
    }
}