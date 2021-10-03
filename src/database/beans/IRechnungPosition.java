package database.beans;

public interface IRechnungPosition {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getRechnungIdentifier();
    void setRechnungIdentifier(int rechnungIdentifier);
    int getBeschreibung();
    void setBeschreibung(int beschreibung);
    int getArtikelNummer();
    void setArtikelNummer(int artikelNummer);
    int getReihenfolge();
    void setReihenfolge(int reihenfolge);
    int getAnzahlEinheiten();
    void setAnzahlEinheiten(int anzahlEinheiten);
    int getPreisProEinheit();
    void setPreisProEinheit(int preisProEinheit);
}
