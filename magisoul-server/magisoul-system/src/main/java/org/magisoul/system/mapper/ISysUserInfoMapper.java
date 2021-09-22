package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.model.query.QuerySysUserInfoVo;

import java.util.List;

public interface ISysUserInfoMapper {

    public Integer add(SysUserInfo sysUserInfo);

    public Integer updateForm(SysUserInfo sysUserInfo);

    public Integer updateById(SysUserInfo sysUserInfo);

    public SysUserInfo getById(@Param("id")Long id);

    public List<SysUserInfo> list(QuerySysUserInfoVo querySysUserInfoVo);

    public Long count(QuerySysUserInfoVo querySysUserInfoVo);

    public List<SysUserInfo> getExistByName(@Param("id")Long id,@Param("username")String username);

}
