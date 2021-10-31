package org.magisoul.gcode.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import java.util.Date;

public class GcDbConfigInfoDto {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id ;
    private String dbAppName ;
    private String dbUrl ;
    private String dbPassword ;
    private String dbDriver ;
    private String dbUsername ;
    private String dbSchema ;
    private String dbType ;
    private String enableStatus ;
    private String isDeleted ;
    private Date createTime ;
    private String creator ;
    private Date updateTime ;
    private String updator ;

    public GcDbConfigInfoDto(){

    }

    public GcDbConfigInfoDto(Long id,String dbAppName){
        this.id = id ;
        this.dbAppName = dbAppName ;
    }

    public String getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(String schema) {
        this.dbSchema = dbSchema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDbAppName() {
        return dbAppName;
    }

    public void setDbAppName(String dbAppName) {
        this.dbAppName = dbAppName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }
}
