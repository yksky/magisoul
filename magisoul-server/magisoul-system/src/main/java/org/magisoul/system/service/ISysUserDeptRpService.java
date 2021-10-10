package org.magisoul.system.service;

import org.magisoul.system.entity.SysUserDeptRp;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysUserDeptRpService {

    public RespData<String> add(SysUserDeptRp sysUserDeptRp);

    public RespData<String> delete(SysUserDeptRp sysUserDeptRp);

    public RespData<List<SysUserDeptRp>> list(Long userId, Long deptId);

}
