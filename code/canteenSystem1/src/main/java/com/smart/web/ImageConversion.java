package com.smart.web;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageConversion {
    public static String returnImage(){
        BASE64Encoder encoder = new BASE64Encoder();
        //String str1= encoder.encode(base64String.getBytes());
        return null;
    }
    public static String GenerateImage(String imgStr, String filename) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return "null?";

        try {
            // Base64解码
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(imgStr);


            // byte[] bytes = Base64.decodeBase64(imgStr);   //或用Base64 解   org.apache.commons.codec.binary.Base64;


            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            String localPath = "F:/uploadphoto";

            String imgFilePath = localPath + "/" + filename + ".png";

            // 生成jpeg图片

           OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();



            byte[] data = null;

            // 读取图片字节数组
            try {
                InputStream in = new FileInputStream(imgFilePath);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(data);// 返回Base64编码过的字节数组字符串

        } catch (Exception e) {
          return "null";
        }

    }
}