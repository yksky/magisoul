package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysDictItemInfo;
import org.magisoul.system.model.query.QuerySysDictItemInfoVo;

import java.util.List;

public interface ISysDictItemInfoMapper {

    public Integer add(SysDictItemInfo sysDictItemInfo);

    public Integer updateForm(SysDictItemInfo sysDictItemInfo);

    public Integer updateById(SysDictItemInfo sysDictItemInfo);

    public SysDictItemInfo getById(@Param("id")Long id);

    public List<SysDictItemInfo> list(QuerySysDictItemInfoVo querySysDictItemInfoVo);

    public Long count(QuerySysDictItemInfoVo querySysDictItemInfoVo);

    public List<SysDictItemInfo> getExistByName(@Param("id")Long id,@Param("itemName")String itemName);

}
