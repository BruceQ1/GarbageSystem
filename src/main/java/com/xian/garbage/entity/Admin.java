package com.xian.garbage.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:32
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -85808932624020635L;
    /**
    * 管理员id
    */
    private Integer adminId;
    /**
    * 管理员账号
    */
    private String adminName;
    /**
    * 管理员密码
    */
    private String adminPassword;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Admin() {
        super();
    }

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public Admin(Integer adminId, String adminName, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
}