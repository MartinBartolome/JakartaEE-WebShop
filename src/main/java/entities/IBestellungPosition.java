package entities;

public interface IBestellungPosition {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getBestellungIdentifier();
    void setBestellungIdentifier(int bestellungIdentifier);
    int getArtikelIdentifier();
    void setArtikelIdentifier(int artikelIdentifier);
    String getBeschreibung();
    void setBeschreibung(String beschreibung);
    String getArtikelNummer();
    void setArtikelNummer(String artikelNummer);
    int getReihenfolge();
    void setReihenfolge(int reihenfolge);
    int getAnzahlEinheiten();
    void setAnzahlEinheiten(int anzahlEinheiten);
    float getPreisProEinheit();
    void setPreisProEinheit(float preisProEinheit);
}
