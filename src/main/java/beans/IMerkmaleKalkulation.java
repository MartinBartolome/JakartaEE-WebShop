package beans;

import java.util.Map;

public interface IMerkmaleKalkulation {
    Map<String, IArtikelMerkmal> getMerkmale();
    String getBeschreibungMenge();
    String getMenge();
    void setMenge(String menge);
    String getBeschreibungPreiProEinheit();
    String getPreisProEinheit();
    void setPreisProEinheit(String preisProEinheit);
    String getBeschreibungBetrag();
    String getBetrag();
}
