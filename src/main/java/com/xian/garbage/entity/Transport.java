package com.xian.garbage.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Transport)实体类
 *
 * @author guo
 * @since 2022-03-27 10:16:49
 */
public class Transport implements Serializable {
    private static final long serialVersionUID = 484471494355261062L;
    /**
    * 运输id
    */
    private Integer transportId;
    /**
    * 车牌号码
    */
    private String transportCar;
    /**
    * 运输数量
    */
    private Integer transportWeight;
    /**
    * 运输时间
    */
    private Date transportTime;
    /**
    * 小区名字：运来
    */
    private String communityName;
    /**
    * 垃圾站：运往
    */
    private String stationName;
    /**
    * 垃圾类型
    */
    private String classificationType;
    /**
    * 运输状态：运输中，已完成
    */
    private String transportStatus;


    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public String getTransportCar() {
        return transportCar;
    }

    public void setTransportCar(String transportCar) {
        this.transportCar = transportCar;
    }

    public Integer getTransportWeight() {
        return transportWeight;
    }

    public void setTransportWeight(Integer transportWeight) {
        this.transportWeight = transportWeight;
    }

    public Date getTransportTime() {
        return transportTime;
    }

    public void setTransportTime(Date transportTime) {
        this.transportTime = transportTime;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getClassificationType() {
        return classificationType;
    }

    public void setClassificationType(String classificationType) {
        this.classificationType = classificationType;
    }

    public String getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(String transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Transport() {
        super();
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportId=" + transportId +
                ", transportCar='" + transportCar + '\'' +
                ", transportWeight=" + transportWeight +
                ", transportTime=" + transportTime +
                ", communityName='" + communityName + '\'' +
                ", stationName='" + stationName + '\'' +
                ", classificationType='" + classificationType + '\'' +
                ", transportStatus='" + transportStatus + '\'' +
                '}';
    }

    public Transport(Integer transportId, String transportCar, Integer transportWeight, Date transportTime, String communityName, String stationName, String classificationType, String transportStatus) {
        this.transportId = transportId;
        this.transportCar = transportCar;
        this.transportWeight = transportWeight;
        this.transportTime = transportTime;
        this.communityName = communityName;
        this.stationName = stationName;
        this.classificationType = classificationType;
        this.transportStatus = transportStatus;
    }
}