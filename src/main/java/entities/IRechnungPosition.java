package entities;

public interface IRechnungPosition {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getRechnungIdentifier();
    void setRechnungIdentifier(int rechnungIdentifier);
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
