package database.beans;

public interface IBestellung {
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
    String GetEmpfaengerZahlungsArt();
    void SetEmpfaengerZahlungsArt(String empfaengerZahlungsArt);
    String GetEmpfaengerNummerKreditkarte();
    void SetEmpfaengerNummerKreditkarte(String empfaengerNummerKreditkarte);
    String GetEmpfaengerVerfallKreditkarte();
    void SetEmpfaengerVerfallKreditkarte(String empfaengerVerfallKreditkarte);
    int GetDatumBestellung();
    void SetDatumBestellung(int datumBestellung);
    int GetDatumAuslieferung();
    void SetDatumAuslieferung(int datumAuslieferung);
    String GetZustand();
    void SetZustand(String zustand);
}
