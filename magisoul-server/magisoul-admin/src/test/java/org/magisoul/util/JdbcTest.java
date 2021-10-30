package org.magisoul.util;

import org.junit.jupiter.api.Test;
import org.magisoul.gcode.jdbc.BaseDao;
import org.magisoul.gcode.jdbc.GcodeDao;
import org.magisoul.gcode.jdbc.JdbcModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@SpringBootTest
public class JdbcTest {

    @Autowired
    private BaseDao baseDao ;

    @Test
    public void testTable() throws SQLException {
        JdbcModel model = baseDao.getModelByDbConfigId(new Long(-1));

        GcodeDao gcodeDao = new GcodeDao(model.getJdbcTemplate(),model.getSchema());
        gcodeDao.getTableList();
    }

}
