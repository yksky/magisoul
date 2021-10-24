package org.magisoul.system.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysUserInfoApi;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.system.service.ISysUserInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserInfoApi")
public class SysUserInfoApiImpl implements ISysUserInfoApi {

    @Autowired
    private ISysUserInfoService sysUserInfoService ;

    Logger logger = LoggerFactory.getLogger(SysUserInfoApiImpl.class);

    /**
     * 页面表单的编辑功能(这里合并新增以及修改)
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> mergeForm(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysUserInfoDto.getId()==null){
                resp = this.sysUserInfoService.add(sysUserInfoDto);
            }else{
                resp = this.sysUserInfoService.updateForm(sysUserInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysUserInfoDto:{}],编辑用户信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","mergeForm", JSON.toJSONString(sysUserInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysUserInfoDto:{}],编辑用户信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","mergeForm", JSON.toJSONString(sysUserInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    /**
     * 根据Id修改用户信息
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> updateById(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.updateById(sysUserInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysUserInfoDto:{}],根据Id更新用户信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","updateById", JSON.toJSONString(sysUserInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysUserInfoDto:{}],根据Id更新用户信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","updateById", JSON.toJSONString(sysUserInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    /**
     * 根据id获取用户记录
     *
     * @param id
     * @return
     */
    @Override
    public RespData<SysUserInfoDto> getById(Long id) {
        RespData<SysUserInfoDto> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取用户信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","getById", id, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取用户信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","getById", id, e);
            resp.buildFail();
        }
        return resp;
    }

    /**
     * 不分页查询
     *
     * @param querySysUserInfoVo
     * @return
     */
    @Override
    public RespData<List<SysUserInfoDto>> list(QuerySysUserInfoVo querySysUserInfoVo) {
        RespData<List<SysUserInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.list(querySysUserInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysUserInfoVo:{}],根据条件获取用户不分页列表信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","list", JSON.toJSONString(querySysUserInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysUserInfoVo:{}],根据条件获取用户不分页列表信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","list", JSON.toJSONString(querySysUserInfoVo), e);
            resp.buildFail();
        }
        return resp;
    }

    /**
     * 分页查询
     *
     * @param querySysUserInfoVo
     * @return
     */
    @Override
    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysUserInfoVo querySysUserInfoVo) {
        RespData<Pagination<SysUserInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.pageList(querySysUserInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysUserInfoVo:{}],根据条件获取用户分页列表信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","pageList", JSON.toJSONString(querySysUserInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysUserInfoVo:{}],根据条件获取用户分页列表信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","pageList", JSON.toJSONString(querySysUserInfoVo), e);
            resp.buildFail();
        }
        return resp;
    }

    /**
     * 重置密码
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> resetPwd(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    /**
     * 将用户状态标记为可用
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> enable(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.enable(sysUserInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysUserInfoDto:{}],启用用户正常,结果信息:{}",
                    "SysUserInfoApiImpl","enable", JSON.toJSONString(sysUserInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysUserInfoDto:{}],启用用户异常,异常信息:{}",
                    "SysUserInfoApiImpl","enable", JSON.toJSONString(sysUserInfoDto), e);
            resp.buildFail();
        }
        return resp ;
    }

    /**
     * 将用户状态标记为不可用
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> disable(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.disable(sysUserInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysUserInfoDto:{}],禁用用户正常,结果信息:{}",
                    "SysUserInfoApiImpl","disable", JSON.toJSONString(sysUserInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysUserInfoDto:{}],禁用用户异常,异常信息:{}",
                    "SysUserInfoApiImpl","disable", JSON.toJSONString(sysUserInfoDto), e);
            resp.buildFail();
        }
        return resp ;
    }

    /**
     * 删除该用户
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> deleteById(SysUserInfoDto sysUserInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.deleteById(sysUserInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysUserInfoDto:{}],删除用户正常,结果信息:{}",
                    "SysUserInfoApiImpl","deleteById", JSON.toJSONString(sysUserInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysUserInfoDto:{}],删除用户异常,异常信息:{}",
                    "SysUserInfoApiImpl","deleteById", JSON.toJSONString(sysUserInfoDto), e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> login(String username, String password) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.login(username,password);
            logger.info("类名:{},方法名:{},参数:[username:{},password:{}],登录正常,结果信息:{}",
                    "SysUserInfoApiImpl","login", username, password, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[username:{},password:{}],登录异常,异常信息:{}",
                    "SysUserInfoApiImpl","login", username, password, e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> refreshToken(String token) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.refreshToken(token);
            logger.info("类名:{},方法名:{},参数:[token:{}],刷新Token正常,结果信息:{}",
                    "SysUserInfoApiImpl","refreshToken", token, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[token:{}],刷新Token异常,异常信息:{}",
                    "SysUserInfoApiImpl","refreshToken", token, e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<SysUserInfoDto> getByToken(String token) {
        RespData<SysUserInfoDto> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.getByToken(token);
            logger.info("类名:{},方法名:{},参数:[token:{}],根据Token获取用户信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","getByToken", token, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[token:{}],根据Token获取用户信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","getByToken", token, e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> logout(String token) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysUserInfoService.logout(token);
            logger.info("类名:{},方法名:{},参数:[token:{}],根据Token删除用户登录信息正常,结果信息:{}",
                    "SysUserInfoApiImpl","logout", token, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[token:{}],根据Token删除用户登录信息异常,异常信息:{}",
                    "SysUserInfoApiImpl","logout", token, e);
            resp.buildFail();
        }
        return resp ;
    }
}
