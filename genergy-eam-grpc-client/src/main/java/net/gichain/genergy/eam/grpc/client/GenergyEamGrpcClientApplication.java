package net.gichain.genergy.eam.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"net.gichain.genergy.eam"})
public class GenergyEamGrpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenergyEamGrpcClientApplication.class, args);
	}

}
