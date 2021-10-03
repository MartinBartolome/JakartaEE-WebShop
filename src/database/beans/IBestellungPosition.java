package database.beans;

public interface IBestellungPosition {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getBestellungIdentifier();
    void setBestellungIdentifier(int bestellungIdentifier);
    int getArtikelIdentifier();
    void setArtikelIdentifier(int artikelIdentifier);
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
