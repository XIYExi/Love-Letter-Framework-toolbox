package com.xion.wiki;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@MapperScan("com.xion.wiki")
@SpringBootApplication
public class WikiApiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WikiApiApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WikiApiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
