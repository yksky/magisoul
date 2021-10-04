package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysDictItemInfo;
import org.magisoul.system.mapper.ISysDictItemInfoMapper;
import org.magisoul.system.model.dto.SysDictItemInfoDto;
import org.magisoul.system.model.query.QuerySysDictItemInfoVo;
import org.magisoul.system.service.ISysDictItemInfoService;
import org.magisoul.util.CheckUtil;
import org.magisoul.util.Dto2Entity;
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

@Service("sysDictItemInfoService")
public class SysDictItemInfoServiceImpl implements ISysDictItemInfoService {

    @Autowired
    private ISysDictItemInfoMapper sysDictItemInfoMapper ;

    @Override
    public RespData<String> add(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysDictItemInfo> checkForm = this.checkForm(sysDictItemInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysDictItemInfo data = checkForm.getData();
        Integer affectRowNum = this.sysDictItemInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysDictItemInfo> checkForm = this.checkForm(sysDictItemInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        RespData<SysDictItemInfo> check = this.checkById(sysDictItemInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysDictItemInfo data = checkForm.getData();
        Integer affectRowNum = this.sysDictItemInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysDictItemInfo> check = this.checkById(sysDictItemInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysDictItemInfo data = this.getSysDictItemInfo(sysDictItemInfoDto);
        Integer affectRowNum = this.sysDictItemInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<SysDictItemInfoDto> getById(Long id) {
        RespData<SysDictItemInfoDto> resp = new RespData<>();

        RespData<SysDictItemInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysDictItemInfo data = check.getData();
        SysDictItemInfoDto dto = this.getSysDictItemInfoDto(data);
        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<SysDictItemInfoDto>> list(QuerySysDictItemInfoVo querySysDictItemInfoVo) {
        RespData<List<SysDictItemInfoDto>> resp = new RespData<>();

        List<SysDictItemInfo> dataList = this.sysDictItemInfoMapper.list(querySysDictItemInfoVo);
        List<SysDictItemInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<SysDictItemInfoDto>> pageList(QuerySysDictItemInfoVo querySysDictItemInfoVo) {
        RespData<Pagination<SysDictItemInfoDto>> resp = new RespData<>();

        List<SysDictItemInfo> dataList = this.sysDictItemInfoMapper.list(querySysDictItemInfoVo);
        Long count = this.sysDictItemInfoMapper.count(querySysDictItemInfoVo);
        List<SysDictItemInfoDto> dtoList = this.transferList(dataList);

        Pagination<SysDictItemInfoDto> data = new Pagination<>(querySysDictItemInfoVo.getPageNo(),querySysDictItemInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    private List<SysDictItemInfoDto> transferList(List<SysDictItemInfo> dataList){
        List<SysDictItemInfoDto> dtoList = new ArrayList<>();

        for(int i=0;i<dataList.size();i++){
            SysDictItemInfo data = dataList.get(i);
            SysDictItemInfoDto dto = this.getSysDictItemInfoDto(data);
            dtoList.add(dto);
        }

        return dtoList ;
    }

    private RespData<SysDictItemInfo> checkById(Long id){
        RespData<SysDictItemInfo> resp = new RespData<>();

        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空,请重新输入");
            return resp ;
        }

        SysDictItemInfo data = this.sysDictItemInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该记录已经存在,请重新输入");
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该记录已被删除,请重新输入");
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<SysDictItemInfo> checkForm(SysDictItemInfoDto dto){
        RespData<SysDictItemInfo> resp = new RespData<>();

        String dictType = dto.getDictType();
        String enableStatus = dto.getEnableStatus();
        String itemValue = dto.getItemValue();
        String itemName = dto.getItemName();
        Integer sort = dto.getSort();
        Long id = dto.getId();

        //检查字段
        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("dictType","字典类型",dictType,"string",false,true,50));
        paramList.add(new CheckParamVo("itemName","字典条目名称",itemName,"string",false,true,100));
        paramList.add(new CheckParamVo("itemValue","字典条目值",itemValue,"string",false,true,100));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"long",false,true,20));
        paramList.add(new CheckParamVo("sort","排序",sort,"int",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //itemName必须唯一
        List<SysDictItemInfo> existList = this.sysDictItemInfoMapper.getExistByName(id,itemName);
        if(existList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage("字典条目名称已经存在,请重新输入");
            return resp ;
        }

        SysDictItemInfo data = new SysDictItemInfo();
        data.setCreator(dto.getCreator());
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setUpdator(dto.getUpdator());
        data.setIsDeleted("N");
        data.setSort(sort);
        data.setDictType(dictType);
        data.setItemName(itemName);
        data.setItemValue(itemValue);
        data.setEnableStatus(enableStatus);
        data.setId(id);

        return resp.buildSuccess(data) ;
    }

    private SysDictItemInfoDto getSysDictItemInfoDto(SysDictItemInfo data){
        SysDictItemInfoDto dto = new SysDictItemInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

    private SysDictItemInfo getSysDictItemInfo(SysDictItemInfoDto dto){
        SysDictItemInfo data = new SysDictItemInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }
}
