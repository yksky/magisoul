package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysRoleInfo;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;

import java.util.List;

public interface ISysRoleInfoMapper {

    public Integer add(SysRoleInfo sysRoleInfo);

    public Integer updateForm(SysRoleInfo sysRoleInfo);

    public Integer updateById(SysRoleInfo sysRoleInfo);

    public SysRoleInfo getById(@Param("id")Long id);

    public List<SysRoleInfo> list(QuerySysRoleInfoVo querySysRoleInfoVo);

    public Long count(QuerySysRoleInfoVo querySysRoleInfoVo);

    public List<SysRoleInfo> getExistByName(@Param("id")Long id,@Param("roleName")String roleName);

}
