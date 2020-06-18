package net.gichain.genergy.eam.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"net.gichain.genergy.eam"})
@MapperScan("net.gichain.genergy.eam.database.mapper")
public class GenergyEamAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenergyEamAdminApplication.class, args);
    }

}
