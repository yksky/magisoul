package org.magisoul.gcode.service.impl;

import org.magisoul.gcode.entity.GcFieldInfo;
import org.magisoul.gcode.entity.GcTableInfo;
import org.magisoul.gcode.mapper.IGcFieldInfoMapper;
import org.magisoul.gcode.mapper.IGcTableInfoMapper;
import org.magisoul.gcode.model.dto.GcFieldInfoDto;
import org.magisoul.gcode.model.query.QueryGcFieldInfoVo;
import org.magisoul.gcode.service.IGcFieldInfoService;
import org.magisoul.util.CheckUtil;
import org.magisoul.util.Dto2Entity;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.CheckParamVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GcFieldInfoServiceImpl implements IGcFieldInfoService {

    @Autowired
    private IGcFieldInfoMapper gcFieldInfoMapper ;
    @Autowired
    private IGcTableInfoMapper gcTableInfoMapper ;

    @Override
    public RespData<String> updateForm(GcFieldInfoDto gcFieldInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcFieldInfo> checkForm = this.checkForm(gcFieldInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        GcFieldInfo data = checkForm.getData();

        RespData<GcFieldInfo> checkById = this.checkById(data.getId());
        if(!checkById.isSuccess()){
            resp.clone(checkById);
            return resp ;
        }

        Integer affectRowNum = this.gcFieldInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(GcFieldInfoDto gcFieldInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<GcFieldInfo> checkById = this.checkById(gcFieldInfoDto.getId());
        if(!checkById.isSuccess()){
            resp.clone(checkById);
            return resp ;
        }

        GcFieldInfo data = this.getGcFieldInfo(gcFieldInfoDto);

        Integer affectRowNum = this.gcFieldInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<GcFieldInfoDto> getById(Long id) {
        RespData<GcFieldInfoDto> resp = new RespData<>();

        RespData<GcFieldInfo> checkById = this.checkById(id);
        if(!checkById.isSuccess()){
            resp.clone(checkById);
            return resp ;
        }

        GcFieldInfo data = checkById.getData();
        GcFieldInfoDto dto = this.getGcFieldInfoDto(data);

        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<GcFieldInfoDto>> list(QueryGcFieldInfoVo queryGcFieldInfoVo) {
        RespData<List<GcFieldInfoDto>> resp = new RespData<>();

        List<GcFieldInfo> dataList = this.gcFieldInfoMapper.list(queryGcFieldInfoVo);
        List<GcFieldInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<GcFieldInfoDto>> pageList(QueryGcFieldInfoVo queryGcFieldInfoVo) {
        RespData<Pagination<GcFieldInfoDto>> resp = new RespData<>();

        List<GcFieldInfo> dataList = this.gcFieldInfoMapper.list(queryGcFieldInfoVo);
        Long count = this.gcFieldInfoMapper.count(queryGcFieldInfoVo);

        List<GcFieldInfoDto> dtoList = this.transferList(dataList);
        Pagination<GcFieldInfoDto> data = new Pagination<>(queryGcFieldInfoVo.getPageNo(),queryGcFieldInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    private List<GcFieldInfoDto> transferList(List<GcFieldInfo> dataList){
        List<GcFieldInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            GcFieldInfo data = dataList.get(i);
            GcFieldInfoDto dto = this.getGcFieldInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<GcFieldInfo> checkById(Long id){
        RespData<GcFieldInfo> resp = new RespData<>();

        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空,请重新输入");
            return resp ;
        }

        GcFieldInfo data = this.gcFieldInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该记录不存在,请重新输入");
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<GcFieldInfo> checkForm(GcFieldInfoDto dto){
        RespData<GcFieldInfo> resp = new RespData<>();

        String fieldDesc = dto.getFieldDesc();
        String isPrimaryField = dto.getIsPrimaryField();
        String primaryType = dto.getPrimaryType();
        String isAddField = dto.getIsAddField();
        String isEditField = dto.getIsEditField();
        String editType = dto.getEditType();
        String isEditEmpty = dto.getIsEditEmpty();
        String isEditUnique = dto.getIsEditUnique();
        String isQueryField = dto.getIsQueryField();
        String isListField = dto.getIsListField();
        String isDeleteField = dto.getIsDeleteField();
        String deleteValue = dto.getDeleteValue();
        String notDeleteValue = dto.getNotDeleteValue();
        String isEnableField = dto.getIsEnableField();
        String enableValue = dto.getEnableValue();
        String disableValue = dto.getDisableValue();
        Integer seqNo = dto.getSeqNo();
        Long id = dto.getId();
        Long tableId = dto.getTableId();

        //字段校验
        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("fieldDesc","字段备注",fieldDesc,"long",false,true,32));
        paramList.add(new CheckParamVo("isPrimaryField","是否主键",isPrimaryField,"string",false,true,2));
        if(isPrimaryField!=null && isPrimaryField.trim().equals("Y")){
            paramList.add(new CheckParamVo("primaryType","主键类型",primaryType,"string",false,true,50));
        }
        paramList.add(new CheckParamVo("isAddField","是否添加字段",isAddField,"string",true,true,2));
        paramList.add(new CheckParamVo("isEditField","是否编辑字段",isEditField,"string",true,true,2));
        if(isEditField!=null && isEditField.trim().equals("Y")){
            paramList.add(new CheckParamVo("editType","编辑类型",editType,"string",false,true,50));
            paramList.add(new CheckParamVo("isEditEmpty","是否为空",isEditEmpty,"string",true,true,2));
            paramList.add(new CheckParamVo("isEditUnique","是否唯一",isEditUnique,"string",true,true,2));
        }
        paramList.add(new CheckParamVo("isQueryField","是否查询字段",isQueryField,"string",true,true,2));
        paramList.add(new CheckParamVo("isListField","是否列表字段",isListField,"string",true,true,2));
        paramList.add(new CheckParamVo("isDeleteField","是否删除字段",isDeleteField,"string",true,true,2));
        if(isDeleteField!=null && isDeleteField.trim().equals("Y")){
            paramList.add(new CheckParamVo("deleteValue","删除值",deleteValue,"string",false,true,50));
            paramList.add(new CheckParamVo("notDeleteValue","非删除值",notDeleteValue,"string",false,true,50));
        }
        paramList.add(new CheckParamVo("是否编辑字段","isEnableField",isEnableField,"string",true,true,2));
        if(isEnableField!=null && isEnableField.trim().equals("Y")){
            paramList.add(new CheckParamVo("enableValue","使用状态",enableValue,"string",false,true,50));
            paramList.add(new CheckParamVo("disableValue","停用状态",disableValue,"string",false,true,50));
        }
        paramList.add(new CheckParamVo("序号","seqNo",seqNo,"int",true,false,20));
        paramList.add(new CheckParamVo("所属表","tableId",tableId,"int",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //校验tableId
        GcTableInfo gcTableInfo = this.gcTableInfoMapper.getById(tableId);
        if(gcTableInfo==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("所属表信息不存在,请重新输入");
            return resp ;
        }
        Long jobId = gcTableInfo.getJobId();
        Long moduleId = gcTableInfo.getModuleId();

        GcFieldInfo data = this.getGcFieldInfo(dto);
        data.setId(id);
        data.setJobId(jobId);
        data.setModuleId(moduleId);

        return resp.buildSuccess(data) ;
    }

    private GcFieldInfoDto getGcFieldInfoDto(GcFieldInfo data){
        GcFieldInfoDto dto = new GcFieldInfoDto();

        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }

        return dto ;
    }

    private GcFieldInfo getGcFieldInfo(GcFieldInfoDto dto){
        GcFieldInfo data = new GcFieldInfo();

        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }

        return data ;
    }
}
