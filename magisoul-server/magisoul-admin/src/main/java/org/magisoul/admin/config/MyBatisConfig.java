package org.magisoul.admin.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan({"org.magisoul.gcode.mapper","org.magisoul.system.mapper"})
public class MyBatisConfig {

//    @Autowired
//    private DataSource dataSource ;
//
//    @Bean
//    public PlatformTransactionManager txManager(){
//        return new DataSourceTransactionManager(this.dataSource);
//    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource)throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*SqlMap.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.magisoul.system.entity,;org.magisoul.gcode.entity");
        return new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
    }

}
