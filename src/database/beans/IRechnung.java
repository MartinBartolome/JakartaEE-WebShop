package database.beans;

public interface IRechnung {
    int GetIdentifier();
    void SetIdentifier(int identifier);
    int GetKundeIdentifier();
    void SetKundeIdentifier(int kundeIdentifier);
    String GetEmpfaengerName();
    void SetEmpfaengerName(String empfaengerName);
    String GetEmpfaengerVorname();
    void SetEmpfaengerVorname(String empfaengerVorname);
    String GetEmpfaengerAddresse();
    void SetEmpfaengerAddresse(String empfaengerAddresse);
    String GetEmpfaengerPostleitzahl();
    void SetEmpfaengerPostleitzahl(String empfaengerPostleitzahl);
    String GetEmpfaengerOrt();
    void SetEmpfaengerOrt(String empfaengerOrt);
    int GetDatumRechnung();
    void SetDatumRechnung(int datumRechnung);
}
