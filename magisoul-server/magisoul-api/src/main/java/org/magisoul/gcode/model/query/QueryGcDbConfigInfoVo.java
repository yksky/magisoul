package org.magisoul.gcode.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QueryGcDbConfigInfoVo extends QueryPageVo {

    private String isDeleted ;
    private String enableStatus ;
    private String dbType ;

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

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}
