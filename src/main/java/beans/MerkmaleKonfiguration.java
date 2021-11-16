package beans;

import java.util.HashMap;
import java.util.Map;

public class MerkmaleKonfiguration implements IMerkmaleKonfiguration {
    private Map<String, IMerkmal> merkmale = null;
    protected String details = "";

    public void setMerkmale(Map<String, IMerkmal> merkmale) {
        this.merkmale = merkmale;
    }

    public Map<String, IMerkmal> getMerkmale() {
        return this.merkmale;
    }

    public String getDetails() {
        return this.details ;
    }
}
