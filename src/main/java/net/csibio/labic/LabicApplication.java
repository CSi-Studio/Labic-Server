package net.csibio.labic;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableMongoAuditing
@EnableAspectJAutoProxy
@Slf4j
public class LabicApplication {

    public static void main(String[] args ) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(LabicApplication.class, args);
        final String COLON = ":";
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path") == null ? "" : env.getProperty("server.servlet.context-path");

        log.info("\n----------------------------------------------------------\n\t" +
                "Application Labic is running! Access URLs:\n\t" +
                "Front: \t\thttp://localhost" + COLON + port + path + "/\n\t" +
                "Local: \t\thttp://" + ip + COLON + port + path + "/\n\t" +
                "启动成功，Sa-Token 配置如下：" + SaManager.getConfig() +
//                "Swagger文档: \thttp://" + ip + COLON + port + path + "/swagger-ui/index.html\n" +
                "----------------------------------------------------------");
    }
}
