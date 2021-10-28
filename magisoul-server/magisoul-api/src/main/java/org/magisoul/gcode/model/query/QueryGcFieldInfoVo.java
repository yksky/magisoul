package org.magisoul.gcode.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QueryGcFieldInfoVo extends QueryPageVo {

    private Long jobId ;
    private Long tableId ;

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
