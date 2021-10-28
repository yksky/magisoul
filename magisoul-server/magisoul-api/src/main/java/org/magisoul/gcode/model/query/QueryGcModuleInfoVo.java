package org.magisoul.gcode.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QueryGcModuleInfoVo extends QueryPageVo {

    private Long jobId ;
    private String enableStatus ;
    private String isDeleted ;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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
}
