package hello;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResult {
    private String Name = "111";

    private double Similarity;

    public double getSimilarity() {
        return Similarity;
    }

    public void setSimilarity(double Similarity) {
        this.Similarity = Similarity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "Name='" + Name + '\'' +
                ", Similarity=" + Similarity +
                '}';
    }
}
