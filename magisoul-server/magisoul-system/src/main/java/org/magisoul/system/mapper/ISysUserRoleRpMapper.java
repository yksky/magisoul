package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysUserRoleRp;

import java.util.List;

public interface ISysUserRoleRpMapper {

    public Integer add(SysUserRoleRp sysUserRoleRp);

    public Integer delete(SysUserRoleRp sysUserRoleRp);

    public List<SysUserRoleRp> list(@Param("userId")Long userId, @Param("roleId")Long roleId);

}
