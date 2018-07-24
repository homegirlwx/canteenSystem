package com.smart.web;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController{

    private final ResourceLoader resourceLoader;
    //private AtomicLong atomiclong ;

    Random random = new Random();

    //private Logger logger = Logger.getLogger(LoginController.class);


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public LoginController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    @Value("${web.posturl}")
    private String posturl;

    @RequestMapping(value = "/loginCheck")
    public User loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        //boolean isValidUser =  userService.hasMatchUser(loginCommand.getUserName(),
           //     loginCommand.getPassword());
        //if (!isValidUser) {
         //   return null;
        //} else {
            //User user = userService.findUserByUserAlias(loginCommand
                 //   .getUserName());
           // user.setLastIp(request.getLocalAddr());
           // user.setLastVisit(new Date());
            //userService.loginSuccess(user);
           // request.getSession().setAttribute("user", user);
            return null;
        //}
    }

    /**
     * 文件上传具体实现方法;
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/showPhoto", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("fileName") MultipartFile file,  Map<String, Object> map) {

        if (!file.isEmpty()) {

            // 要上传的目标文件存放路径
            String localPath = path;
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

    //通过web上传并存储图片
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonImage sc( String sj ) throws Exception {
        System.out.println(sj);
        String filename = FileNameUtils.getFileName();
        //ResponseEntity<String> rst = restTemplate.postForEntity(postUrl, request, String.class);
        return new JsonImage(ImageConversion.GenerateImage(sj, filename, path));
    }

    //显示图片
    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> showPhotos() {
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + "20180720.jpg"));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * @createtime 2017年8月20日17:15:41
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */

    @RequestMapping(value = "/uploadfromwechat", method = RequestMethod.POST)
    public String uploadfromwechat(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        //System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        //System.out.println("执行图片上传");
        if(!file.isEmpty()) {

            String fileName = file.getOriginalFilename();
            String filepath = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            System.out.println("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = path;
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    filepath = realPath + trueFileName;
                    File dest = new File(filepath);
                    //判断文件父目录是否存在
                    if(!dest.getParentFile().exists()){
                        dest.getParentFile().mkdir();
                    }
                    try {
                        //保存文件
                        file.transferTo(dest);
                        return "saved";
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return "IllegalStateException";
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return "IOExceptio";
                    }

                    //调用后端图像识别服务
                   // FileSystemResource resource = new FileSystemResource(new File(filepath));
                    //MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
                    //param.add("file", resource);

                    //JsonResult res = restTemplate.postForObject(posturl, param, JsonResult.class);


                   // return "success!";
                }else {
                    //System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            }else {
                //System.out.println("文件类型为空");
                return "error";
            }
        }else {
            //System.out.println("没有找到相对应的文件");
            return "error";
        }
        //return "success";
    }


}
