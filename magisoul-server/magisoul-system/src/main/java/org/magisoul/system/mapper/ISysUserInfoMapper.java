package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysUserInfo;

public interface ISysUserInfoMapper {

    public Long addSysUserInfo(SysUserInfo sysUserInfo);

    public Long updateSysUserInfoForm(SysUserInfo sysUserInfo);

    public Long updateSysUserInfoById(SysUserInfo sysUserInfo);

    public SysUserInfo getSysUserInfoById(@Param("id")Long id);

}
