package org.magisoul.gcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.entity.GcJobInfo;
import org.magisoul.gcode.model.query.QueryGcJobInfoVo;

import java.util.List;

public interface IGcJobInfoMapper {

    public Integer add(GcJobInfo gcJobInfo);

    public Integer updateForm(GcJobInfo gcJobInfo);

    public Integer updateById(GcJobInfo gcJobInfo);

    public GcJobInfo getById(@Param("id")Long id);

    public List<GcJobInfo> list(QueryGcJobInfoVo queryGcJobInfoVo);

    public Long count(QueryGcJobInfoVo queryGcJobInfoVo);

    public List<GcJobInfo> getExistByName(@Param("id")Long id,@Param("jobName")String jobName);
}
