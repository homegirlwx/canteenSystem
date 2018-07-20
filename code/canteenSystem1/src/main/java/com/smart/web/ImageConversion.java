package com.smart.web;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImageConversion {
    public static boolean GenerateImage(String imgStr, String filename) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;

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

            String imgFilePath = localPath + "/" + filename + ".jpg";

            // 生成jpeg图片

           OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
          return false;
        }

    }
}