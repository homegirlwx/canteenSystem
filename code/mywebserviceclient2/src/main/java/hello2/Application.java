package hello2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Application {

    RestTemplate restTemplate = new RestTemplate();

    private static final Logger log = LoggerFactory.getLogger(Application.class);

//使用RestTemplate post提交文件

    String postUrl = "http://localhost:8080/upload";
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    MultiValueMap<String,Object> request =new LinkedMultiValueMap<String,Object>();

    FileSystemResource file = new FileSystemResource("E:/mm/m1.jpg");

    if(file!=null)

    {

        request.add("file",file);

    }

    ResponseEntity<String> rst = restTemplate.postForEntity(postUrl, request, String.class);

        log.info("Post File to Server:"+rst);

//使用RestTemplate模板获取RESTful服务:查看文件列表

    String serverUrl = "http://localhost:8080/fileList";

    List<String> restResult = restTemplate.getForObject(serverUrl, List.class);

log.info(restResult.toString());

}