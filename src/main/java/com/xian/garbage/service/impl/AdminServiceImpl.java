package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Admin;
import com.xian.garbage.dao.AdminDao;
import com.xian.garbage.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:33
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public List<Admin> queryAll(Admin admin) {
        return this.adminDao.queryAll(admin);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer adminId) {
        return this.adminDao.queryById(adminId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminId) {
        return this.adminDao.deleteById(adminId) > 0;
    }
}