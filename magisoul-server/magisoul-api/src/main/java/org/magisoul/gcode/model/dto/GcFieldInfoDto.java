package org.magisoul.gcode.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import java.util.Date;

public class GcFieldInfoDto {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id ;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long jobId ;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long tableId ;
    private String fieldName ;
    private String fieldComment ;
    private String fieldDesc ;
    private String fieldClassName ;
    private String fieldEntityName ;
    private String isPrimaryField ;
    private String primaryType ;
    private String isAddField ;
    private String isEditField ;
    private String isQueryField ;
    private String isListField ;
    private String isDeleteField ;
    private String deleteValue ;
    private String notDeleteValue ;
    private Date createTime ;
    private String creator ;
    private Date updateTime ;
    private String updator ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public String getFieldClassName() {
        return fieldClassName;
    }

    public void setFieldClassName(String fieldClassName) {
        this.fieldClassName = fieldClassName;
    }

    public String getFieldEntityName() {
        return fieldEntityName;
    }

    public void setFieldEntityName(String fieldEntityName) {
        this.fieldEntityName = fieldEntityName;
    }

    public String getIsPrimaryField() {
        return isPrimaryField;
    }

    public void setIsPrimaryField(String isPrimaryField) {
        this.isPrimaryField = isPrimaryField;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getIsAddField() {
        return isAddField;
    }

    public void setIsAddField(String isAddField) {
        this.isAddField = isAddField;
    }

    public String getIsEditField() {
        return isEditField;
    }

    public void setIsEditField(String isEditField) {
        this.isEditField = isEditField;
    }

    public String getIsQueryField() {
        return isQueryField;
    }

    public void setIsQueryField(String isQueryField) {
        this.isQueryField = isQueryField;
    }

    public String getIsListField() {
        return isListField;
    }

    public void setIsListField(String isListField) {
        this.isListField = isListField;
    }

    public String getIsDeleteField() {
        return isDeleteField;
    }

    public void setIsDeleteField(String isDeleteField) {
        this.isDeleteField = isDeleteField;
    }

    public String getDeleteValue() {
        return deleteValue;
    }

    public void setDeleteValue(String deleteValue) {
        this.deleteValue = deleteValue;
    }

    public String getNotDeleteValue() {
        return notDeleteValue;
    }

    public void setNotDeleteValue(String notDeleteValue) {
        this.notDeleteValue = notDeleteValue;
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
