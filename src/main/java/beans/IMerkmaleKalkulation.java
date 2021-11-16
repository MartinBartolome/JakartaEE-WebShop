package beans;

import jakarta.faces.event.ValueChangeEvent;

import java.util.Map;

public interface IMerkmaleKalkulation {
    void setMerkmale(Map<String, IMerkmal> merkmale);
    Map<String, IMerkmal> getMerkmale();
    String getBeschreibungMenge();
    String getMenge();
    void setMenge(String menge);
    String getBeschreibungPreiProEinheit();
    String getPreisProEinheit();
    void setPreisProEinheit(String preisProEinheit);
    String getBeschreibungBetrag();
    String getBetrag();
    void setBetrag(String betrag);
    float getVersandKostenProEinheit();
    float getSteuernSatz();
    void MengeChanged(ValueChangeEvent vce);
}
