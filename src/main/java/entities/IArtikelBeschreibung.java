package entities;

public interface IArtikelBeschreibung {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getArtikelIdentifier();
    void setArtikelIdentifier(int artikelIdentifier);
    int getSprache();
    void setSprache(int sprache);
    String getBeschreibung();
    void setBeschreibung(String beschreibung);
}
