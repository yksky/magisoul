package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysToken;
import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.mapper.ISysTokenMapper;
import org.magisoul.system.mapper.ISysUserInfoMapper;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.system.service.ISysUserInfoService;
import org.magisoul.util.*;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.CheckParamVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.magisoul.util.security.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("sysUserInfoService")
public class SysUserInfoServiceImpl implements ISysUserInfoService {

    @Autowired
    private ISysUserInfoMapper sysUserInfoMapper ;
    @Autowired
    private ISysTokenMapper sysTokenMapper ;
    @Value("${login-timeout}")
    private long loginTimeout ;

    @Override
    public RespData<String> add(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查表单
        RespData<SysUserInfo> checkForm = this.checkForm(sysUserInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysUserInfo data = checkForm.getData();
        data.setId(new SnowflakeIdUtil(0,0).nextId());
        //设置密码 todo

        Integer affectRowNum = this.sysUserInfoMapper.add(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateForm(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();

        //检查表单
        RespData<SysUserInfo> checkForm = this.checkForm(sysUserInfoDto);
        if(!checkForm.isSuccess()){
            resp.clone(checkForm);
            return resp ;
        }

        SysUserInfo data = checkForm.getData();

        //检查Id
        RespData<SysUserInfo> check = this.checkById(data.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        Integer affectRowNum = this.sysUserInfoMapper.updateForm(data);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> updateById(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<String>();

        RespData<SysUserInfo> check = this.checkById(sysUserInfoDto.getId());
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
        RespData<SysUserInfoDto> resp = new RespData<>();

        RespData<SysUserInfo> check = this.checkById(id);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysUserInfo data = check.getData();
        SysUserInfoDto dto = this.getSysUserInfoDto(data);

        return resp.buildSuccess(dto);
    }

    @Override
    public RespData<SysUserInfoDto> getByToken(String token) {
        RespData<SysUserInfoDto> resp = new RespData<>();

        if(ObjectUtil.isEmpty(token)){
            resp.build(RespCodeEnum.TOKEN_EMPTY);
            return resp ;
        }

        SysToken sysToken = this.sysTokenMapper.getByToken(token);
        if(sysToken==null){
            resp.build(RespCodeEnum.TOKEN_INVALID);
            return resp ;
        }

        long curTime = System.currentTimeMillis();
        if(curTime>sysToken.getExpireTime()){
            resp.build(RespCodeEnum.TOKEN_TTMEOUT);
            return resp ;
        }

        Long userId = sysToken.getUserId();
        RespData<SysUserInfo> check = this.checkById(userId);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysUserInfo data = check.getData();
        SysUserInfoDto dto = this.getSysUserInfoDto(data);

        return resp.buildSuccess(dto) ;
    }

    @Override
    public RespData<String> refreshToken(String token) {
        RespData<String> resp = new RespData<>();

        if(ObjectUtil.isEmpty(token)){
            resp.build(RespCodeEnum.TOKEN_EMPTY);
            return resp ;
        }

        SysToken sysToken = this.sysTokenMapper.getByToken(token);
        if(sysToken==null){
            resp.build(RespCodeEnum.TOKEN_INVALID);
            return resp ;
        }

        long curTime = System.currentTimeMillis();
        if(curTime>sysToken.getExpireTime()){
            resp.build(RespCodeEnum.TOKEN_TTMEOUT);
            return resp ;
        }

        //Token有效期30分钟
        long expireTime = curTime + loginTimeout ;
        SysToken updateVo = new SysToken();
        updateVo.setToken(token);
        updateVo.setExpireTime(expireTime);
        Integer affectRowNum = this.sysTokenMapper.update(updateVo);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<List<SysUserInfoDto>> list(QuerySysUserInfoVo querySysUserInfoVo) {
        RespData<List<SysUserInfoDto>> resp = new RespData<List<SysUserInfoDto>>();

        List<SysUserInfo> dataList = this.sysUserInfoMapper.list(querySysUserInfoVo);
        List<SysUserInfoDto> dtoList = this.transferList(dataList);

        return resp.buildSuccess(dtoList);
    }

    @Override
    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysUserInfoVo querySysUserInfoVo) {
        RespData<Pagination<SysUserInfoDto>> resp = new RespData<Pagination<SysUserInfoDto>>();

        List<SysUserInfo> dataList = this.sysUserInfoMapper.list(querySysUserInfoVo);
        Long count = this.sysUserInfoMapper.count(querySysUserInfoVo);

        List<SysUserInfoDto> dtoList = this.transferList(dataList);
        Pagination<SysUserInfoDto> data = new Pagination<>(querySysUserInfoVo.getPageNo(),querySysUserInfoVo.getPageSize(),count,dtoList);

        return resp.buildSuccess(data);
    }

    @Override
    public RespData<String> login(String username, String password) {
        RespData<String> resp = new RespData<>();

        if(ObjectUtil.isEmpty(username) || ObjectUtil.isEmpty(password)){
            resp.build(RespCodeEnum.USER_NAME_PWD_EMPTY);
            return resp ;
        }

        QuerySysUserInfoVo querySysUserInfoVo = new QuerySysUserInfoVo();
        querySysUserInfoVo.setUsername(username);
        querySysUserInfoVo.setIsDeleted("N");

        List<SysUserInfo> dataList = this.sysUserInfoMapper.list(querySysUserInfoVo);
        if(dataList.size()==0){
            resp.build(RespCodeEnum.USER_NOT_EXIST);
            return resp ;
        }
        if(dataList.size()>1){
            resp.build(RespCodeEnum.USER_RECORD_MORE);
            return resp ;
        }

        SysUserInfo data = dataList.get(0);
        if(!data.getPassword().trim().equals(Md5Util.md5(password))){
            resp.build(RespCodeEnum.USER_PWD_NOT_CORRECT);
            return resp ;
        }

        //删除userId对应的记录
        this.sysTokenMapper.deleteByUserId(data.getId());

        //登录成功,赋值Token
        String token = UUIDUtil.createUUID();
        long expireTime = System.currentTimeMillis()+loginTimeout;

        SysToken sysToken = new SysToken();
        sysToken.setToken(token);
        sysToken.setUserId(data.getId());
        sysToken.setId(new SnowflakeIdUtil(0,0).nextId());
        sysToken.setExpireTime(expireTime);

        Integer affectRowNum = this.sysTokenMapper.add(sysToken);
        if(affectRowNum.intValue()>0){
            resp.buildSuccess(token);
        }else{
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> enable(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysUserInfo> check = this.checkById(sysUserInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysUserInfo data = check.getData();
        if(!data.getEnableStatus().trim().equals("enable")){
            resp.build(RespCodeEnum.ENABLE_STATUS);
            return resp ;
        }

        SysUserInfo updateVo = new SysUserInfo();
        updateVo.setId(sysUserInfoDto.getId());
        updateVo.setCreator(sysUserInfoDto.getCreator());
        updateVo.setCreateTime(new Date(System.currentTimeMillis()));
        updateVo.setEnableStatus("enable");

        Integer affectRowNum = this.sysUserInfoMapper.updateById(updateVo);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> disable(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysUserInfo> check = this.checkById(sysUserInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysUserInfo data = check.getData();
        if(!data.getEnableStatus().trim().equals("disable")){
            resp.build(RespCodeEnum.DISABLE_STATUS);
            return resp ;
        }

        SysUserInfo updateVo = new SysUserInfo();
        updateVo.setId(sysUserInfoDto.getId());
        updateVo.setCreator(sysUserInfoDto.getCreator());
        updateVo.setCreateTime(new Date(System.currentTimeMillis()));
        updateVo.setEnableStatus("disable");

        Integer affectRowNum = this.sysUserInfoMapper.updateById(updateVo);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> deleteById(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();

        RespData<SysUserInfo> check = this.checkById(sysUserInfoDto.getId());
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        SysUserInfo updateVo = new SysUserInfo();
        updateVo.setId(sysUserInfoDto.getId());
        updateVo.setCreator(sysUserInfoDto.getCreator());
        updateVo.setCreateTime(new Date(System.currentTimeMillis()));
        updateVo.setIsDeleted("Y");

        Integer affectRowNum = this.sysUserInfoMapper.updateById(updateVo);
        return resp.getByAffectRowNum(affectRowNum);
    }

    @Override
    public RespData<String> logout(String token) {
        RespData<String> resp = new RespData<>();

        //登出操作,对于token而言,是清除操作.如果对应的Token存在,则删除
        //同时客户端会进行cookie清除
        if(!ObjectUtil.isEmpty(token)){
            this.sysTokenMapper.deleteByToken(token);
        }

        return resp.buildSuccess();
    }

    private List<SysUserInfoDto> transferList(List<SysUserInfo> dataList){
        List<SysUserInfoDto> dtoList = new ArrayList<>();

        for(int i=0;i<dataList.size();i++){
            SysUserInfo data = dataList.get(i);
            SysUserInfoDto dto = this.getSysUserInfoDto(data);
            dtoList.add(dto);
        }

        return dtoList ;
    }

    private RespData<SysUserInfo> checkForm(SysUserInfoDto sysUserInfoDto){
        RespData<SysUserInfo> resp = new RespData<SysUserInfo>();

        String email = sysUserInfoDto.getEmail();
        String userType = sysUserInfoDto.getUserType();
        String enableStatus = sysUserInfoDto.getEnableStatus();
        String realname = sysUserInfoDto.getRealname();
        String phone = sysUserInfoDto.getPhone();
        Long id = sysUserInfoDto.getId();
        String username = sysUserInfoDto.getUsername();

        //检查字段
        List<CheckParamVo> paramList = new ArrayList<CheckParamVo>();
        paramList.add(new CheckParamVo("email","邮件地址",email,"string",false,true,100));
        paramList.add(new CheckParamVo("userType","用户类型",userType,"string",false,true,20));
        paramList.add(new CheckParamVo("enableStatus","使用状态",enableStatus,"string",false,true,20));
        paramList.add(new CheckParamVo("realname","真实姓名",realname,"string",false,true,100));
        paramList.add(new CheckParamVo("phone","电话",phone,"string",false,true,20));
        if(id==null){
            paramList.add(new CheckParamVo("username","用户名",username,"string",false,true,50));
        }

        Map<String,Object> checkMap = CheckUtil.checkParamData(paramList);
        if(!String.valueOf(checkMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())){
            resp.setCode(RespCodeEnum.FAIL.getCode());
            resp.setMessage(String.valueOf(checkMap.get("message")));
            return resp ;
        }

        if(id==null){
            List<SysUserInfo> dataList = this.sysUserInfoMapper.getExistByName(id,username);
            if(dataList.size()>0){
                resp.setCode(RespCodeEnum.OBJECT_REPEAT.getCode());
                resp.setMessage("该用户名已经存在,请重新输入");
                return resp ;
            }
        }

        SysUserInfo data = new SysUserInfo();
        data.setCreateTime(new Date(System.currentTimeMillis()));
        data.setCreator(sysUserInfoDto.getCreator());
        data.setUpdateTime(new Date(System.currentTimeMillis()));
        data.setUpdator(sysUserInfoDto.getUpdator());
        data.setEnableStatus(enableStatus);
        data.setEmail(email);
        data.setIsDeleted("N");
        data.setRealname(realname);
        data.setPhone(phone);
        data.setUsername(username);
        data.setUserType(userType);
        data.setId(id);

        return resp.buildSuccess(data) ;
    }

    private RespData<SysUserInfo> checkById(Long id){
        RespData<SysUserInfo> resp = new RespData<SysUserInfo>();
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

        return resp.buildSuccess(data);
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
