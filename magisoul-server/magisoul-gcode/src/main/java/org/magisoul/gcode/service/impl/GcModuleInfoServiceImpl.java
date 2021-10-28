package org.magisoul.gcode.service.impl;

import org.magisoul.gcode.entity.GcModuleInfo;
import org.magisoul.gcode.mapper.IGcModuleInfoMapper;
import org.magisoul.gcode.model.dto.GcModuleInfoDto;
import org.magisoul.gcode.model.query.QueryGcModuleInfoVo;
import org.magisoul.gcode.service.IGcModuleInfoService;
import org.magisoul.util.CheckUtil;
import org.magisoul.util.Dto2Entity;
import org.magisoul.util.ObjectUtil;
import org.magisoul.util.SnowflakeIdUtil;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.CheckParamVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("gcModuleInfoService")
public class GcModuleInfoServiceImpl implements IGcModuleInfoService {

    @Autowired
    private IGcModuleInfoMapper gcModuleInfoMapper ;

    @Override
    public RespData<String> add(GcModuleInfoDto gcModuleInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcModuleInfo> checkForm = this.checkForm(gcModuleInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        GcModuleInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());

        Integer affectRowNum = this.gcModuleInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(GcModuleInfoDto gcModuleInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcModuleInfo> checkForm = this.checkForm(gcModuleInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        RespData<GcModuleInfo> check = this.checkById(gcModuleInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcModuleInfo data = checkForm.getData();

        Integer affectRowNum = this.gcModuleInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(GcModuleInfoDto gcModuleInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcModuleInfo> check = this.checkById(gcModuleInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcModuleInfo data = this.getGcModuleInfo(gcModuleInfoDto);

        Integer affectRowNum = this.gcModuleInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum) ;
    }

    @Override
    public RespData<GcModuleInfoDto> getById(Long id) {
        RespData<GcModuleInfoDto> resp = new RespData<>();

        RespData<GcModuleInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcModuleInfo data = check.getData();
        GcModuleInfoDto dto = this.getGcModuleInfoDto(data);

        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<GcModuleInfoDto>> list(QueryGcModuleInfoVo queryGcModuleInfoVo) {
        RespData<List<GcModuleInfoDto>> resp = new RespData<>();

        List<GcModuleInfo> dataList = this.gcModuleInfoMapper.list(queryGcModuleInfoVo);
        List<GcModuleInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<GcModuleInfoDto>> pageList(QueryGcModuleInfoVo queryGcModuleInfoVo) {
        RespData<Pagination<GcModuleInfoDto>> resp = new RespData<>();

        List<GcModuleInfo> dataList = this.gcModuleInfoMapper.list(queryGcModuleInfoVo);
        Long count = this.gcModuleInfoMapper.count(queryGcModuleInfoVo);

        List<GcModuleInfoDto> dtoList = this.transferList(dataList);
        Pagination<GcModuleInfoDto> data = new Pagination<>(queryGcModuleInfoVo.getPageNo(),queryGcModuleInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    private List<GcModuleInfoDto> transferList(List<GcModuleInfo> dataList){
        List<GcModuleInfoDto> dtoList = new ArrayList<>();

        for(int i=0;i<dataList.size();i++){
            GcModuleInfo data = dataList.get(i);
            GcModuleInfoDto dto = this.getGcModuleInfoDto(data);
            dtoList.add(dto);
        }

        return dtoList ;
    }

    private RespData<GcModuleInfo> checkById(Long id){
        RespData<GcModuleInfo> resp = new RespData<>();

        if(ObjectUtil.isEmpty(id)){
            resp.build(RespCodeEnum.PARAM_EMPTY_ERROR_CODE);
            return resp ;
        }

        GcModuleInfo data = this.gcModuleInfoMapper.getById(id);
        if(data==null){
            resp.build(RespCodeEnum.OBJECT_NOT_EXIST);
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.build(RespCodeEnum.OBJECT_DELETED);
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<GcModuleInfo> checkForm(GcModuleInfoDto dto){
        RespData<GcModuleInfo> resp = new RespData<>();

        String moduleName = dto.getModuleName();
        String moduleCode = dto.getModuleCode();
        String enableStatus = dto.getEnableStatus();
        Long id = dto.getId();
        Long jobId = dto.getJobId();

        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("moduleName","模块名称",moduleName,"string",false,true,100));
        paramList.add(new CheckParamVo("moduleCode","模块代码",moduleCode,"string",false,false,200));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"string",false,true,20));
        paramList.add(new CheckParamVo("jobId","所属任务",jobId,"long",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        List<GcModuleInfo> existNameList = this.gcModuleInfoMapper.getExistByName(id,moduleName);
        if(existNameList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage("模块名称已经存在,请重新输入");
            return resp ;
        }

        List<GcModuleInfo> existCodeList = this.gcModuleInfoMapper.getExistByCode(id,moduleCode);
        if(existCodeList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage("模块代码已经存在,请重新输入");
            return resp ;
        }

        GcModuleInfo data = this.getGcModuleInfo(dto);
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setIsDeleted("N");
        data.setId(id);

        return resp.buildSuccess(data);
    }

    private GcModuleInfoDto getGcModuleInfoDto(GcModuleInfo data){
        GcModuleInfoDto dto = new GcModuleInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

    private GcModuleInfo getGcModuleInfo(GcModuleInfoDto dto){
        GcModuleInfo data = new GcModuleInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }
}
