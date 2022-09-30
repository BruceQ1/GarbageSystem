package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Transport;
import com.xian.garbage.dao.TransportDao;
import com.xian.garbage.service.TransportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Transport)表服务实现类
 *
 * @author guo
 * @since 2022-03-27 10:16:52
 */
@Service("transportService")
public class TransportServiceImpl implements TransportService {
    @Resource
    private TransportDao transportDao;

    @Override
    public int count() {
        return this.transportDao.count();
    }

    @Override
    public List<Transport> queryAll(Transport transport) {
        return this.transportDao.queryAll(transport);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param transportId 主键
     * @return 实例对象
     */
    @Override
    public Transport queryById(Integer transportId) {
        return this.transportDao.queryById(transportId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Transport> queryAllByLimit(int offset, int limit) {
        return this.transportDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param transport 实例对象
     * @return 实例对象
     */
    @Override
    public Transport insert(Transport transport) {
        this.transportDao.insert(transport);
        return transport;
    }

    /**
     * 修改数据
     *
     * @param transport 实例对象
     * @return 实例对象
     */
    @Override
    public Transport update(Transport transport) {
        this.transportDao.update(transport);
        return this.queryById(transport.getTransportId());
    }

    /**
     * 通过主键删除数据
     *
     * @param transportId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer transportId) {
        return this.transportDao.deleteById(transportId) > 0;
    }
}