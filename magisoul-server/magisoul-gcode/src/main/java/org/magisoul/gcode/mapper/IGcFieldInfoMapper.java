package org.magisoul.gcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.entity.GcFieldInfo;
import org.magisoul.gcode.model.query.QueryGcFieldInfoVo;

import java.util.List;

public interface IGcFieldInfoMapper {

    public Integer add(GcFieldInfo gcFieldInfo);

    public Integer updateForm(GcFieldInfo gcFieldInfo);

    public Integer updateById(GcFieldInfo gcFieldInfo);

    public GcFieldInfo getById(@Param("id")Long id);

    public List<GcFieldInfo> list(QueryGcFieldInfoVo queryGcFieldInfoVo);

    public Long count(QueryGcFieldInfoVo queryGcFieldInfoVo);

}
