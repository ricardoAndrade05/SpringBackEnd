package com.nelioalves.coursomc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.coursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		s3Service.uploadFile("D:\\Udemy - Spring Boot, Hibernate, REST, Ionic, JWT, S3, MySQL, MongoDB\\07 Armazenamento de imagens usando Amazon S3\\imagens\\Ricardinho.jpg");
	}

}
