package database.beans;

public interface IBestellungPositionMerkmal {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetBestellungPositionIdentifier();
    void SetBestellungPositionIdentifier(int bestellungPositionIdentifier);
    int GetBeschreibung();
    void SetBeschreibung(int beschreibung);
    String GetSchluessel();
    void SetSchluessel(String schluessel);
    String GetWert();
    void SetWert(String wert);
}
