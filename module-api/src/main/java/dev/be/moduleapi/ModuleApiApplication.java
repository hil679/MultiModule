package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
scanBasePackages 옵션을 이용해 path가 맞지 않은 high 모듈의 bean 사용할 수 있음
 */
@SpringBootApplication(
		//해당 모듈에서 bean으로 등록해야하는 것만 위치 넣어줌
		scanBasePackages = {"dev.be.moduleapi", "dev.be.modulecommon"} //component scan 원하는 path적기
)
/*
Parameter 1 of constructor in DemoService required a bean of type 'dev.be.modulecommon.repositories.MemberRepository'
=> specifying path because using those in another module
 */
@EntityScan("dev.be.modulecommon.domain")
@EnableJpaRepositories(basePackages = "dev.be.modulecommon.repositories")
public class ModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}

}
