package entities;

public interface IArtikelMerkmalBeschreibung {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getArtikelMerkmalIdentifier();
    void setArtikelMerkmalIdentifier(int artikelMerkmalIdentifier);
    int getSprache();
    void setSprache(int sprache);
    String getBeschreibung();
    void setBeschreibung(String beschreibung);
}
