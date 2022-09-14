package tw.leonchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//存取外部資源 ,讀取 "jdbc.properties 這份檔案"
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class DemoSpringBootProjectApplication {
	//以前tomcat 手動載入 ,現在此java檔案直接啓動
//	Run as Java application(不要選擇 server) ,本身就是一個server java檔案, run之後 就會直接啓動

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootProjectApplication.class, args);
	}

}
