package org.magisoul.gcode.service.impl;

import org.magisoul.gcode.entity.GcDbConfigInfo;
import org.magisoul.gcode.mapper.IGcDbConfigInfoMapper;
import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.query.QueryGcDbConfigInfoVo;
import org.magisoul.gcode.service.IGcDbConfigInfoService;
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

@Service("gcDbConfigInfoService")
public class GcDbConfigInfoServiceImpl implements IGcDbConfigInfoService {

    @Autowired
    private IGcDbConfigInfoMapper gcDbConfigInfoMapper ;

    @Override
    public RespData<String> add(GcDbConfigInfoDto gcDbConfigInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcDbConfigInfo> checkForm = this.checkForm(gcDbConfigInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        GcDbConfigInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());

        Integer affectRowNum = this.gcDbConfigInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(GcDbConfigInfoDto gcDbConfigInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcDbConfigInfo> checkForm = this.checkForm(gcDbConfigInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        GcDbConfigInfo data = checkForm.getData();

        RespData<GcDbConfigInfo> check = this.checkById(data.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        Integer affectRowNum = this.gcDbConfigInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(GcDbConfigInfoDto gcDbConfigInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcDbConfigInfo> check = this.checkById(gcDbConfigInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcDbConfigInfo data = this.getGcDbConfigInfo(gcDbConfigInfoDto);

        Integer affectRowNum = this.gcDbConfigInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<GcDbConfigInfoDto> getById(Long id) {
        RespData<GcDbConfigInfoDto> resp = new RespData<>();

        RespData<GcDbConfigInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcDbConfigInfo data = check.getData();
        GcDbConfigInfoDto dto = this.getGcDbConfigInfoDto(data);

        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<GcDbConfigInfoDto>> list(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo) {
        RespData<List<GcDbConfigInfoDto>> resp = new RespData<>();

        List<GcDbConfigInfo> dataList = this.gcDbConfigInfoMapper.list(queryGcDbConfigInfoVo);
        List<GcDbConfigInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<List<GcDbConfigInfoDto>> listDefault(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo) {
        RespData<List<GcDbConfigInfoDto>> resp = new RespData<>();

        List<GcDbConfigInfo> dataList = this.gcDbConfigInfoMapper.list(queryGcDbConfigInfoVo);
        List<GcDbConfigInfoDto> dtoList = this.transferList(dataList);
        dtoList.add(new GcDbConfigInfoDto(new Long(-1),"当前平台"));

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<GcDbConfigInfoDto>> pageList(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo) {
        RespData<Pagination<GcDbConfigInfoDto>> resp = new RespData<>();

        List<GcDbConfigInfo> dataList = this.gcDbConfigInfoMapper.list(queryGcDbConfigInfoVo);
        Long count = this.gcDbConfigInfoMapper.count(queryGcDbConfigInfoVo);

        List<GcDbConfigInfoDto> dtoList = this.transferList(dataList);
        Pagination<GcDbConfigInfoDto> data = new Pagination<>(queryGcDbConfigInfoVo.getPageNo(),queryGcDbConfigInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    @Override
    public RespData<String> deleteById(GcDbConfigInfoDto gcDbConfigInfoDto) {
        return null;
    }

    private List<GcDbConfigInfoDto> transferList(List<GcDbConfigInfo> dataList){
        List<GcDbConfigInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            GcDbConfigInfo data = dataList.get(i);
            GcDbConfigInfoDto dto = this.getGcDbConfigInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<GcDbConfigInfo> checkById(Long id){
        RespData<GcDbConfigInfo> resp = new RespData<>();

        if(ObjectUtil.isEmpty(id)){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空,请重新输入");
            return resp ;
        }

        GcDbConfigInfo data = this.gcDbConfigInfoMapper.getById(id);
        if(data==null){
            resp.build(RespCodeEnum.OBJECT_NOT_EXIST);
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.build(RespCodeEnum.OBJECT_DELETED);
            return resp ;
        }

        return resp.buildSuccess(data);
    }

    private RespData<GcDbConfigInfo> checkForm(GcDbConfigInfoDto dto){
        RespData<GcDbConfigInfo> resp = new RespData<>();

        String dbAppName = dto.getDbAppName();
        String dbUrl = dto.getDbUrl();
        String dbUsername = dto.getDbUsername();
        String dbDriver = dto.getDbDriver();
        String dbPassword = dto.getDbPassword();
        String enableStatus = dto.getEnableStatus();
        String dbType = dto.getDbType();
        String dbSchema = dto.getDbSchema();

        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("dbAppName","应用名称",dbAppName,"string",false,true,100));
        paramList.add(new CheckParamVo("dbUrl","地址",dbUrl,"string",true,false,200));
        paramList.add(new CheckParamVo("dbUsername","用户名",dbUsername,"string",false,true,100));
        paramList.add(new CheckParamVo("dbDriver","驱动",dbDriver,"string",false,true,100));
        paramList.add(new CheckParamVo("dbPassword","密码",dbPassword,"string",true,false,100));
        paramList.add(new CheckParamVo("dbType","类型",dbType,"string",false,true,50));
        paramList.add(new CheckParamVo("dbSchema","数据库Schema",dbSchema,"string",false,true,50));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"string",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        Long id = dto.getId();
        //监测dbAppName是否重复
        List<GcDbConfigInfo> existList = this.gcDbConfigInfoMapper.getExistByName(id,dbAppName);
        if(existList.size()>0){
            resp.build(RespCodeEnum.OBJECT_REPEAT);
            return resp ;
        }

        GcDbConfigInfo data = new GcDbConfigInfo();
        data.setCreator(dto.getCreator());
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setUpdator(dto.getUpdator());
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setIsDeleted("N");
        data.setDbDriver(dbDriver);
        data.setDbPassword(dbPassword);
        data.setDbType(dbType);
        data.setDbUrl(dbUrl);
        data.setDbAppName(dbAppName);
        data.setDbUsername(dbUsername);
        data.setEnableStatus(enableStatus);
        data.setDbSchema(dbSchema);
        data.setId(id);

        return resp.buildSuccess(data) ;
    }

    private GcDbConfigInfoDto getGcDbConfigInfoDto(GcDbConfigInfo data){
        GcDbConfigInfoDto dto = new GcDbConfigInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){

        }
        return dto ;
    }

    private GcDbConfigInfo getGcDbConfigInfo(GcDbConfigInfoDto dto){
        GcDbConfigInfo data = new GcDbConfigInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }
}
