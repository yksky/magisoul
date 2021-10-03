package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysRoleInfo;
import org.magisoul.system.mapper.ISysRoleInfoMapper;
import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;
import org.magisoul.system.service.ISysRoleInfoService;
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

@Service("sysRoleInfoService")
public class SysRoleInfoServiceImpl implements ISysRoleInfoService {

    @Autowired
    private ISysRoleInfoMapper sysRoleInfoMapper ;

    @Override
    public RespData<String> add(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysRoleInfo> checkForm = this.checkForm(sysRoleInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysRoleInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());

        Integer affectRowNum = this.sysRoleInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysRoleInfo> checkForm = this.checkForm(sysRoleInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysRoleInfo data = checkForm.getData();

        RespData<SysRoleInfo> check = this.checkById(data.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        Integer affectRowNum = this.sysRoleInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysRoleInfo> check = this.checkById(sysRoleInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysRoleInfo data = this.getSysRoleInfo(sysRoleInfoDto);
        Integer affectRowNum = this.sysRoleInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<SysRoleInfoDto> getById(Long id) {
        RespData<SysRoleInfoDto> resp = new RespData<>();

        RespData<SysRoleInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysRoleInfo data = check.getData();
        SysRoleInfoDto dto = this.getSysRoleInfoDto(data);
        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<List<SysRoleInfoDto>> list(QuerySysRoleInfoVo querySysRoleInfoVo) {
        RespData<List<SysRoleInfoDto>> resp = new RespData<>();

        List<SysRoleInfo> dataList = this.sysRoleInfoMapper.list(querySysRoleInfoVo);
        List<SysRoleInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<SysRoleInfoDto>> pageList(QuerySysRoleInfoVo querySysRoleInfoVo) {
        RespData<Pagination<SysRoleInfoDto>> resp = new RespData<Pagination<SysRoleInfoDto>>();

        List<SysRoleInfo> dataList = this.sysRoleInfoMapper.list(querySysRoleInfoVo);
        Long count = this.sysRoleInfoMapper.count(querySysRoleInfoVo);

        List<SysRoleInfoDto> dtoList = this.transferList(dataList);
        Pagination<SysRoleInfoDto> data = new Pagination<>(querySysRoleInfoVo.getPageNo(),querySysRoleInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    public List<SysRoleInfoDto> transferList(List<SysRoleInfo> dataList){
        List<SysRoleInfoDto> dtoList = new ArrayList<>();
        for(int i=0;i<dataList.size();i++){
            SysRoleInfo data = dataList.get(i);
            SysRoleInfoDto dto = this.getSysRoleInfoDto(data);
            dtoList.add(dto);
        }
        return dtoList ;
    }

    private RespData<SysRoleInfo> checkById(Long id){
        RespData<SysRoleInfo> resp = new RespData<>();

        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空");
            return resp ;
        }

        SysRoleInfo data = this.sysRoleInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该记录不存在");
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该记录已经删除");
            return resp ;
        }

        return resp.buildSuccess(data) ;
    }

    private RespData<SysRoleInfo> checkForm(SysRoleInfoDto dto){
        RespData<SysRoleInfo> resp = new RespData<>();

        //校验字段
        String enableStatus = dto.getEnableStatus();
        String roleName = dto.getRoleName();
        String roleType = dto.getRoleType();
        Long id = dto.getId();

        //检查字段
        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("roleName","角色名称",roleName,"string",false,true,50));
        paramList.add(new CheckParamVo("roleType","角色类型",roleType,"string",false,true,20));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"long",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //校验角色名称不能重复
        List<SysRoleInfo> existList = this.sysRoleInfoMapper.getExistByName(id,roleName);
        if(existList.size()>0){
            resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
            resp.setMessage("角色名称已经存在,不能重复");
            return resp ;
        }

        SysRoleInfo data = new SysRoleInfo();
        data.setCreator(dto.getCreator());
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setUpdator(dto.getUpdator());
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setEnableStatus(enableStatus);
        data.setRoleName(roleName);
        data.setRoleType(roleType);
        data.setIsDeleted("N");
        data.setId(id);

        return resp.buildSuccess(data) ;
    }

    private SysRoleInfo getSysRoleInfo(SysRoleInfoDto dto){
        SysRoleInfo data = new SysRoleInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }

    private SysRoleInfoDto getSysRoleInfoDto(SysRoleInfo data){
        SysRoleInfoDto dto = new SysRoleInfoDto();
        try{
            Dto2Entity.populate(data,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }
}
