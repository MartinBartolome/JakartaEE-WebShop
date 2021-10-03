package database.beans;

public interface IAdresse {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getKundeIdentifier();
    void setKundeIdentifier(int kundeIdentifier);
    String getStrasse();
    void setStrasse(String strasse);
    String getPostleitzahl();
    void setPostleitzahl(String postleitzahl);
    String getOrt();
    void setOrt(String ort);
}
