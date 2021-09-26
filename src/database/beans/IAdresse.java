package database.beans;

public interface IAdresse {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetKundeIdentifier();
    void SetKundeIdentifier(int kundeIdentifier);
    String GetStrasse();
    void SetStrasse(String strasse);
    String GetPostleitzahl();
    void SetPostleitzahl(String postleitzahl);
    String GetOrt();
    void SetOrt(String ort);
}
