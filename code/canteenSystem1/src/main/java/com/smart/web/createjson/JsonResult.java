package com.smart.web.createjson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResult {
    private String Name;

    private double Similarity;

    public double getSimilarity() {
        return Similarity;
    }

    public void setSimilarity(double similarity) {
        Similarity = similarity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
