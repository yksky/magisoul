package org.magisoul.system.api.impl;

import org.magisoul.system.api.ISysDeptInfoApi;
import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.system.model.query.QuerySysDeptInfoVo;
import org.magisoul.system.service.ISysDeptInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDeptInfoApi")
public class SysDeptInfoApiImpl implements ISysDeptInfoApi {

    @Autowired
    private ISysDeptInfoService sysDeptInfoService ;

    @Override
    public RespData<String> mergeForm(SysDeptInfoDto sysDeptInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateById(SysDeptInfoDto sysDeptInfoDto) {
        return null;
    }

    @Override
    public RespData<SysDeptInfoDto> getById(SysDeptInfoDto sysDeptInfoDto) {
        return null;
    }

    @Override
    public RespData<List<SysDeptInfoDto>> list(QuerySysDeptInfoVo querySysDeptInfoVo) {
        return null;
    }

    @Override
    public RespData<Pagination<SysDeptInfoDto>> pageList(QuerySysDeptInfoVo querySysDeptInfoVo) {
        return null;
    }

    @Override
    public RespData<String> enable(SysDeptInfoDto sysDeptInfoDto) {
        return null;
    }

    @Override
    public RespData<String> disable(SysDeptInfoDto sysDeptInfoDto) {
        return null;
    }

    @Override
    public RespData<String> deleteById(Long id) {
        return null;
    }
}
