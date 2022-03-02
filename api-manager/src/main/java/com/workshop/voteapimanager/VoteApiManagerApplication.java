package com.workshop.voteapimanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VoteApiManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteApiManagerApplication.class, args);
	}

}
