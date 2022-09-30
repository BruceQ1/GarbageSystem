package com.xian.garbage.entity;

import java.io.Serializable;

/**
 * (Station)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public class Station implements Serializable {
    private static final long serialVersionUID = 607881970899982978L;
    /**
    * 垃圾站id
    */
    private Integer stationId;
    /**
    * 垃圾站名
    */
    private String stationName;
    /**
    * 垃圾站类型
    */
    private String stationType;
    /**
    * 联系人
    */
    private String stationContact;


    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getStationContact() {
        return stationContact;
    }

    public void setStationContact(String stationContact) {
        this.stationContact = stationContact;
    }

    public Station() {
        super();
    }

    public Station(Integer stationId, String stationName, String stationType, String stationContact) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.stationType = stationType;
        this.stationContact = stationContact;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                ", stationType='" + stationType + '\'' +
                ", stationContact='" + stationContact + '\'' +
                '}';
    }
}