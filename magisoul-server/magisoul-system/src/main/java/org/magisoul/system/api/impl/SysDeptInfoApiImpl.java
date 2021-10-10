package org.magisoul.system.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysDeptInfoApi;
import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.system.model.query.QuerySysDeptInfoVo;
import org.magisoul.system.service.ISysDeptInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDeptInfoApi")
public class SysDeptInfoApiImpl implements ISysDeptInfoApi {

    @Autowired
    private ISysDeptInfoService sysDeptInfoService ;

    Logger logger = LoggerFactory.getLogger(SysDeptInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(SysDeptInfoDto sysDeptInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(sysDeptInfoDto.getId()==null){
                resp = this.sysDeptInfoService.add(sysDeptInfoDto);
            }else{
                resp = this.sysDeptInfoService.updateForm(sysDeptInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],编辑部门信息正常,结果信息:{}",
                    "SysDeptInfoApiImpl","mergeForm", JSON.toJSONString(sysDeptInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],编辑部门信息异常,异常信息:{}",
                    "SysDeptInfoApiImpl","mergeForm", JSON.toJSONString(sysDeptInfoDto),e);
            resp.buildFail("编辑部门信息失败");
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(SysDeptInfoDto sysDeptInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.updateById(sysDeptInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],根据Id更新部门信息正常,结果信息:{}",
                    "SysDeptInfoApiImpl","updateById", JSON.toJSONString(sysDeptInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],根据Id更新部门信息异常,异常信息:{}",
                    "SysDeptInfoApiImpl","updateById", JSON.toJSONString(sysDeptInfoDto),e);
            resp.buildFail("根据Id更新部门信息失败");
        }
        return resp;
    }

    @Override
    public RespData<SysDeptInfoDto> getById(Long id) {
        RespData<SysDeptInfoDto> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取部门信息正常,结果信息:{}",
                    "SysDeptInfoApiImpl","getById", id,JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取部门信息异常,异常信息:{}",
                    "SysDeptInfoApiImpl","getById", id,e);
            resp.buildFail("根据Id获取部门信息失败");
        }
        return resp;
    }

    @Override
    public RespData<List<SysDeptInfoDto>> list(QuerySysDeptInfoVo querySysDeptInfoVo) {
        RespData<List<SysDeptInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.list(querySysDeptInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysDeptInfoVo:{}],获取部门不分页信息列表正常,结果信息:{}",
                    "SysDeptInfoApiImpl","list", JSON.toJSONString(querySysDeptInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysDeptInfoVo:{}],获取部门不分页信息列表异常,异常信息:{}",
                    "SysDeptInfoApiImpl","list", JSON.toJSONString(querySysDeptInfoVo), e);
            resp.buildFail("获取部门不分页列表失败");
        }
        return resp;
    }

    @Override
    public RespData<Pagination<SysDeptInfoDto>> pageList(QuerySysDeptInfoVo querySysDeptInfoVo) {
        RespData<Pagination<SysDeptInfoDto>> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.pageList(querySysDeptInfoVo);
            logger.info("类名:{},方法名:{},参数:[querySysDeptInfoVo:{}],获取部门分页信息列表正常,结果信息:{}",
                    "SysDeptInfoApiImpl","pageList", JSON.toJSONString(querySysDeptInfoVo), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[querySysDeptInfoVo:{}],获取部门分页信息列表异常,异常信息:{}",
                    "SysDeptInfoApiImpl","pageList", JSON.toJSONString(querySysDeptInfoVo), e);
            resp.buildFail("获取部门分页信息列表失败");
        }
        return resp;
    }

    @Override
    public RespData<String> enable(SysDeptInfoDto sysDeptInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.enable(sysDeptInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],更新部门状态为使用正常,结果信息:{}",
                    "SysDeptInfoApiImpl","enable", JSON.toJSONString(sysDeptInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],更新部门状态为使用异常,异常信息:{}",
                    "SysDeptInfoApiImpl","enable", JSON.toJSONString(sysDeptInfoDto), e);
            resp.buildFail("更新部门状态为使用失败");
        }
        return resp;
    }

    @Override
    public RespData<String> disable(SysDeptInfoDto sysDeptInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.disable(sysDeptInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],更新部门状态为禁用正常,结果信息:{}",
                    "SysDeptInfoApiImpl","disable", JSON.toJSONString(sysDeptInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],更新部门状态为禁用异常,异常信息:{}",
                    "SysDeptInfoApiImpl","disable", JSON.toJSONString(sysDeptInfoDto), e);
            resp.buildFail("更新部门状态为禁用失败");
        }
        return resp;
    }

    @Override
    public RespData<String> deleteById(SysDeptInfoDto sysDeptInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.sysDeptInfoService.disable(sysDeptInfoDto);
            logger.info("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],根据Id删除部门正常,结果信息:{}",
                    "SysDeptInfoApiImpl","deleteById", JSON.toJSONString(sysDeptInfoDto), JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[sysDeptInfoDto:{}],根据Id删除部门异常,异常信息:{}",
                    "SysDeptInfoApiImpl","deleteById", JSON.toJSONString(sysDeptInfoDto), e);
            resp.buildFail("根据Id删除部门失败");
        }
        return resp;
    }
}
