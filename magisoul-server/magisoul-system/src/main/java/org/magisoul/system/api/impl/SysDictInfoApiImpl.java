package org.magisoul.system.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysDictInfoApi;
import org.magisoul.system.model.dto.SysDictInfoDto;
import org.magisoul.system.model.query.QuerySysDictInfoVo;
import org.magisoul.system.service.ISysDictInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDictInfoApi")
public class SysDictInfoApiImpl implements ISysDictInfoApi {

    @Autowired
    private ISysDictInfoService sysDictInfoService ;

    Logger logger = LoggerFactory.getLogger(SysDictInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysDictInfoDto.getId()==null){
                resp = this.sysDictInfoService.add(sysDictInfoDto);
            }else{
                resp = this.sysDictInfoService.updateForm(sysDictInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysDictInfoDto:{}],编辑字典类型表单正常,结果信息:{}",
                    "SysDictInfoApiImpl","mergeForm", JSON.toJSONString(sysDictInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictInfoDto:{}],编辑字典类型表单异常,异常信息:{}",
                    "SysDictInfoApiImpl","mergeForm", JSON.toJSONString(sysDictInfoDto),e);
            resp.buildFail("编辑字典类型表单失败");
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.updateById(sysDictInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictInfoDto:{}],根据Id更新字典类型正常,结果信息:{}",
                    "SysDictInfoApiImpl","updateById", JSON.toJSONString(sysDictInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictInfoDto:{}],根据Id更新字典类型异常,异常信息:{}",
                    "SysDictInfoApiImpl","updateById", JSON.toJSONString(sysDictInfoDto),e);
            resp.buildFail("根据Id更新字典类型失败");
        }
        return resp;
    }

    @Override
    public RespData<SysDictInfoDto> getById(Long id) {
        RespData<SysDictInfoDto> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取字典类型正常,结果信息:{}",
                    "SysDictInfoApiImpl","getById", id, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取字典类型异常,异常信息:{}",
                    "SysDictInfoApiImpl","getById", id, e);
            resp.buildFail("根据Id获取字典类型失败");
        }
        return resp;
    }

    @Override
    public RespData<List<SysDictInfoDto>> list(QuerySysDictInfoVo querySysDictInfoVo) {
        RespData<List<SysDictInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.list(querySysDictInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysDictInfoVo:{}],根据条件获取字典类型不分页信息正常,结果信息:{}",
                    "SysDictInfoApiImpl","list", JSON.toJSONString(querySysDictInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysDictInfoVo:{}],根据条件获取字典类型不分页信息异常,异常信息:{}",
                    "SysDictInfoApiImpl","list", JSON.toJSONString(querySysDictInfoVo), e);
            resp.buildFail("根据条件获取字典类型不分页列表信息失败");
        }
        return resp;
    }

    @Override
    public RespData<Pagination<SysDictInfoDto>> pageList(QuerySysDictInfoVo querySysDictInfoVo) {
        RespData<Pagination<SysDictInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.pageList(querySysDictInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysDictInfoVo:{}],根据条件获取字典类型分页信息正常,结果信息:{}",
                    "SysDictInfoApiImpl","pageList", JSON.toJSONString(querySysDictInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysDictInfoVo:{}],根据条件获取字典类型分页信息异常,异常信息:{}",
                    "SysDictInfoApiImpl","pageList", JSON.toJSONString(querySysDictInfoVo), e);
            resp.buildFail("根据条件获取字典类型分页列表信息失败");
        }
        return resp;
    }

    @Override
    public RespData<String> enable(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.enable(sysDictInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictInfoDto:{}],启用字典类型正常,结果信息:{}",
                    "SysDictInfoApiImpl","enable", JSON.toJSONString(sysDictInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictInfoDto:{}],启用字典类型异常,异常信息:{}",
                    "SysDictInfoApiImpl","enable", JSON.toJSONString(sysDictInfoDto), e);
            resp.buildFail("启用字典类型失败");
        }
        return resp;
    }

    @Override
    public RespData<String> disable(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.disable(sysDictInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictInfoDto:{}],禁用字典类型正常,结果信息:{}",
                    "SysDictInfoApiImpl","disable", JSON.toJSONString(sysDictInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictInfoDto:{}],禁用字典类型异常,异常信息:{}",
                    "SysDictInfoApiImpl","disable", JSON.toJSONString(sysDictInfoDto), e);
            resp.buildFail("禁用字典类型失败");
        }
        return resp;
    }

    @Override
    public RespData<String> deleteById(SysDictInfoDto sysDictInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDictInfoService.deleteById(sysDictInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDictInfoDto:{}],根据Id删除字典类型正常,结果信息:{}",
                    "SysDictInfoApiImpl","deleteById", JSON.toJSONString(sysDictInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDictInfoDto:{}],根据Id删除字典类型正常,异常信息:{}",
                    "SysDictInfoApiImpl","deleteById", JSON.toJSONString(sysDictInfoDto), e);
            resp.buildFail("删除字典类型失败");
        }
        return resp;
    }
}
