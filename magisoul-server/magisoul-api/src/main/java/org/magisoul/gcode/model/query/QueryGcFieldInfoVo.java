package org.magisoul.gcode.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QueryGcFieldInfoVo extends QueryPageVo {

    private Long jobId ;
    private Long tableId ;
    private Long moduleId ;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
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
}
