package com.xian.garbage.dao;

import com.xian.garbage.entity.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Station)表数据库访问层
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
@Mapper
public interface StationDao {

    //垃圾站数量
    int count();
    /**
     * 通过ID查询单条数据
     *
     * @param stationId 主键
     * @return 实例对象
     */
    Station queryById(Integer stationId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Station> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param station 实例对象
     * @return 对象列表
     */
    List<Station> queryAll(Station station);

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 影响行数
     */
    int insert(Station station);

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 影响行数
     */
    int update(Station station);

    /**
     * 通过主键删除数据
     *
     * @param stationId 主键
     * @return 影响行数
     */
    int deleteById(Integer stationId);

}