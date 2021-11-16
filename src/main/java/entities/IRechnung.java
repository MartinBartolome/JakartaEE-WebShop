package entities;

public interface IRechnung {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getKundeIdentifier();
    void setKundeIdentifier(int kundeIdentifier);
    String getEmpfaengerName();
    void setEmpfaengerName(String empfaengerName);
    String getEmpfaengerVorname();
    void setEmpfaengerVorname(String empfaengerVorname);
    String getEmpfaengerAddresse();
    void setEmpfaengerAddresse(String empfaengerAddresse);
    String getEmpfaengerPostleitzahl();
    void setEmpfaengerPostleitzahl(String empfaengerPostleitzahl);
    String getEmpfaengerOrt();
    void setEmpfaengerOrt(String empfaengerOrt);
    int getDatumRechnung();
    void setDatumRechnung(int datumRechnung);
}
