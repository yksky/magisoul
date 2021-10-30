package org.magisoul.gcode.jdbc;

import org.magisoul.gcode.entity.GcFieldInfo;
import org.magisoul.gcode.entity.GcTableInfo;
import org.magisoul.util.BaseUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GcodeDao {

    private JdbcTemplate jdbcTemplate ;
    private String schema ;

    public GcodeDao(JdbcTemplate jdbcTemplate,String schema){
        this.jdbcTemplate = jdbcTemplate ;
        this.schema = schema ;
    }

    public List<GcTableInfo> getTableList() throws SQLException {
        List<GcTableInfo> tableInfoList = new ArrayList<>();
        DatabaseMetaData metaData = this.jdbcTemplate.getDataSource().getConnection().getMetaData();
        String[] types = {"TABLE"};

        ResultSet resultSet = null ;
        try{
            resultSet = metaData.getTables(schema, null, "%",types);
            ResultSetMetaData rsmd = resultSet.getMetaData();

            while(resultSet.next()){
                String tableName = resultSet.getString("table_name");
                String remarks = resultSet.getString("remarks");

                GcTableInfo gcTableInfo = new GcTableInfo();
                gcTableInfo.setName(tableName);
                gcTableInfo.setComment(remarks);
                tableInfoList.add(gcTableInfo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(resultSet!=null) resultSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return tableInfoList ;
    }

    public List<GcFieldInfo> getFieldList(String tableName){
        List<GcFieldInfo> fieldList = new ArrayList<>();

        ResultSet rs = null ;
        try{
            DatabaseMetaData metaData = this.jdbcTemplate.getDataSource().getConnection().getMetaData();
            rs = metaData.getColumns(schema,"%",tableName,"%");
            while(rs.next()){
                String dbFieldName = rs.getString("COLUMN_NAME");
                String dbFieldComment = rs.getString("REMARKS");
                String dbFieldType = rs.getString("TYPE_NAME");
                String columnSize = rs.getString("COLUMN_SIZE");

                GcFieldInfo fieldInfo = new GcFieldInfo();
                fieldInfo.setDbFieldName(dbFieldName);
                fieldInfo.setDbFieldComment(dbFieldComment);
                fieldInfo.setDbFieldType(dbFieldType);
                if(columnSize==null) {
                    fieldInfo.setDbFieldSize(new Long(0));
                }else {
                    fieldInfo.setDbFieldSize(Long.parseLong(columnSize));
                }

                fieldInfo.setFieldClassName(BaseUtil.getFieldName(dbFieldName,1));
                fieldInfo.setFieldEntityName(BaseUtil.getFieldName(dbFieldName,0));

                Map<String,String> fieldMap = BaseUtil.getFieldType(dbFieldType, "mysql");
                String fieldType = fieldMap.get("fieldType");
                String strImport = fieldMap.get("strImport");

                fieldInfo.setFieldImport(strImport);
                fieldInfo.setFieldType(fieldType);

                fieldList.add(fieldInfo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rs!=null) rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return fieldList ;
    }
}
