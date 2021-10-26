package org.magisoul.gcode.service.impl;

import org.magisoul.gcode.entity.GcJobInfo;
import org.magisoul.gcode.mapper.IGcJobInfoMapper;
import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.query.QueryGcJobInfoVo;
import org.magisoul.gcode.service.IGcJobInfoService;
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

@Service("gcJobInfoService")
public class GcJobInfoServiceImpl implements IGcJobInfoService {

    @Autowired
    private IGcJobInfoMapper gcJobInfoMapper ;

    @Override
    public RespData<String> add(GcJobInfoDto gcJobInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcJobInfo> checkForm = this.checkForm(gcJobInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        GcJobInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());

        Integer affectRowNum = this.gcJobInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(GcJobInfoDto gcJobInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcJobInfo> checkForm = this.checkForm(gcJobInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        GcJobInfo data = checkForm.getData();

        RespData<GcJobInfo> check = this.checkById(data.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        Integer affectRowNum = this.gcJobInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(GcJobInfoDto gcJobInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcJobInfo> check = this.checkById(gcJobInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcJobInfo data = this.getGcJobInfo(gcJobInfoDto);

        Integer affectRowNum = this.gcJobInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<GcJobInfoDto> getById(Long id) {
        RespData<GcJobInfoDto> resp = new RespData<>();

        RespData<GcJobInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        GcJobInfo data = check.getData();
        GcJobInfoDto dto = this.getGcJobInfoDto(data);

        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<GcJobInfoDto>> list(QueryGcJobInfoVo queryGcJobInfoVo) {
        RespData<List<GcJobInfoDto>> resp = new RespData<>();

        List<GcJobInfo> dataList = this.gcJobInfoMapper.list(queryGcJobInfoVo);
        List<GcJobInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<GcJobInfoDto>> pageList(QueryGcJobInfoVo queryGcJobInfoVo) {
        RespData<Pagination<GcJobInfoDto>> resp = new RespData<>();

        List<GcJobInfo> dataList = this.gcJobInfoMapper.list(queryGcJobInfoVo);
        Long count = this.gcJobInfoMapper.count(queryGcJobInfoVo);

        List<GcJobInfoDto> dtoList = this.transferList(dataList);
        Pagination<GcJobInfoDto> data = new Pagination<>(queryGcJobInfoVo.getPageNo(),queryGcJobInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    @Override
    public RespData<String> deleteById(GcJobInfoDto gcJobInfoDto) {
        return null;
    }

    private List<GcJobInfoDto> transferList(List<GcJobInfo> dataList){
        List<GcJobInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            GcJobInfo data = dataList.get(i);
            GcJobInfoDto dto = this.getGcJobInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<GcJobInfo> checkById(Long id){
        RespData<GcJobInfo> resp = new RespData<>();

        if(ObjectUtil.isEmpty(id)){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空,请重新输入");
            return resp ;
        }

        GcJobInfo data = this.gcJobInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该记录不存在,请重新输入");
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.build(RespCodeEnum.OBJECT_DELETED);
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<GcJobInfo> checkForm(GcJobInfoDto dto){
        RespData<GcJobInfo> resp = new RespData<>();

        //检查表单Form元素
        Long dbConfigId = dto.getDbConfigId();
        String jobName = dto.getJobName();
        String projectName = dto.getProjectName();
        String uiType = dto.getUiType();
        String techType = dto.getTechType();
        String gcType = dto.getGcType();
        String gcPath = dto.getGcPath();
        String groupId = dto.getGroupId();
        String artifactId = dto.getArtifactId();
        String version = dto.getVersion();
        String enableStatus = dto.getEnableStatus();
        Long id = dto.getId();

        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("dbConfigId","所属数据库",dbConfigId,"long",false,true,32));
        paramList.add(new CheckParamVo("jobName","任务名称",jobName,"string",false,false,100));
        paramList.add(new CheckParamVo("projectName","项目名称",projectName,"string",false,true,100));
        paramList.add(new CheckParamVo("uiType","UI类型",uiType,"string",false,true,100));
        paramList.add(new CheckParamVo("techType","技术类型",techType,"string",false,false,100));
        paramList.add(new CheckParamVo("gcType","应用类型",gcType,"string",false,true,100));
        paramList.add(new CheckParamVo("gcPath","生成代码路径",gcPath,"string",false,false,100));
        paramList.add(new CheckParamVo("groupId","GroupId",groupId,"string",false,true,100));
        paramList.add(new CheckParamVo("artifactId","ArtifactId",artifactId,"string",false,false,100));
        paramList.add(new CheckParamVo("version","Version",version,"string",false,true,100));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"string",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //判断jobName是否重复
        List<GcJobInfo> existList = this.gcJobInfoMapper.getExistByName(id,jobName);
        if(existList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage("任务名称不能重复,请重新输入");
            return resp ;
        }

        GcJobInfo data = this.getGcJobInfo(dto);
        data.setId(id);
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setIsDeleted("N");

        return resp.buildSuccess(data) ;
    }

    private GcJobInfoDto getGcJobInfoDto(GcJobInfo data){
        GcJobInfoDto dto = new GcJobInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

    private GcJobInfo getGcJobInfo(GcJobInfoDto dto){
        GcJobInfo data = new GcJobInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }
}
