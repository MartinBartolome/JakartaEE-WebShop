package beans;

import jakarta.faces.event.ValueChangeEvent;

import java.util.HashMap;
import java.util.Map;

public class MerkmaleKalkulation implements IMerkmaleKalkulation {
    private Map<String, IMerkmal> merkmale = null;

    public void setMerkmale(Map<String, IMerkmal> merkmale) {
        this.merkmale = merkmale;
    }

    public Map<String, IMerkmal> getMerkmale() {
        return this.merkmale;
    }

    public String getBeschreibungMenge() {
        return this.merkmale.get("PMenge").getBeschreibung();
    }

    public String getMenge() {
        return this.merkmale.get("PMenge").getWert();
    }

    public void setMenge(String wert) {
        this.merkmale.get("PMenge").setWert(wert);
    }

    public String getBeschreibungPreiProEinheit() {
        return this.merkmale.get("PPreisEinheit").getBeschreibung();
    }

    public String getPreisProEinheit() {
        return this.merkmale.get("PPreisEinheit").getWert();
    }

    public void setPreisProEinheit(String wert) {
        this.merkmale.get("PPreisEinheit").setWert(wert);
    }

    public String getBeschreibungBetrag() {
        return this.merkmale.get("PBetrag").getBeschreibung();
    }

    public String getBetrag() {
        return this.merkmale.get("PBetrag").getWert();
    }

    public void setBetrag(String wert) {
        this.merkmale.get("PBetrag").setWert(wert);
    }

    public String getVariableBeschreibung() {
        return this.merkmale.get("PVariable").getBeschreibung();
    }

    public String getVariable() {
        return this.merkmale.get("PVariable").getWert();
    }

    public void setVariable(String wert) {
        this.merkmale.get("PVariable").setWert(wert);
    }

    public float getVersandKostenProEinheit() {
        return Float.parseFloat(this.merkmale.get("PVersand").getWert());
    }

    public float getSteuernSatz() {
        return Float.parseFloat(this.merkmale.get("PSteuern").getWert());
    }
    public void MengeChanged(ValueChangeEvent vce) {
        float menge=Float.parseFloat(vce.getNewValue().toString());
        float preisproeinheit=Float.parseFloat(getPreisProEinheit());
        setBetrag(String.valueOf(menge*preisproeinheit));
    }
}
