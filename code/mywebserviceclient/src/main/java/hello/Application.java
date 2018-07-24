package hello;

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
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            //Quote quote = restTemplate.getForObject(
             //       "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            //log.info(quote.toString());

            String filepath = "C:/Users/homegirl/Pictures/20180724193129.jpg";
            String posturl = "http://canteemsystem1.chinacloudsites.cn/uploadfromwechat";
            //String posturl = "http://test-123123.azurewebsites.net/Food/Get";
            FileSystemResource resource = new FileSystemResource(filepath);
            //File resource = new File(filepath);
            //OutputStream outputStream = new FileOutputStream(new File(filepath));
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            //Map<String, Object> param = new HashMap<>();
            param.add("file1", resource);
            //param.add("file1", outputStream);
            //System.out.println(resource.contentLength());
            ResponseEntity<String> res = restTemplate.postForEntity(posturl, param, String.class);
            //ResponseEntity<String> res = restTemplate.postForEntity(posturl,param , String.class, param);
            //JsonResult res = restTemplate.postForObject(posturl, param, JsonResult.class);

            //String s = restTemplate.getForObject(posturl, String.class);
            log.info(res.toString());
            //log.info(s);
        };
    }
}