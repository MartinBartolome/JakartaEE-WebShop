package database.beans;

public class Bestellung implements IBestellung {
    private int identifier;
    private int kundeIdentifier;
    private String empfaengerName;
    private String empfaengerVorname;
    private String empfaengerAddresse;
    private String empfaengerPostleitzahl;
    private String empfaengerOrt;
    private String empfaengerZahlungsArt;
    private String empfaengerNummerKreditkarte;
    private String empfaengerVerfallKreditkarte;
    private int datumBestellung;
    private int datumAuslieferung;
    private String zustand;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetKundeIdentifier() {
        return this.kundeIdentifier;
    }

    @Override
    public void SetKundeIdentifier(int kundeIdentifier) {
        this.kundeIdentifier = kundeIdentifier;
    }

    @Override
    public String GetEmpfaengerName() {
        return this.empfaengerName;
    }

    @Override
    public void SetEmpfaengerName(String empfaengerName) {
        this.empfaengerName = empfaengerName;
    }

    @Override
    public String GetEmpfaengerVorname() {
        return this.empfaengerVorname;
    }

    @Override
    public void SetEmpfaengerVorname(String empfaengerVorname) {
        this.empfaengerVorname = empfaengerVorname;
    }

    @Override
    public String GetEmpfaengerAddresse() {
        return this.empfaengerAddresse;
    }

    @Override
    public void SetEmpfaengerAddresse(String empfaengerAddresse) {
        this.empfaengerAddresse = empfaengerAddresse;
    }

    @Override
    public String GetEmpfaengerPostleitzahl() {
        return this.empfaengerPostleitzahl;
    }

    @Override
    public void SetEmpfaengerPostleitzahl(String empfaengerPostleitzahl) {
        this.empfaengerPostleitzahl = empfaengerPostleitzahl;
    }

    @Override
    public String GetEmpfaengerOrt() {
        return this.empfaengerOrt;
    }

    @Override
    public void SetEmpfaengerOrt(String empfaengerOrt) {
        this.empfaengerOrt = empfaengerOrt;
    }

    @Override
    public String GetEmpfaengerZahlungsArt() {
        return this.empfaengerZahlungsArt;
    }

    @Override
    public void SetEmpfaengerZahlungsArt(String empfaengerZahlungsArt) {
        this.empfaengerZahlungsArt = empfaengerZahlungsArt;
    }

    @Override
    public String GetEmpfaengerNummerKreditkarte() {
        return this.empfaengerNummerKreditkarte;
    }

    @Override
    public void SetEmpfaengerNummerKreditkarte(String empfaengerNummerKreditkarte) {
        this.empfaengerNummerKreditkarte = empfaengerNummerKreditkarte;
    }

    @Override
    public String GetEmpfaengerVerfallKreditkarte() {
        return this.empfaengerVerfallKreditkarte;
    }

    @Override
    public void SetEmpfaengerVerfallKreditkarte(String empfaengerVerfallKreditkarte) {
        this.empfaengerVerfallKreditkarte = empfaengerVerfallKreditkarte;
    }

    @Override
    public int GetDatumBestellung() {
        return this.datumBestellung;
    }

    @Override
    public void SetDatumBestellung(int datumBestellung) {
        this.datumBestellung = datumBestellung;
    }

    @Override
    public int GetDatumAuslieferung() {
        return this.datumAuslieferung;
    }

    @Override
    public void SetDatumAuslieferung(int datumAuslieferung) {
        this.datumAuslieferung = datumAuslieferung;
    }

    @Override
    public String GetZustand() {
        return this.zustand;
    }

    @Override
    public void SetZustand(String Zustand) {
        this.zustand = Zustand;
    }
}
