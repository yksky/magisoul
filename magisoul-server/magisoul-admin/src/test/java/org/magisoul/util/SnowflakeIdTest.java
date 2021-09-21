package org.magisoul.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SnowflakeIdTest {

    @Test
    public void testId(){
        SnowflakeIdUtil idUtil = new SnowflakeIdUtil(0,0);
        long id = idUtil.nextId();
        System.out.println("id:"+id);
    }

}
