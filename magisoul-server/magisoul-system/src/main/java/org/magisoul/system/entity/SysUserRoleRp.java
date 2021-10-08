package org.magisoul.system.entity;

import java.io.Serializable;

public class SysUserRoleRp implements Serializable {

    private Long userId ;
    private Long roleId ;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
