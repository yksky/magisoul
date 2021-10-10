package org.magisoul.system.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysDictItemInfoApi;
import org.magisoul.system.model.dto.SysDictItemInfoDto;
import org.magisoul.system.model.query.QuerySysDictItemInfoVo;
import org.magisoul.system.service.ISysDictItemInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDictItemInfoApi")
public class SysDictItemInfoApiImpl implements ISysDictItemInfoApi {

    @Autowired
    private ISysDictItemInfoService sysDictItemInfoService ;

    Logger logger = LoggerFactory.getLogger(SysDictItemInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysDictItemInfoDto.getId()==null){
                resp = this.sysDictItemInfoService.add(sysDictItemInfoDto);
            }else{
                resp = this.sysDictItemInfoService.updateForm(sysDictItemInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],编辑数据字典表单正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","mergeForm", JSON.toJSONString(sysDictItemInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],编辑数据字典表单异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","mergeForm", JSON.toJSONString(sysDictItemInfoDto),e);
            resp.buildFail("编辑数据字典表单失败");
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysDictItemInfoDto.getId()==null){
                resp = this.sysDictItemInfoService.add(sysDictItemInfoDto);
            }else{
                resp = this.sysDictItemInfoService.updateForm(sysDictItemInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],根据Id更新数据字典正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","updateById", JSON.toJSONString(sysDictItemInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],根据Id更新数据字典异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","updateById", JSON.toJSONString(sysDictItemInfoDto),e);
            resp.buildFail("根据Id更新数据字典失败");
        }
        return resp;
    }

    @Override
    public RespData<SysDictItemInfoDto> getById(Long id) {
        RespData<SysDictItemInfoDto> resp = new RespData<>();
        try{
            resp = this.sysDictItemInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取数据字典正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","getById", id, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取数据字典异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","getById", id, e);
            resp.buildFail("根据Id获取数据字典失败");
        }
        return resp;
    }

    @Override
    public RespData<List<SysDictItemInfoDto>> list(QuerySysDictItemInfoVo querySysDictItemInfoVo) {
        RespData<List<SysDictItemInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysDictItemInfoService.list(querySysDictItemInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysDictItemInfoVo:{}],根据条件获取数据字典不分页信息正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","list", JSON.toJSONString(querySysDictItemInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysDictItemInfoVo:{}],根据条件获取数据字典不分页信息异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","list", JSON.toJSONString(querySysDictItemInfoVo), e);
            resp.buildFail("根据条件获取数据字典不分页信息失败");
        }
        return resp;
    }

    @Override
    public RespData<Pagination<SysDictItemInfoDto>> pageList(QuerySysDictItemInfoVo querySysDictItemInfoVo) {
        RespData<Pagination<SysDictItemInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysDictItemInfoService.pageList(querySysDictItemInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysDictItemInfoVo:{}],根据条件获取数据字典分页信息正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","pageList", JSON.toJSONString(querySysDictItemInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysDictItemInfoVo:{}],根据条件获取数据字典分页信息异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","pageList", JSON.toJSONString(querySysDictItemInfoVo), e);
            resp.buildFail("根据条件获取数据字典分页信息失败");
        }
        return resp;
    }

    @Override
    public RespData<String> enable(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictItemInfoService.enable(sysDictItemInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],启用数据字典正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","enable", JSON.toJSONString(sysDictItemInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],启用数据字典异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","enable", JSON.toJSONString(sysDictItemInfoDto), e);
            resp.buildFail("启用数据字典失败");
        }
        return resp;
    }

    @Override
    public RespData<String> disable(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictItemInfoService.disable(sysDictItemInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],禁用数据字典正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","disable", JSON.toJSONString(sysDictItemInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],禁用数据字典异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","disable", JSON.toJSONString(sysDictItemInfoDto), e);
            resp.buildFail("禁用数据字典失败");
        }
        return resp;
    }

    @Override
    public RespData<String> deleteById(SysDictItemInfoDto sysDictItemInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictItemInfoService.deleteById(sysDictItemInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],删除数据字典正常,结果信息:{}",
                    "SysDictItemInfoApiImpl","deleteById", JSON.toJSONString(sysDictItemInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictItemInfoDto:{}],删除数据字典异常,异常信息:{}",
                    "SysDictItemInfoApiImpl","deleteById", JSON.toJSONString(sysDictItemInfoDto), e);
            resp.buildFail("删除数据字典失败");
        }
        return resp;
    }
}
