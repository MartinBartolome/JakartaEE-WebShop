package database.beans;

public class GruppeMerkmal implements IGruppeMerkmal {
    private int identifier;
    private int gruppeIdentifier;
    private String schluessel;
    private String wert;

    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getGruppeIdentifier() {
        return this.gruppeIdentifier;
    }

    public void setGruppeIdentifier(int gruppeIdentifier) {
        this.gruppeIdentifier = gruppeIdentifier;
    }

    public String getSchluessel() {
        return this.schluessel;
    }

    public void setSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    public String getWert() {
        return this.wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }
}