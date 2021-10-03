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
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getKundeIdentifier() {
        return this.kundeIdentifier;
    }

    @Override
    public void setKundeIdentifier(int kundeIdentifier) {
        this.kundeIdentifier = kundeIdentifier;
    }

    @Override
    public String getEmpfaengerName() {
        return this.empfaengerName;
    }

    @Override
    public void setEmpfaengerName(String empfaengerName) {
        this.empfaengerName = empfaengerName;
    }

    @Override
    public String getEmpfaengerVorname() {
        return this.empfaengerVorname;
    }

    @Override
    public void setEmpfaengerVorname(String empfaengerVorname) {
        this.empfaengerVorname = empfaengerVorname;
    }

    @Override
    public String getEmpfaengerAddresse() {
        return this.empfaengerAddresse;
    }

    @Override
    public void setEmpfaengerAddresse(String empfaengerAddresse) {
        this.empfaengerAddresse = empfaengerAddresse;
    }

    @Override
    public String getEmpfaengerPostleitzahl() {
        return this.empfaengerPostleitzahl;
    }

    @Override
    public void setEmpfaengerPostleitzahl(String empfaengerPostleitzahl) {
        this.empfaengerPostleitzahl = empfaengerPostleitzahl;
    }

    @Override
    public String getEmpfaengerOrt() {
        return this.empfaengerOrt;
    }

    @Override
    public void setEmpfaengerOrt(String empfaengerOrt) {
        this.empfaengerOrt = empfaengerOrt;
    }

    @Override
    public String getEmpfaengerZahlungsArt() {
        return this.empfaengerZahlungsArt;
    }

    @Override
    public void setEmpfaengerZahlungsArt(String empfaengerZahlungsArt) {
        this.empfaengerZahlungsArt = empfaengerZahlungsArt;
    }

    @Override
    public String getEmpfaengerNummerKreditkarte() {
        return this.empfaengerNummerKreditkarte;
    }

    @Override
    public void setEmpfaengerNummerKreditkarte(String empfaengerNummerKreditkarte) {
        this.empfaengerNummerKreditkarte = empfaengerNummerKreditkarte;
    }

    @Override
    public String getEmpfaengerVerfallKreditkarte() {
        return this.empfaengerVerfallKreditkarte;
    }

    @Override
    public void setEmpfaengerVerfallKreditkarte(String empfaengerVerfallKreditkarte) {
        this.empfaengerVerfallKreditkarte = empfaengerVerfallKreditkarte;
    }

    @Override
    public int getDatumBestellung() {
        return this.datumBestellung;
    }

    @Override
    public void setDatumBestellung(int datumBestellung) {
        this.datumBestellung = datumBestellung;
    }

    @Override
    public int getDatumAuslieferung() {
        return this.datumAuslieferung;
    }

    @Override
    public void setDatumAuslieferung(int datumAuslieferung) {
        this.datumAuslieferung = datumAuslieferung;
    }

    @Override
    public String getZustand() {
        return this.zustand;
    }

    @Override
    public void setZustand(String Zustand) {
        this.zustand = Zustand;
    }
}
