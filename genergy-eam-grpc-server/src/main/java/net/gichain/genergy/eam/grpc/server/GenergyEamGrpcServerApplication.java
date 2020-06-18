package net.gichain.genergy.eam.grpc.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.gichain.genergy.eam.database.mapper")
public class GenergyEamGrpcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenergyEamGrpcServerApplication.class, args);
	}

}
