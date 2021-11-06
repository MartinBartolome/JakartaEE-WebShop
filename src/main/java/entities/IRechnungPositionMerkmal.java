package entities;

public interface IRechnungPositionMerkmal {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getRechnungPositionIdentifier();
    void setRechnungPositionIdentifier(int rechnungPositionIdentifier);
    String getBeschreibung();
    void setBeschreibung(String beschreibung);
    String getSchluessel();
    void setSchluessel(String schluessel);
    String getWert();
    void setwert(String wert);
}
