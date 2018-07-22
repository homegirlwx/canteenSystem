package com.smart.web;

public class JsonImage {
    private String data;

    public JsonImage(String data){
        this.data = data;
    }

    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return data;
    }
}
