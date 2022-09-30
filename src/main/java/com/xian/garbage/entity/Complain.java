package com.xian.garbage.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Complain)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public class Complain implements Serializable {
    private static final long serialVersionUID = 434319869362071697L;
    /**
    * 投诉id
    */
    private Integer complainId;
    /**
    * 投诉事件
    */
    private String complainTitle;
    /**
    * 投诉内容
    */
    private String complainContent;
    /**
    * 投诉卫生员
    */
    private String hygienistName;
    /**
    * 投诉时间
    */
    private Date complainTime;
    /**
    * 处理状态：投诉处理中，已联系业主
    */
    private String complainStatus;


    public Integer getComplainId() {
        return complainId;
    }

    public void setComplainId(Integer complainId) {
        this.complainId = complainId;
    }

    public String getComplainTitle() {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle) {
        this.complainTitle = complainTitle;
    }

    public String getComplainContent() {
        return complainContent;
    }

    public void setComplainContent(String complainContent) {
        this.complainContent = complainContent;
    }

    public String getHygienistName() {
        return hygienistName;
    }

    public void setHygienistName(String hygienistName) {
        this.hygienistName = hygienistName;
    }

    public Date getComplainTime() {
        return complainTime;
    }

    public void setComplainTime(Date complainTime) {
        this.complainTime = complainTime;
    }

    public String getComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(String complainStatus) {
        this.complainStatus = complainStatus;
    }

    public Complain() {
        super();
    }

    public Complain(Integer complainId, String complainTitle, String complainContent, String hygienistName, Date complainTime, String complainStatus) {
        this.complainId = complainId;
        this.complainTitle = complainTitle;
        this.complainContent = complainContent;
        this.hygienistName = hygienistName;
        this.complainTime = complainTime;
        this.complainStatus = complainStatus;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "complainId=" + complainId +
                ", complainTitle='" + complainTitle + '\'' +
                ", complainContent='" + complainContent + '\'' +
                ", hygienistName='" + hygienistName + '\'' +
                ", complainTime=" + complainTime +
                ", complainStatus='" + complainStatus + '\'' +
                '}';
    }
}