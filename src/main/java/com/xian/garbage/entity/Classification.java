package com.xian.garbage.entity;

import java.io.Serializable;

/**
 * (Classification)实体类
 *
 * @author guo
 * @since 2022-03-26 11:14:34
 */
public class Classification implements Serializable {
    private static final long serialVersionUID = 930369747333289693L;
    /**
    * 垃圾分类编号
    */
    private Integer classificationId;
    /**
    * 垃圾分类名
    */
    private String classificationName;
    /**
    * 垃圾类型
    */
    private String typeName;

    public Classification() {
        super();
    }

    public Classification(Integer classificationId, String classificationName, String typeName) {
        this.classificationId = classificationId;
        this.classificationName = classificationName;
        this.typeName = typeName;
    }


    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "classificationId=" + classificationId +
                ", classificationName='" + classificationName + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}