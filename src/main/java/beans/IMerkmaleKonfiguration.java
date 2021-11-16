package beans;

import java.util.Map;

public interface IMerkmaleKonfiguration {
    Map<String, IArtikelMerkmal> getMerkmale();
    String getDetails();
}
