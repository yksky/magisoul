package org.magisoul.gcode.service.impl;

import org.magisoul.gcode.entity.GcJobInfo;
import org.magisoul.gcode.entity.GcTableInfo;
import org.magisoul.gcode.mapper.IGcTableInfoMapper;
import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.dto.GcTableInfoDto;
import org.magisoul.gcode.model.query.QueryGcTableInfoVo;
import org.magisoul.gcode.service.IGcTableInfoService;
import org.magisoul.util.Dto2Entity;
import org.magisoul.util.ObjectUtil;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("gcTableInfoService")
public class GcTableInfoServiceImpl implements IGcTableInfoService {

    @Autowired
    private IGcTableInfoMapper gcTableInfoMapper ;

    @Override
    public RespData<String> updateForm(GcTableInfoDto gcTableInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateById(GcTableInfoDto gcTableInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcTableInfo> check = this.checkById(gcTableInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcTableInfo data = check.getData();

        Integer affectRowNum = this.gcTableInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<GcTableInfoDto> getById(Long id) {
        RespData<GcTableInfoDto> resp = new RespData<>();

        RespData<GcTableInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcTableInfo data = check.getData();
        GcTableInfoDto dto = this.getGcTableInfoDto(data);

        return resp.buildSuccess(dto) ;
    }

    @Override
    public RespData<List<GcTableInfoDto>> list(QueryGcTableInfoVo queryGcTableInfoVo) {
        RespData<List<GcTableInfoDto>> resp = new RespData<>();

        List<GcTableInfo> dataList = this.gcTableInfoMapper.list(queryGcTableInfoVo);
        List<GcTableInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList) ;
    }

    @Override
    public RespData<Pagination<GcTableInfoDto>> pageList(QueryGcTableInfoVo queryGcTableInfoVo) {
        RespData<Pagination<GcTableInfoDto>> resp = new RespData<>();

        List<GcTableInfo> dataList = this.gcTableInfoMapper.list(queryGcTableInfoVo);
        Long count = this.gcTableInfoMapper.count(queryGcTableInfoVo);

        List<GcTableInfoDto> dtoList = this.transferList(dataList);
        Pagination<GcTableInfoDto> data = new Pagination<GcTableInfoDto>(queryGcTableInfoVo.getPageNo(),queryGcTableInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data) ;
    }

    private List<GcTableInfoDto> transferList(List<GcTableInfo> dataList){
        List<GcTableInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            GcTableInfo data = dataList.get(i);
            GcTableInfoDto dto = this.getGcTableInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<GcTableInfo> checkById(Long id){
        RespData<GcTableInfo> resp = new RespData<>();

        if(ObjectUtil.isEmpty(id)){
            resp.build(RespCodeEnum.PARAM_EMPTY_ERROR_CODE);
            return resp ;
        }

        GcTableInfo data = this.gcTableInfoMapper.getById(id);
        if(data==null){
            resp.build(RespCodeEnum.OBJECT_NOT_EXIST);
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<GcTableInfo> checkForm(GcTableInfoDto dto){
        RespData<GcTableInfo> resp = new RespData<>();
        return resp ;
    }

    private GcTableInfoDto getGcTableInfoDto(GcTableInfo data){
        GcTableInfoDto dto = new GcTableInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

    private GcTableInfo getGcTableInfo(GcTableInfoDto dto){
        GcTableInfo data = new GcTableInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }
}
