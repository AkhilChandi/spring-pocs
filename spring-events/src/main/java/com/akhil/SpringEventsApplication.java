package com.akhil;

import com.example.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringEventsApplication implements CommandLineRunner {

	@Autowired
	private HelloService helloService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEventsApplication.class, args);
	}

	/*//This is for asynchronous execution
	@Bean(name = "applicationEventMulticaster")
	public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMulticaster
				= new SimpleApplicationEventMulticaster();

		eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return eventMulticaster;
	}

	@Async
	@EventListener(condition = "#event.message == \"Hello World!....\"")
	public void  springEventListener(CustomSpringEvent event){
		log.info("Custom Spring Event Received : {}",event);
	}*/

	@Override
	public void run(String... args) throws Exception {
		helloService.sayHello();
	}
}
