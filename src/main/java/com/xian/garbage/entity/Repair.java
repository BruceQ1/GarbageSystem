package com.xian.garbage.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Repair)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public class Repair implements Serializable {
    private static final long serialVersionUID = -60735052610325336L;
    /**
    * 报修id
    */
    private Integer repairId;
    /**
    * 报修事件
    */
    private String repairTitle;
    /**
    * 报修内容
    */
    private String repairContent;
    /**
    * 报修卫生员
    */
    private String hygienistName;
    /**
    * 报修时间
    */
    private Date repairTime;
    /**
    * 处理状态：报修中，已维修
    */
    private String repairStatus;


    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getRepairTitle() {
        return repairTitle;
    }

    public void setRepairTitle(String repairTitle) {
        this.repairTitle = repairTitle;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public String getHygienistName() {
        return hygienistName;
    }

    public void setHygienistName(String hygienistName) {
        this.hygienistName = hygienistName;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Repair() {
        super();
    }

    public Repair(Integer repairId, String repairTitle, String repairContent, String hygienistName, Date repairTime, String repairStatus) {
        this.repairId = repairId;
        this.repairTitle = repairTitle;
        this.repairContent = repairContent;
        this.hygienistName = hygienistName;
        this.repairTime = repairTime;
        this.repairStatus = repairStatus;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", repairTitle='" + repairTitle + '\'' +
                ", repairContent='" + repairContent + '\'' +
                ", hygienistName='" + hygienistName + '\'' +
                ", repairTime=" + repairTime +
                ", repairStatus='" + repairStatus + '\'' +
                '}';
    }
}