package org.magisoul.gcode.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcJobInfoApi;
import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.query.QueryGcJobInfoVo;
import org.magisoul.gcode.service.IGcJobInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gcJobInfoApi")
public class GcJobInfoApiImpl implements IGcJobInfoApi {

    @Autowired
    private IGcJobInfoService gcJobInfoService ;

    Logger logger = LoggerFactory.getLogger(GcJobInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(GcJobInfoDto gcJobInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(gcJobInfoDto.getId()==null){
                resp = this.gcJobInfoService.add(gcJobInfoDto);
            }else{
                resp = this.gcJobInfoService.updateForm(gcJobInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[gcJobInfoDto:{}],编辑任务信息正常,结果信息:{}",
                    "GcJobInfoApiImpl","mergeForm", JSON.toJSONString(gcJobInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcJobInfoDto:{}],编辑任务信息异常,异常信息:{}",
                    "GcJobInfoApiImpl","mergeForm", JSON.toJSONString(gcJobInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> updateById(GcJobInfoDto gcJobInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.gcJobInfoService.updateById(gcJobInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcJobInfoDto:{}],根据Id更新任务信息正常,结果信息:{}",
                    "GcJobInfoApiImpl","updateById", JSON.toJSONString(gcJobInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcJobInfoDto:{}],根据Id更新任务信息异常,异常信息:{}",
                    "GcJobInfoApiImpl","updateById", JSON.toJSONString(gcJobInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<GcJobInfoDto> getById(Long id) {
        RespData<GcJobInfoDto> resp = new RespData<>();
        try{
            resp = this.gcJobInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取任务信息正常,结果信息:{}",
                    "GcJobInfoApiImpl","getById", id,JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取任务信息异常,异常信息:{}",
                    "GcJobInfoApiImpl","getById", id,e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<GcJobInfoDto>> list(QueryGcJobInfoVo queryGcJobInfoVo) {
        RespData<List<GcJobInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcJobInfoService.list(queryGcJobInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcJobInfoVo:{}],根据条件获取任务不分页信息正常,结果信息:{}",
                    "GcJobInfoApiImpl","list", JSON.toJSONString(queryGcJobInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcJobInfoVo:{}],根据条件获取任务不分页信息异常,异常信息:{}",
                    "GcJobInfoApiImpl","list", JSON.toJSONString(queryGcJobInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<Pagination<GcJobInfoDto>> pageList(QueryGcJobInfoVo queryGcJobInfoVo) {
        RespData<Pagination<GcJobInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcJobInfoService.pageList(queryGcJobInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcJobInfoVo:{}],根据条件获取任务分页信息正常,结果信息:{}",
                    "GcJobInfoApiImpl","pageList", JSON.toJSONString(queryGcJobInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcJobInfoVo:{}],根据条件获取任务分页信息异常,异常信息:{}",
                    "GcJobInfoApiImpl","pageList", JSON.toJSONString(queryGcJobInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }
}
