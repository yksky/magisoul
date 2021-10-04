package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysDictInfo;
import org.magisoul.system.model.query.QuerySysDictInfoVo;

import java.util.List;

public interface ISysDictInfoMapper {

    public Integer add(SysDictInfo sysDictInfo);

    public Integer updateForm(SysDictInfo sysDictInfo);

    public Integer updateById(SysDictInfo sysDictInfo);

    public SysDictInfo getById(@Param("id")Long id);

    public List<SysDictInfo> list(QuerySysDictInfoVo querySysDictInfoVo);

    public Long count(QuerySysDictInfoVo querySysDictInfoVo);

    public List<SysDictInfo> getExistByName(@Param("id")Long id,@Param("dictName")String dictName);

}
