package org.magisoul.admin.interceptor;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.util.List;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Bean
    public AuthInteceptor setAuthInteceptor(){
        return new AuthInteceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册自定义的拦截器
        String[] exculudes = new String[]{"/*.html","/html/**","/js/**","/css/**","/images/**"};
        registry.addInterceptor(setAuthInteceptor()).addPathPatterns("/**").excludePathPatterns(exculudes);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        FastJsonHttpMessageConverter fastConverter =
                new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        //serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        //serializeConfig.put(Long.class, ToStringSerializer.instance);
        //serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        //fastJsonConfig.setSerializeConfig(serializeConfig);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

}
