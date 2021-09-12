package org.magisoul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MagisoulApplication {

    static Logger logger = LoggerFactory.getLogger(MagisoulApplication.class);

    public static void main(String[] args){
        logger.info("MagisoulApplication started successful!");
        SpringApplication.run(MagisoulApplication.class,args);
    }

}
