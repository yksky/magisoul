package org.magisoul.admin.interceptor;

import com.alibaba.fastjson.JSON;
import org.magisoul.admin.context.UserContext;
import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.service.ITokenService;
import org.magisoul.util.ObjectUtil;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthInteceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AuthInteceptor.class);

    @Autowired
    private ITokenService tokenService ;

    //进入controller之前,拦截请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        //获取url地址
        String uri = request.getRequestURI();
        logger.info("当前url:{}",uri);
        boolean isMatch = this.isMatchUrl(uri);
        if(isMatch){
            return true ;
        }

        //获取Header中的数据
        Map<String,String> headerMap = this.getHeaderMap(request);
        String token = this.getToken(headerMap,"X-Token");
        RespData<SysUserInfoDto> resp = this.tokenService.checkToken(token);
        if(resp.isSuccess()){
            SysUserInfoDto data = resp.getData();
            UserContext.setUser(data);
            return true ;
        }else{
            response.getWriter().write(JSON.toJSONString(resp));
            return false ;
        }
    }

    //调用完controller之后,视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{

    }

    //整个完成之后,通常用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handle,Exception ex)throws Exception{

    }

    //url地址白名单处理
    private boolean isMatchUrl(String url){
        String[] urlArrays = {"login"};

        for(int i=0;i< urlArrays.length;i++){
            String urlItem = urlArrays[i].trim();
            if(url.indexOf(url)!=-1){
                return true ;
            }
        }

        return false ;
    }


    private Map<String,String> getHeaderMap(HttpServletRequest request){
        Map<String,String> haderMap = new HashMap<String,String>();
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = (String)headerNames.nextElement();
            String value = request.getHeader(key);
            haderMap.put(key,value);
        }
        return haderMap;
    }

    private String getToken(Map<String,String> headerMap,String key){
        if(headerMap.containsKey(key)){
            return headerMap.get(key);
        }else{
            return null ;
        }
    }
}
