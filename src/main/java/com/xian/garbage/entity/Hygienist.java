package com.xian.garbage.entity;

import java.io.Serializable;

/**
 * (Hygienist)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public class Hygienist implements Serializable {
    private static final long serialVersionUID = 518836971640622196L;
    /**
    * 卫生员id
    */
    private Integer hygienistId;
    /**
    * 卫生员名字
    */
    private String hygienistName;
    /**
    * 卫生员密码
    */
    private String hygienistPassword;
    /**
    * 卫生员性别
    */
    private String hygienistSex;
    /**
    * 卫生员年龄
    */
    private Integer hygienistAge;
    /**
    * 卫生员电话
    */
    private String hygienistPhone;
    /**
    * 卫生员邮箱
    */
    private String hygienistMail;


    public Integer getHygienistId() {
        return hygienistId;
    }

    public void setHygienistId(Integer hygienistId) {
        this.hygienistId = hygienistId;
    }

    public String getHygienistName() {
        return hygienistName;
    }

    public void setHygienistName(String hygienistName) {
        this.hygienistName = hygienistName;
    }

    public String getHygienistPassword() {
        return hygienistPassword;
    }

    public void setHygienistPassword(String hygienistPassword) {
        this.hygienistPassword = hygienistPassword;
    }

    public String getHygienistSex() {
        return hygienistSex;
    }

    public void setHygienistSex(String hygienistSex) {
        this.hygienistSex = hygienistSex;
    }

    public Integer getHygienistAge() {
        return hygienistAge;
    }

    public void setHygienistAge(Integer hygienistAge) {
        this.hygienistAge = hygienistAge;
    }

    public String getHygienistPhone() {
        return hygienistPhone;
    }

    public void setHygienistPhone(String hygienistPhone) {
        this.hygienistPhone = hygienistPhone;
    }

    public String getHygienistMail() {
        return hygienistMail;
    }

    public void setHygienistMail(String hygienistMail) {
        this.hygienistMail = hygienistMail;
    }

    public Hygienist() {
        super();
    }

    @Override
    public String toString() {
        return "Hygienist{" +
                "hygienistId=" + hygienistId +
                ", hygienistName='" + hygienistName + '\'' +
                ", hygienistPassword='" + hygienistPassword + '\'' +
                ", hygienistSex='" + hygienistSex + '\'' +
                ", hygienistAge=" + hygienistAge +
                ", hygienistPhone='" + hygienistPhone + '\'' +
                ", hygienistMail='" + hygienistMail + '\'' +
                '}';
    }

    public Hygienist(Integer hygienistId, String hygienistPassword) {
        this.hygienistId = hygienistId;
        this.hygienistPassword = hygienistPassword;
    }

    public Hygienist(Integer hygienistId, String hygienistName, String hygienistPassword, String hygienistSex, Integer hygienistAge, String hygienistPhone, String hygienistMail) {
        this.hygienistId = hygienistId;
        this.hygienistName = hygienistName;
        this.hygienistPassword = hygienistPassword;
        this.hygienistSex = hygienistSex;
        this.hygienistAge = hygienistAge;
        this.hygienistPhone = hygienistPhone;
        this.hygienistMail = hygienistMail;
    }
}