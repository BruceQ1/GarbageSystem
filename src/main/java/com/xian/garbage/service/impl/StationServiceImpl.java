package com.xian.garbage.service.impl;

import com.xian.garbage.entity.Station;
import com.xian.garbage.dao.StationDao;
import com.xian.garbage.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Station)表服务实现类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Service("stationService")
public class StationServiceImpl implements StationService {
    @Resource
    private StationDao stationDao;

    @Override
    public int count() {
        return this.stationDao.count();
    }

    @Override
    public List<Station> queryAll(Station station) {
        return this.stationDao.queryAll(station);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param stationId 主键
     * @return 实例对象
     */
    @Override
    public Station queryById(Integer stationId) {
        return this.stationDao.queryById(stationId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Station> queryAllByLimit(int offset, int limit) {
        return this.stationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public Station insert(Station station) {
        this.stationDao.insert(station);
        return station;
    }

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public Station update(Station station) {
        this.stationDao.update(station);
        return this.queryById(station.getStationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param stationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stationId) {
        return this.stationDao.deleteById(stationId) > 0;
    }
}