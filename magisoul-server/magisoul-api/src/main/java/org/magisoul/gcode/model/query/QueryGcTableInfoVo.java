package org.magisoul.gcode.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QueryGcTableInfoVo extends QueryPageVo {

    private Long jobId ;
    private Long moduleId ;
    private String isDeleted ;
    private String enableStatus ;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus;
    }
}
