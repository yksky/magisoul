package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.mapper.ISysUserInfoMapper;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.system.service.ISysUserInfoService;
import org.magisoul.util.Dto2Entity;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

@Service("sysUserInfoService")
public class SysUserInfoServiceImpl implements ISysUserInfoService {

    @Autowired
    private ISysUserInfoMapper sysUserInfoMapper ;

    @Override
    public RespData<String> add(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateForm(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateById(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<String>();

        RespData<SysUserInfoDto> check = this.checkById(sysUserInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysUserInfo data = this.getSysUserInfo(sysUserInfoDto);
        Integer affectRowNum = this.sysUserInfoMapper.updateById(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<SysUserInfoDto> getById(Long id) {
        return this.checkById(id);
    }

    @Override
    public RespData<List<SysUserInfoDto>> list(QuerySysUserInfoVo querySysUserInfoVo) {
        RespData<List<SysUserInfoDto>> resp = new RespData<List<SysUserInfoDto>>();

        List<SysUserInfo> dataList = this.sysUserInfoMapper.list(querySysUserInfoVo);
        List<SysUserInfoDto> dtoList = new ArrayList<SysUserInfoDto>();
        for(int i=0;i<dataList.size();i++){
            SysUserInfo data = dataList.get(i);
            SysUserInfoDto dto = this.getSysUserInfoDto(data);
            dtoList.add(dto);
        }

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysUserInfoVo querySysUserInfoVo) {
        RespData<Pagination<SysUserInfoDto>> resp = new RespData<Pagination<SysUserInfoDto>>();

        List<SysUserInfo> dataList = this.sysUserInfoMapper.list(querySysUserInfoVo);
        List<SysUserInfoDto> dtoList = new ArrayList<SysUserInfoDto>();
        for(int i=0;i<dataList.size();i++){
            SysUserInfo data = dataList.get(i);
            SysUserInfoDto dto = this.getSysUserInfoDto(data);
            dtoList.add(dto);
        }

        Long count = this.sysUserInfoMapper.count(querySysUserInfoVo);
        Pagination<SysUserInfoDto> data = new Pagination<>(querySysUserInfoVo.getPageNo(),querySysUserInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    private RespData<String> checkForm(SysUserInfo sysUserInfo){
        RespData<String> resp = new RespData<String>();

        String email = sysUserInfo.getEmail();
        String userType = sysUserInfo.getUserType();
        String enableStatus = sysUserInfo.getEnableStatus();
        String realname = sysUserInfo.getRealname();
        String phone = sysUserInfo.getPhone();

        return resp ;
    }

    private RespData<SysUserInfoDto> checkById(Long id){
        RespData<SysUserInfoDto> resp = new RespData<SysUserInfoDto>();
        if(id==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("Id不能为空,请重新输入");
            return resp ;
        }
        SysUserInfo data = this.sysUserInfoMapper.getById(id);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该记录不存在");
            return resp ;
        }
        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该记录已被删除");
            return resp ;
        }

        SysUserInfoDto dto = this.getSysUserInfoDto(data);
        return resp.buildSuccess(dto);
    }

    private SysUserInfoDto getSysUserInfoDto(SysUserInfo sysUserInfo){
        SysUserInfoDto dto = new SysUserInfoDto();
        try{
            Dto2Entity.populate(sysUserInfo,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }

    private SysUserInfo getSysUserInfo(SysUserInfoDto dto){
        SysUserInfo data = new SysUserInfo();
        try{
            Dto2Entity.populate(dto,data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return data ;
    }

}
