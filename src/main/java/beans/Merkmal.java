package beans;

public class Merkmal implements IMerkmal {
    private String wert = "";
    private String beschreibung = "";

    public String getWert() {
        return this.wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
