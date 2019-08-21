package com.huawei.servicestage.sample.springcloud.propertyinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.huawei.servicestage.sample.springcloud.propertyinfo.dao.PropertyDao;
import com.huawei.servicestage.sample.springcloud.propertyinfo.model.Property;

@SpringBootApplication
@EnableDiscoveryClient
public class PropertyinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyinfoApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadData(PropertyDao propertyDao) {
        return args -> {

        	propertyDao.save(new Property("p1", 5, "Condo", 800, "Swiming Pool, Gym, Parking", 600));
        	propertyDao.save(new Property("p2", 10, "Detach", 3500, "Brick Exterior, Swiming Pool", 0));
        	propertyDao.save(new Property("p3", 15, "TownHouse", 1500, "Brick Exterior", 0));
        	
        	System.out.println("property data loaded");
        };	
    }
}
