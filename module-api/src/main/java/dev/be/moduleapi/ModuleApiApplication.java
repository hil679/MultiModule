package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
scanBasePackages 옵션을 이용해 path가 맞지 않은 high 모듈의 bean 사용할 수 있음
 */
@SpringBootApplication(
		//해당 모듈에서 bean으로 등록해야하는 것만 위치 넣어줌
		scanBasePackages = {"dev.be.moduleapi", "dev.be.modulecommon"} //component scan 원하는 path적기
)
public class ModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}

}
