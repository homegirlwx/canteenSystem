package com.smart.web;

import java.util.UUID;

/**
 * 生成文件名
 */
public class FileNameUtils {

    public static String getFileName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}