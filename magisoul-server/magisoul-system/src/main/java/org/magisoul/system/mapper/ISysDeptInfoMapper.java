package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysDeptInfo;
import org.magisoul.system.model.query.QuerySysDeptInfoVo;

import java.util.List;

public interface ISysDeptInfoMapper {

    public Integer add(SysDeptInfo sysDeptInfo);

    public Integer updateForm(SysDeptInfo sysDeptInfo);

    public Integer updateById(SysDeptInfo sysDeptInfo);

    public SysDeptInfo getById(@Param("id") Long id);

    public List<SysDeptInfo> list(QuerySysDeptInfoVo querySysDeptInfoVo);

    public Long count(QuerySysDeptInfoVo querySysDeptInfoVo);

    public List<SysDeptInfo> getExistByName(@Param("id")Long id,@Param("deptName")String deptName);

}
