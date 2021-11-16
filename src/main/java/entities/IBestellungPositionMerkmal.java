package entities;

public interface IBestellungPositionMerkmal {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getBestellungPositionIdentifier();
    void setBestellungPositionIdentifier(int bestellungPositionIdentifier);
    int getBeschreibung();
    void setBeschreibung(int beschreibung);
    String getSchluessel();
    void setSchluessel(String schluessel);
    String getWert();
    void setWert(String wert);
}
