package org.magisoul.system.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysRoleInfoApi;
import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;
import org.magisoul.system.service.ISysRoleInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysRoleInfoApi")
public class SysRoleInfoApiImpl implements ISysRoleInfoApi {

    @Autowired
    private ISysRoleInfoService sysRoleInfoService ;

    Logger logger = LoggerFactory.getLogger(SysRoleInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysRoleInfoDto.getId()==null){
                resp = this.sysRoleInfoService.add(sysRoleInfoDto);
            }else{
                resp = this.sysRoleInfoService.updateForm(sysRoleInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],编辑角色信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","mergeForm", JSON.toJSONString(sysRoleInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],编辑角色信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","mergeForm", JSON.toJSONString(sysRoleInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.updateById(sysRoleInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],根据Id更新角色信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","updateById", JSON.toJSONString(sysRoleInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],根据Id更新角色信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","updateById", JSON.toJSONString(sysRoleInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<SysRoleInfoDto> getById(Long id) {
        RespData<SysRoleInfoDto> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],根据Id获取角色信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","getById", id, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],根据Id获取角色信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","getById", id, e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<SysRoleInfoDto>> list(QuerySysRoleInfoVo querySysRoleInfoVo) {
        RespData<List<SysRoleInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.list(querySysRoleInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysRoleInfoVo:{}],根据条件获取角色不分页信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","list", JSON.toJSONString(querySysRoleInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysRoleInfoVo:{}],根据条件获取角色不分页信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","list", JSON.toJSONString(querySysRoleInfoVo), e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<Pagination<SysRoleInfoDto>> pageList(QuerySysRoleInfoVo querySysRoleInfoVo) {
        RespData<Pagination<SysRoleInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.pageList(querySysRoleInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysRoleInfoVo:{}],根据条件获取角色分页信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","pageList", JSON.toJSONString(querySysRoleInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysRoleInfoVo:{}],根据条件获取角色分页信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","pageList", JSON.toJSONString(querySysRoleInfoVo), e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<String> enable(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.enable(sysRoleInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],启用角色信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","enable", JSON.toJSONString(sysRoleInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],启用角色信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","enable", JSON.toJSONString(sysRoleInfoDto), e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> disable(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.disable(sysRoleInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],禁用角色信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","disable", JSON.toJSONString(sysRoleInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],禁用角色信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","disable", JSON.toJSONString(sysRoleInfoDto), e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> deleteById(SysRoleInfoDto sysRoleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysRoleInfoService.deleteById(sysRoleInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],删除角色信息正常,结果信息:{}",
                    "SysRoleInfoApiImpl","deleteById", JSON.toJSONString(sysRoleInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysRoleInfoDto:{}],删除角色信息异常,异常信息:{}",
                    "SysRoleInfoApiImpl","deleteById", JSON.toJSONString(sysRoleInfoDto), e);
            resp.buildFail();
        }
        return resp ;
    }
}
