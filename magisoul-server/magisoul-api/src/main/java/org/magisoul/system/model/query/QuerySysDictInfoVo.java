package org.magisoul.system.model.query;

import org.magisoul.util.model.QueryPageVo;

public class QuerySysDictInfoVo extends QueryPageVo {

    private String dictType ;
    private String enableStatus ;
    private String isDeleted ;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
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
