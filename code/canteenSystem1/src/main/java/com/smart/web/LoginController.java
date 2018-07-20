package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController{
    private UserService userService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public LoginController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;



    @RequestMapping(value = "/loginCheck")
    public User loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser =  userService.hasMatchUser(loginCommand.getUserName(),
                loginCommand.getPassword());
        if (!isValidUser) {
            return null;
        } else {
            User user = userService.findUserByUserName(loginCommand
                    .getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return user;
        }
    }


    /**
     * 文件上传具体实现方法;
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/Photo", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("fileName") MultipartFile file,  Map<String, Object> map) {

        if (!file.isEmpty()) {

            // 要上传的目标文件存放路径
            String localPath = "F:/uploadphoto";
            // 上传成功或者失败的提示
            String msg = "";

            if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
                // 上传成功，给出页面提示
                msg =  "上传成功！";
            }else {
                msg =  "上传失败！";
            }
            // 显示图片
            map.put("msg", msg);
            map.put("fileName", file.getOriginalFilename());
            return msg;
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    //显示图片的方法关键 匹配路径像 localhost:8080/b7c76eb3-5a67-4d41-ae5c-1642af3f8746.png
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ResponseEntity<?> showPhotos(String fileName) {
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
