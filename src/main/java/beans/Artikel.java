package beans;

public class Artikel implements IArtikel {
    private int identifier = 0;
    private int nummer = 0;
    private String artikelArt = "";
    private String einheit = "";
    private String zustand = "";
    private String beschreibung = "";

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getNummer() {
        return this.nummer;
    }

    @Override
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String getArtikelArt() {
        return this.artikelArt;
    }

    @Override
    public void setArtikelArt(String artikelArt) {
        this.artikelArt = artikelArt;
    }

    @Override
    public String getEinheit() {
        return this.einheit;
    }

    @Override
    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    @Override
    public String getBeschreibung() {
        return this.beschreibung;
    }

    @Override
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public String getZustand() {
        return this.zustand;
    }

    @Override
    public void setZustand(String zustand) {
        this.zustand = zustand;
    }
}
