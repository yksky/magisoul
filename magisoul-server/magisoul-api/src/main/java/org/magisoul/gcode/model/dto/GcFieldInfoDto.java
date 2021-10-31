package org.magisoul.gcode.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import java.util.Date;

public class GcFieldInfoDto {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long jobId;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long tableId;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long moduleId;
    private String dbFieldName;
    private String dbFieldComment;
    private String dbFieldType;
    private Long dbFieldSize;
    private String fieldDesc;
    private String fieldClassName;
    private String fieldEntityName;
    private String fieldType;
    private String fieldImport;
    private String isPrimaryField;
    private String primaryType;
    private String isAddField;
    private String isEditField;
    private String editType;
    private String isEditEmpty;
    private String isEditUnique;
    private String isQueryField;
    private String isListField;
    private String isDeleteField;
    private String deleteValue;
    private String notDeleteValue;
    private String isEnableField;
    private String enableValue;
    private String disableValue;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String updator;
    private String isInit;
    private Date initTime;
    private Integer seqNo;

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

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getDbFieldName() {
        return dbFieldName;
    }

    public void setDbFieldName(String dbFieldName) {
        this.dbFieldName = dbFieldName;
    }

    public String getDbFieldComment() {
        return dbFieldComment;
    }

    public void setDbFieldComment(String dbFieldComment) {
        this.dbFieldComment = dbFieldComment;
    }

    public String getDbFieldType() {
        return dbFieldType;
    }

    public void setDbFieldType(String dbFieldType) {
        this.dbFieldType = dbFieldType;
    }

    public Long getDbFieldSize() {
        return dbFieldSize;
    }

    public void setDbFieldSize(Long dbFieldSize) {
        this.dbFieldSize = dbFieldSize;
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

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldImport() {
        return fieldImport;
    }

    public void setFieldImport(String fieldImport) {
        this.fieldImport = fieldImport;
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

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getIsEditEmpty() {
        return isEditEmpty;
    }

    public void setIsEditEmpty(String isEditEmpty) {
        this.isEditEmpty = isEditEmpty;
    }

    public String getIsEditUnique() {
        return isEditUnique;
    }

    public void setIsEditUnique(String isEditUnique) {
        this.isEditUnique = isEditUnique;
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

    public String getIsEnableField() {
        return isEnableField;
    }

    public void setIsEnableField(String isEnableField) {
        this.isEnableField = isEnableField;
    }

    public String getEnableValue() {
        return enableValue;
    }

    public void setEnableValue(String enableValue) {
        this.enableValue = enableValue;
    }

    public String getDisableValue() {
        return disableValue;
    }

    public void setDisableValue(String disableValue) {
        this.disableValue = disableValue;
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

    public String getIsInit() {
        return isInit;
    }

    public void setIsInit(String isInit) {
        this.isInit = isInit;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
}
