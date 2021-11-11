package beans;

import java.util.HashMap;
import java.util.Map;

public class MerkmaleKonfiguration implements IMerkmaleKonfiguration {
    protected Map<String, IArtikelMerkmal> merkmale;
    protected String details = "";

    public MerkmaleKonfiguration() {
        this.merkmale = new HashMap<>();
    }

    public Map<String, IArtikelMerkmal> getMerkmale() {
        return this.merkmale;
    }

    public String getDetails() {
        return this.details ;
    }
}
