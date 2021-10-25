package org.magisoul.gcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.entity.GcModuleInfo;
import org.magisoul.gcode.model.query.QueryGcModuleInfoVo;

import java.util.List;

public interface IGcModuleInfoMapper {

    public Integer add(GcModuleInfo gcModuleInfo);

    public Integer updateForm(GcModuleInfo gcModuleInfo);

    public Integer updateById(GcModuleInfo gcModuleInfo);

    public GcModuleInfo getById(@Param("id")Long id);

    public List<GcModuleInfo> list(QueryGcModuleInfoVo queryGcModuleInfoVo);

    public Long count(QueryGcModuleInfoVo queryGcModuleInfoVo);

    public List<GcModuleInfo> getExistByName(@Param("id")Long id,@Param("moduleName")String moduleName);

}
