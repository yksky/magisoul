package org.magisoul.gcode.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcModuleInfoApi;
import org.magisoul.gcode.model.dto.GcModuleInfoDto;
import org.magisoul.gcode.model.query.QueryGcModuleInfoVo;
import org.magisoul.gcode.service.IGcModuleInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gcModuleInfoApi")
public class GcModuleInfoApiImpl implements IGcModuleInfoApi {

    @Autowired
    private IGcModuleInfoService gcModuleInfoService ;

    Logger logger = LoggerFactory.getLogger(GcModuleInfoApiImpl.class);

    @Override
    public RespData<String> merge(GcModuleInfoDto gcModuleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(gcModuleInfoDto.getId()==null){
                resp = this.gcModuleInfoService.add(gcModuleInfoDto);
            }else{
                resp = this.gcModuleInfoService.updateForm(gcModuleInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[gcModuleInfoDto:{}],编辑模块信息正常,结果信息:{}",
                    "GcModuleInfoApiImpl","mergeForm", JSON.toJSONString(gcModuleInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcModuleInfoDto:{}],编辑模块信息异常,异常信息:{}",
                    "GcModuleInfoApiImpl","mergeForm", JSON.toJSONString(gcModuleInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(GcModuleInfoDto gcModuleInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.gcModuleInfoService.updateById(gcModuleInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcModuleInfoDto:{}],根据Id更新模块信息正常,结果信息:{}",
                    "GcModuleInfoApiImpl","updateById", JSON.toJSONString(gcModuleInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcModuleInfoDto:{}],根据Id更新模块信息异常,异常信息:{}",
                    "GcModuleInfoApiImpl","updateById", JSON.toJSONString(gcModuleInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<GcModuleInfoDto> getById(Long id) {
        RespData<GcModuleInfoDto> resp = new RespData<>();
        try{
            resp = this.gcModuleInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取模块信息正常,结果信息:{}",
                    "GcModuleInfoApiImpl","getById", id, JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取模块信息异常,异常信息:{}",
                    "GcModuleInfoApiImpl","getById", id, e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<GcModuleInfoDto>> list(QueryGcModuleInfoVo queryGcModuleInfoVo) {
        RespData<List<GcModuleInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcModuleInfoService.list(queryGcModuleInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcModuleInfoVo:{}],根据条件获取Module不分页信息正常,结果信息:{}",
                    "GcModuleInfoApiImpl","list", JSON.toJSONString(queryGcModuleInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcModuleInfoVo:{}],根据条件获取Module不分页信息异常,异常信息:{}",
                    "GcModuleInfoApiImpl","list", JSON.toJSONString(queryGcModuleInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<Pagination<GcModuleInfoDto>> pageList(QueryGcModuleInfoVo queryGcModuleInfoVo) {
        RespData<Pagination<GcModuleInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcModuleInfoService.pageList(queryGcModuleInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcModuleInfoVo:{}],根据条件获取Module分页信息正常,结果信息:{}",
                    "GcModuleInfoApiImpl","pageList", JSON.toJSONString(queryGcModuleInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcModuleInfoVo:{}],根据条件获取Module分页信息异常,异常信息:{}",
                    "GcModuleInfoApiImpl","pageList", JSON.toJSONString(queryGcModuleInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }
}
