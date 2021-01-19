package com.nspc;

import com.nspc.services.OwnerService;
import com.nspc.services.VetService;
import com.nspc.services.map.OwnerServiceMap;
import com.nspc.services.map.VetServiceMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NsPetClinicApplication {

	public static void main(String[] args) {

		SpringApplication.run(NsPetClinicApplication.class, args);
	}
	@Bean
	public VetService vetService(){
		return new VetServiceMap();
	}
	@Bean
	public OwnerService ownerService(){
		return new OwnerServiceMap();
	}

}
