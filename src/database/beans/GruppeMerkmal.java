package database.beans;

public class GruppeMerkmal implements IGruppeMerkmal {
    private int identifier;
    private int gruppeIdentifier;
    private String schluessel;
    private String wert;

    public int GetIdentifier() {
        return this.identifier;
    }

    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int GetGruppeIdentifier() {
        return this.gruppeIdentifier;
    }

    public void SetGruppeIdentifier(int gruppeIdentifier) {
        this.gruppeIdentifier = gruppeIdentifier;
    }

    public String GetSchluessel() {
        return this.schluessel;
    }

    public void SetSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    public String GetWert() {
        return this.wert;
    }

    public void SetWert(String wert) {
        this.wert = wert;
    }
}