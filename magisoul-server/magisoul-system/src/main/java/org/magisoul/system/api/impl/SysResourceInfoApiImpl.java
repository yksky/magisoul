package org.magisoul.system.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysResourceInfoApi;
import org.magisoul.system.model.dto.SysResourceInfoDto;
import org.magisoul.system.model.query.QuerySysResourceInfoVo;
import org.magisoul.system.service.ISysResourceInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysResourceInfoApi")
public class SysResourceInfoApiImpl implements ISysResourceInfoApi {

    @Autowired
    private ISysResourceInfoService sysResourceInfoService ;

    Logger logger = LoggerFactory.getLogger(SysResourceInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysResourceInfoDto.getId()==null){
                resp = this.sysResourceInfoService.add(sysResourceInfoDto);
            }else{
                resp = this.sysResourceInfoService.updateForm(sysResourceInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],编辑资源表单正常,结果信息:{}",
                    "SysResourceInfoApiImpl","mergeForm", JSON.toJSONString(sysResourceInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],编辑资源表单异常,异常信息:{}",
                    "SysResourceInfoApiImpl","mergeForm", JSON.toJSONString(sysResourceInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.updateById(sysResourceInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],根据Id更新资源信息正常,结果信息:{}",
                    "SysResourceInfoApiImpl","updateById", JSON.toJSONString(sysResourceInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],根据Id更新资源信息异常,异常信息:{}",
                    "SysResourceInfoApiImpl","updateById", JSON.toJSONString(sysResourceInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<SysResourceInfoDto> getById(Long id) {
        RespData<SysResourceInfoDto> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取资源信息正常,结果信息:{}",
                    "SysResourceInfoApiImpl","getById", id,JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取资源信息异常,异常信息:{}",
                    "SysResourceInfoApiImpl","getById", id,e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<SysResourceInfoDto>> list(QuerySysResourceInfoVo querySysResourceInfoVo) {
        RespData<List<SysResourceInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.list(querySysResourceInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysResourceInfoVo:{}],获取资源不分页列表信息正常,结果信息:{}",
                    "SysResourceInfoApiImpl","list", JSON.toJSONString(querySysResourceInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysResourceInfoVo:{}],获取资源不分页列表信息异常,异常信息:{}",
                    "SysResourceInfoApiImpl","list", JSON.toJSONString(querySysResourceInfoVo),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<Pagination<SysResourceInfoDto>> pageList(QuerySysResourceInfoVo querySysResourceInfoVo) {
        RespData<Pagination<SysResourceInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.pageList(querySysResourceInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysResourceInfoVo:{}],获取资源分页列表信息正常,结果信息:{}",
                    "SysResourceInfoApiImpl","pageList", JSON.toJSONString(querySysResourceInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysResourceInfoVo:{}],获取资源分页列表信息异常,异常信息:{}",
                    "SysResourceInfoApiImpl","pageList", JSON.toJSONString(querySysResourceInfoVo),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<String> enable(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.enable(sysResourceInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],启用资源正常,结果信息:{}",
                    "SysResourceInfoApiImpl","enable", JSON.toJSONString(sysResourceInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],启用资源异常,异常信息:{}",
                    "SysResourceInfoApiImpl","enable", JSON.toJSONString(sysResourceInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> disable(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.disable(sysResourceInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],禁用资源正常,结果信息:{}",
                    "SysResourceInfoApiImpl","disable", JSON.toJSONString(sysResourceInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],禁用资源异常,异常信息:{}",
                    "SysResourceInfoApiImpl","disable", JSON.toJSONString(sysResourceInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> deleteById(SysResourceInfoDto sysResourceInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysResourceInfoService.deleteById(sysResourceInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],删除资源正常,结果信息:{}",
                    "SysResourceInfoApiImpl","deleteById", JSON.toJSONString(sysResourceInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysResourceInfoDto:{}],删除资源异常,异常信息:{}",
                    "SysResourceInfoApiImpl","deleteById", JSON.toJSONString(sysResourceInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }
}
