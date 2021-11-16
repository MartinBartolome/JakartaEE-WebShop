package beans;

import java.util.Map;

public interface IMerkmaleKonfiguration {
    void setMerkmale(Map<String, IMerkmal> merkmale);
    Map<String, IMerkmal> getMerkmale();
    String getDetails();
}
