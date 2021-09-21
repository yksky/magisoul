package org.magisoul.system.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.magisoul.system.entity.SysDeptInfo;
import org.magisoul.system.mapper.ISysDeptInfoMapper;
import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysDeptInfoVo;
import org.magisoul.system.service.ISysDeptInfoService;
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

@Service("sysDeptInfoService")
public class SysDeptInfoServiceImpl implements ISysDeptInfoService {

    @Autowired
    private ISysDeptInfoMapper sysDeptInfoMapper ;

    @Override
    public RespData<String> add(SysDeptInfoDto sysDeptInfoDto) {
        //检查Form表单提交数据
        RespData<String> resp = new RespData<String>();

        SysDeptInfo sysDeptInfo = this.getSysDeptInfo(sysDeptInfoDto);
        RespData<SysDeptInfo> checkResp = this.checkForm(sysDeptInfo);
        if(!checkResp.isSuccess()){
            return resp ;
        }

        SysDeptInfo data = checkResp.getData();
        Integer affectRowNum = this.sysDeptInfoMapper.add(data);
        return RespData.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(SysDeptInfoDto sysDeptInfoDto) {
        //检查Form表单提交数据
        RespData<String> resp = new RespData<String>();

        SysDeptInfo sysDeptInfo = this.getSysDeptInfo(sysDeptInfoDto);
        RespData<SysDeptInfo> checkResp = this.checkForm(sysDeptInfo);
        if(!checkResp.isSuccess()){
            return resp ;
        }

        RespData<String> check = this.checkById(sysDeptInfo.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        Integer affectRowNum = this.sysDeptInfoMapper.updateForm(sysDeptInfo);
        return RespData.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(SysDeptInfoDto sysDeptInfoDto) {
        return null;
    }

    @Override
    public RespData<SysDeptInfoDto> getById(Long id) {
        return null;
    }

    @Override
    public RespData<List<SysDeptInfoDto>> list(QuerySysDeptInfoVo querySysDeptInfoVo) {
        return null;
    }

    @Override
    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysDeptInfoVo querySysDeptInfoVo) {
        return null;
    }

    private RespData<SysDeptInfo> checkForm(SysDeptInfo sysDeptInfo){
        RespData<SysDeptInfo> resp = new RespData<SysDeptInfo>();

        String deptName = sysDeptInfo.getDeptName();
        String desc = sysDeptInfo.getDesc();
        Long parentId = sysDeptInfo.getParentId();
        Long id = sysDeptInfo.getId();

        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("deptName","部门名称",deptName,"string",false,true,100));
        paramList.add(new CheckParamVo("desc","描述",desc,"string",true,true,1000));
        paramList.add(new CheckParamVo("parentId","上级部门",parentId,"long",false,true,20));

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        //校验上级部门
        if(parentId.intValue()==-1){
            sysDeptInfo.setLevel(1);
        }else{
            SysDeptInfo parent = this.sysDeptInfoMapper.getById(parentId);
            if(parent==null){
                resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
                resp.setMessage("上级部门不存在,请重新输入");
                return resp ;
            }
            sysDeptInfo.setLevel(parent.getLevel());
        }

        //检查字段是否正确
        List<SysDeptInfo> existList = this.sysDeptInfoMapper.getExistByName(id,deptName);
        if(existList.size()>0){
            resp.build(RespCodeEnum.OBJECT_REPEAT);
            return resp ;
        }

        return resp.build(RespCodeEnum.SUCCESS) ;
    }

    private RespData<String> checkById(Long id){
        RespData<String> resp = new RespData<String>();
        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("主键Id为空,请重新输入");
            return resp ;
        }
        SysDeptInfo data = this.sysDeptInfoMapper.getById(id);
        if(data==null){
            resp.setData(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该部门不存在,请重新输入");
            return resp ;
        }
        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("改部门已经删除,请重新输入");
            return resp ;
        }
        return resp.build(RespCodeEnum.SUCCESS) ;
    }

    private SysDeptInfo getSysDeptInfo(SysDeptInfoDto dto){
        SysDeptInfo sysDeptInfo = new SysDeptInfo();
        try{
            Dto2Entity.populate(dto,sysDeptInfo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return sysDeptInfo ;
    }

    private SysDeptInfoDto getSysDeptInfoDto(SysDeptInfo sysDeptInfo){
        SysDeptInfoDto dto = new SysDeptInfoDto();
        try{
            Dto2Entity.populate(sysDeptInfo,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

}