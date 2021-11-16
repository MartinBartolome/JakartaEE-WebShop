package entities;

public interface IBestellung {
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
    String getEmpfaengerZahlungsArt();
    void setEmpfaengerZahlungsArt(String empfaengerZahlungsArt);
    String getEmpfaengerNummerKreditkarte();
    void setEmpfaengerNummerKreditkarte(String empfaengerNummerKreditkarte);
    String getEmpfaengerVerfallKreditkarte();
    void setEmpfaengerVerfallKreditkarte(String empfaengerVerfallKreditkarte);
    int getDatumBestellung();
    void setDatumBestellung(int datumBestellung);
    int getDatumAuslieferung();
    void setDatumAuslieferung(int datumAuslieferung);
    int getZustand();
    void setZustand(int zustand);
}
