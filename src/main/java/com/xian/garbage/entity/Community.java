package com.xian.garbage.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Community)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public class Community implements Serializable {
    private static final long serialVersionUID = -51047855951846107L;
    /**
    * 小区id
    */
    private Integer communityId;
    /**
    * 小区名
    */
    private String communityName;
    /**
    * 联系人：卫生员
    */
    private String hygienistName;
    /**
    * 联系邮箱
    */
    private String hygienistMail;
    /**
    * 联系电话
    */
    private String hygienistPhone;
    /**
    * 创建时间
    */
    private Date communityCreate;

    public Community() {
        super();
    }

    public Community(Integer communityId, String communityName, String hygienistName, String hygienistMail, String hygienistPhone, Date communityCreate) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.hygienistName = hygienistName;
        this.hygienistMail = hygienistMail;
        this.hygienistPhone = hygienistPhone;
        this.communityCreate = communityCreate;
    }


    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getHygienistName() {
        return hygienistName;
    }

    public void setHygienistName(String hygienistName) {
        this.hygienistName = hygienistName;
    }

    public String getHygienistMail() {
        return hygienistMail;
    }

    public void setHygienistMail(String hygienistMail) {
        this.hygienistMail = hygienistMail;
    }

    public String getHygienistPhone() {
        return hygienistPhone;
    }

    public void setHygienistPhone(String hygienistPhone) {
        this.hygienistPhone = hygienistPhone;
    }

    public Date getCommunityCreate() {
        return communityCreate;
    }

    public void setCommunityCreate(Date communityCreate) {
        this.communityCreate = communityCreate;
    }

    @Override
    public String toString() {
        return "Community{" +
                "communityId=" + communityId +
                ", communityName='" + communityName + '\'' +
                ", hygienistName='" + hygienistName + '\'' +
                ", hygienistMail='" + hygienistMail + '\'' +
                ", hygienistPhone='" + hygienistPhone + '\'' +
                ", communityCreate=" + communityCreate +
                '}';
    }
}