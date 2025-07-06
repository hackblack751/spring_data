package org.huy;

import org.huy.entity.h2.CarEntity;
import org.huy.repository.h2.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner dataInitializer(CarRepository carRepository) {
		return args -> {
			CarEntity car = new CarEntity();
			car.setBrand("honda");
			car.setName("civic 2023");
			carRepository.save(car);

			car = new CarEntity();
			car.setBrand("nissan");
			car.setName("gtr 1992");
			carRepository.save(car);
		};
	}
}
