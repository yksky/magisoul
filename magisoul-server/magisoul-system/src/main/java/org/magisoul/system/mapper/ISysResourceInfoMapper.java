package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysResourceInfo;
import org.magisoul.system.model.query.QuerySysResourceInfoVo;

import java.util.List;

public interface ISysResourceInfoMapper {

    public Integer add(SysResourceInfo sysResourceInfo);

    public Integer updateForm(SysResourceInfo sysResourceInfo);

    public Integer updateById(SysResourceInfo sysResourceInfo);

    public SysResourceInfo getById(@Param("id")Long id);

    public List<SysResourceInfo> list(QuerySysResourceInfoVo querySysResourceInfoVo);

    public Long count(QuerySysResourceInfoVo querySysResourceInfoVo);

    public List<SysResourceInfo> getExistByName(@Param("id")Long id,@Param("resourceName")String resourceName);

}
