package org.magisoul.gcode.jdbc;

import org.magisoul.gcode.entity.GcDbConfigInfo;
import org.magisoul.gcode.mapper.IGcDbConfigInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate ;
    @Value("${gcode.schema}")
    private String schema ;

    @Autowired
    private IGcDbConfigInfoMapper gcDbConfigInfoMapper ;

    public void init(Long dbConfigId){

    }

    public JdbcModel getModelByDbConfigId(Long dbConfigId){
        if(dbConfigId.intValue()==-1){
            JdbcModel model = new JdbcModel();
            model.setJdbcTemplate(this.jdbcTemplate);
            model.setSchema(schema);
            return model ;
        }else{
            GcDbConfigInfo gcDbConfigInfo = this.gcDbConfigInfoMapper.getById(dbConfigId);
            if(gcDbConfigInfo==null){
                return null ;
            }else{
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName(gcDbConfigInfo.getDbDriver());
                dataSource.setUrl(gcDbConfigInfo.getDbUrl());
                dataSource.setUsername(gcDbConfigInfo.getDbUsername());
                dataSource.setPassword(gcDbConfigInfo.getDbPassword());

                JdbcModel model = new JdbcModel();
                model.setSchema(gcDbConfigInfo.getDbSchema());
                model.setJdbcTemplate(new JdbcTemplate(dataSource));
                return model ;
            }
        }
    }
}
