package org.magisoul.gcode.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcModel {

    private JdbcTemplate jdbcTemplate ;
    private String schema ;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
