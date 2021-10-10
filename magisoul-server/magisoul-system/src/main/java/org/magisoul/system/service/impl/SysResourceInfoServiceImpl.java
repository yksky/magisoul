package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysResourceInfo;
import org.magisoul.system.mapper.ISysResourceInfoMapper;
import org.magisoul.system.model.dto.SysResourceInfoDto;
import org.magisoul.system.model.query.QuerySysResourceInfoVo;
import org.magisoul.system.service.ISysResourceInfoService;
import org.magisoul.util.CheckUtil;
import org.magisoul.util.Dto2Entity;
import org.magisoul.util.ObjectUtil;
import org.magisoul.util.SnowflakeIdUtil;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.CheckParamVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("sysResourceInfoService")
public class SysResourceInfoServiceImpl implements ISysResourceInfoService {

    private ISysResourceInfoMapper sysResourceInfoMapper ;

    @Override
    public RespData<String> add(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查表单Form
        RespData<SysResourceInfo> checkForm = this.checkForm(sysResourceInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        //执行添加操作,返回受影响的记录行数
        SysResourceInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());

        Integer affectRowNum = this.sysResourceInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查表单Form
        RespData<SysResourceInfo> checkForm = this.checkForm(sysResourceInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }
        SysResourceInfo data = checkForm.getData();

        //检查Id
        RespData<SysResourceInfo> check = this.checkById(data.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        //执行update操作
        Integer affectRowNum = this.sysResourceInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查Id
        RespData<SysResourceInfo> check = this.checkById(sysResourceInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        //执行update操作
        SysResourceInfo data = this.getSysResourceInfo(sysResourceInfoDto);
        Integer affectRowNum = this.sysResourceInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<SysResourceInfoDto> getById(Long id) {
        RespData<SysResourceInfoDto> resp = new RespData<>();

        RespData<SysResourceInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysResourceInfo data = check.getData();
        SysResourceInfoDto dto = this.getSysResourceInfoDto(data);
        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<SysResourceInfoDto>> list(QuerySysResourceInfoVo querySysResourceInfoVo) {
        RespData<List<SysResourceInfoDto>> resp = new RespData<>();

        List<SysResourceInfo> dataList = this.sysResourceInfoMapper.list(querySysResourceInfoVo);
        List<SysResourceInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<SysResourceInfoDto>> pageList(QuerySysResourceInfoVo querySysResourceInfoVo) {
        RespData<Pagination<SysResourceInfoDto>> resp = new RespData<>();

        List<SysResourceInfo> dataList = this.sysResourceInfoMapper.list(querySysResourceInfoVo);
        Long count = this.sysResourceInfoMapper.count(querySysResourceInfoVo);

        List<SysResourceInfoDto> dtoList = this.transferList(dataList);
        Pagination<SysResourceInfoDto> data = new Pagination<>(querySysResourceInfoVo.getPageNo(),querySysResourceInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    private List<SysResourceInfoDto> transferList(List<SysResourceInfo> dataList){
        List<SysResourceInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            SysResourceInfo data = dataList.get(i);
            SysResourceInfoDto dto = this.getSysResourceInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<SysResourceInfo> checkForm(SysResourceInfoDto sysResourceInfoDto){
        RespData<SysResourceInfo> resp = new RespData<>();

        String resourceName = sysResourceInfoDto.getResourceName();
        Long parentId = sysResourceInfoDto.getParentId();
        String enableStatus = sysResourceInfoDto.getEnableStatus();
        String requestUrl = sysResourceInfoDto.getRequestUrl();
        String type = sysResourceInfoDto.getType();
        Long id = sysResourceInfoDto.getId();

        //检查字段
        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("resourceName","资源名称",resourceName,"string",false,true,100));
        paramList.add(new CheckParamVo("parentId","所属父级资源",parentId,"long",false,true,20));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"long",false,true,20));
        paramList.add(new CheckParamVo("type","资源类型",type,"string",false,true,20));
        if(type!=null && type.trim().equals("menu")){
            paramList.add(new CheckParamVo("requestUrl","请求地址",requestUrl,"string",false,true,200));
        }

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //检查资源名称是否重复
        List<SysResourceInfo> existList = this.sysResourceInfoMapper.getExistByName(id,resourceName);
        if(existList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage("该资源名称已经存在,请重新输入");
            return resp ;
        }

        //检查parentId
        SysResourceInfo data = new SysResourceInfo();
        data.setId(id);
        data.setResourceName(resourceName);
        data.setEnableStatus(enableStatus);
        data.setType(type);
        data.setParentId(parentId);
        data.setIsDeleted("N");
        if(!ObjectUtil.isEmpty(type)){
            data.setRequestUrl(requestUrl);
        }
        if(parentId!=-1){
            SysResourceInfo parent = this.sysResourceInfoMapper.getById(parentId);
            if(parent==null){
                resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
                resp.setMessage("所属父级资源不存在,请重新输入");
                return resp ;
            }
            data.setParentId(parentId);
            data.setLevel(parent.getLevel()+1);
        }else{
            data.setParentId(parentId);
            data.setLevel(1);
        }

        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setCreator(sysResourceInfoDto.getCreator());
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setUpdator(sysResourceInfoDto.getUpdator());

        return resp.buildSuccess(data) ;
    }

    private RespData<SysResourceInfo> checkById(Long id){
        RespData<SysResourceInfo> resp = new RespData<>();
        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空");
            return resp ;
        }
        SysResourceInfo data = this.sysResourceInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该数据不存在");
            return resp ;
        }
        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该数据已经被删除");
            return resp ;
        }
        return resp.buildSuccess(data) ;
    }

    private SysResourceInfoDto getSysResourceInfoDto(SysResourceInfo data){
        SysResourceInfoDto dto = new SysResourceInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

    private SysResourceInfo getSysResourceInfo(SysResourceInfoDto dto){
        SysResourceInfo data = new SysResourceInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }
}
