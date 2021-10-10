package org.magisoul.system.entity;

import java.io.Serializable;

public class SysUserDeptRp implements Serializable {

    private Long userId ;
    private Long deptId ;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

}
