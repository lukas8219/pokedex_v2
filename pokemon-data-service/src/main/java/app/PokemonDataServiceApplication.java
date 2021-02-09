package app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {
		  MongoAutoConfiguration.class, 
		  MongoDataAutoConfiguration.class
		})

@EnableEurekaClient
public class PokemonDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonDataServiceApplication.class, args);
	}

}
