package database.beans;

public class ArtikelMerkmal implements IArtikelMerkmal {
    private int identifier;
    private int artikelIdentifier;
    private String schluessel;
    private String wert;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void setArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
    }

    @Override
    public String getSchluessel() {
        return this.schluessel;
    }

    @Override
    public void setSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    @Override
    public String getWert() {
        return this.wert;
    }

    @Override
    public void setWert(String wert) {
        this.wert = wert;
    }
}
