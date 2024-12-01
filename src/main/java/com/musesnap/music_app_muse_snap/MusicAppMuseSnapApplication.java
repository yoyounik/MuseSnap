package com.musesnap.music_app_muse_snap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MusicAppMuseSnapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicAppMuseSnapApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
