package org.magisoul.gcode.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcFieldInfoApi;
import org.magisoul.gcode.model.dto.GcFieldInfoDto;
import org.magisoul.gcode.model.query.QueryGcFieldInfoVo;
import org.magisoul.gcode.service.IGcFieldInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gcFieldInfoApi")
public class GcFieldInfoApiImpl implements IGcFieldInfoApi {

    @Autowired
    private IGcFieldInfoService gcFieldInfoService ;

    Logger logger = LoggerFactory.getLogger(GcFieldInfoApiImpl.class);

    @Override
    public RespData<String> updateForm(GcFieldInfoDto gcFieldInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.gcFieldInfoService.updateForm(gcFieldInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcFieldInfoDto:{}],编辑字段信息正常,结果信息:{}",
                    "GcFieldInfoApiImpl","updateForm", JSON.toJSONString(gcFieldInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcFieldInfoDto:{}],编辑字段信息异常,异常信息:{}",
                    "GcFieldInfoApiImpl","updateForm", JSON.toJSONString(gcFieldInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<String> updateById(GcFieldInfoDto gcFieldInfoDto) {
        RespData<String> resp = new RespData<>();
        try {
            resp = this.gcFieldInfoService.updateById(gcFieldInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcFieldInfoDto:{}],根据Id更新字段信息正常,结果信息:{}",
                    "GcFieldInfoApiImpl","updateById", JSON.toJSONString(gcFieldInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcFieldInfoDto:{}],根据Id更新字段信息异常,异常信息:{}",
                    "GcFieldInfoApiImpl","updateById", JSON.toJSONString(gcFieldInfoDto),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<GcFieldInfoDto> getById(Long id) {
        RespData<GcFieldInfoDto> resp = new RespData<>();
        try{
            resp = this.gcFieldInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取字段信息正常,结果信息:{}",
                    "GcFieldInfoApiImpl","getById", id,JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取字段信息异常,异常信息:{}",
                    "GcFieldInfoApiImpl","getById", id,e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<GcFieldInfoDto>> list(QueryGcFieldInfoVo queryGcFieldInfoVo) {
        RespData<List<GcFieldInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcFieldInfoService.list(queryGcFieldInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcFieldInfoVo:{}],根据条件获取字段不分页信息正常,结果信息:{}",
                    "GcFieldInfoApiImpl","list", JSON.toJSONString(queryGcFieldInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcFieldInfoVo:{}],根据条件获取字段不分页信息异常,异常信息:{}",
                    "GcFieldInfoApiImpl","list", JSON.toJSONString(queryGcFieldInfoVo),e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<Pagination<GcFieldInfoDto>> pageList(QueryGcFieldInfoVo queryGcFieldInfoVo) {
        RespData<Pagination<GcFieldInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcFieldInfoService.pageList(queryGcFieldInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcFieldInfoVo:{}],根据条件获取字段分页信息正常,结果信息:{}",
                    "GcFieldInfoApiImpl","pageList", JSON.toJSONString(queryGcFieldInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcFieldInfoVo:{}],根据条件获取字段分页信息异常,异常信息:{}",
                    "GcFieldInfoApiImpl","pageList", JSON.toJSONString(queryGcFieldInfoVo),e);
            resp.buildFail();
        }
        return resp;
    }
}
