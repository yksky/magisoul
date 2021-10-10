package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysDictInfo;
import org.magisoul.system.mapper.ISysDictInfoMapper;
import org.magisoul.system.model.dto.SysDictInfoDto;
import org.magisoul.system.model.query.QuerySysDictInfoVo;
import org.magisoul.system.service.ISysDictInfoService;
import org.magisoul.util.CheckUtil;
import org.magisoul.util.Dto2Entity;
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

@Service("sysDictInfoService")
public class SysDictInfoServiceImpl implements ISysDictInfoService {

    @Autowired
    private ISysDictInfoMapper sysDictInfoMapper ;

    @Override
    public RespData<String> add(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查表单
        RespData<SysDictInfo> checkForm = this.checkForm(sysDictInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysDictInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());

        //执行表单添加操作
        Integer affectRowNum = this.sysDictInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查表单
        RespData<SysDictInfo> checkForm = this.checkForm(sysDictInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysDictInfo data = checkForm.getData();

        //检查Id
        RespData<SysDictInfo> check = this.checkById(data.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        //执行表单更新操作
        Integer affectRowNum = this.sysDictInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysDictInfo> check = this.checkById(sysDictInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysDictInfo data = this.getSysDictInfo(sysDictInfoDto);

        //执行更新操作
        Integer affectRowNum = this.sysDictInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<SysDictInfoDto> getById(Long id) {
        RespData<SysDictInfoDto> resp = new RespData<>();

        RespData<SysDictInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysDictInfo data = check.getData();
        SysDictInfoDto dto = this.getSysDictInfoDto(data);

        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<SysDictInfoDto>> list(QuerySysDictInfoVo querySysDictInfoVo) {
        RespData<List<SysDictInfoDto>> resp = new RespData<>();

        List<SysDictInfo> dataList = this.sysDictInfoMapper.list(querySysDictInfoVo);
        List<SysDictInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<SysDictInfoDto>> pageList(QuerySysDictInfoVo querySysDictInfoVo) {
        RespData<Pagination<SysDictInfoDto>> resp = new RespData<>();

        List<SysDictInfo> dataList = this.sysDictInfoMapper.list(querySysDictInfoVo);
        Long count = this.sysDictInfoMapper.count(querySysDictInfoVo);

        List<SysDictInfoDto> dtoList = this.transferList(dataList);
        Pagination<SysDictInfoDto> data = new Pagination<>(querySysDictInfoVo.getPageNo(),querySysDictInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    private List<SysDictInfoDto> transferList(List<SysDictInfo> dataList){
        List<SysDictInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            SysDictInfo data = dataList.get(i);
            SysDictInfoDto dto = this.getSysDictInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<SysDictInfo> checkById(Long id){
        RespData<SysDictInfo> resp = new RespData<>();

        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空");
            return resp ;
        }

        SysDictInfo data = this.sysDictInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该记录不存在,请重新输入");
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该记录已被删除,请重新输入");
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<SysDictInfo> checkForm(SysDictInfoDto dto){
        RespData<SysDictInfo> resp = new RespData<>();

        String dictName = dto.getDictName();
        String dictType = dto.getDictType();
        String enableStatus = dto.getEnableStatus();
        Long id = dto.getId();

        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("dictName","字典名称",dictName,"string",false,true,100));
        paramList.add(new CheckParamVo("dictType","字典类型",dictType,"string",false,true,50));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"string",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //校验dictName是否唯一
        List<SysDictInfo> dataList = this.sysDictInfoMapper.getExistByName(id,dictName);
        if(dataList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage(RespCodeEnum.OBJECT_REPEAT.getMessage());
            return resp ;
        }

        SysDictInfo data = new SysDictInfo();
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setCreator(dto.getCreator());
        data.setId(id);
        data.setEnableStatus(dto.getEnableStatus());
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setUpdator(dto.getUpdator());
        data.setIsDeleted("N");
        data.setDictName(dictName);
        data.setDictType(dictType);

        return resp.buildSuccess(data) ;
    }

    private SysDictInfo getSysDictInfo(SysDictInfoDto dto){
        SysDictInfo data = new SysDictInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }

    private SysDictInfoDto getSysDictInfoDto(SysDictInfo data){
        SysDictInfoDto dto = new SysDictInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }
}
