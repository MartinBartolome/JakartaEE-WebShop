package database.beans;

public class Rechnung implements IRechnung {
    private int identifier;
    private int kundeIdentifier;
    private String empfaengerName;
    private String empfaengerVorname;
    private String empfaengerAddresse;
    private String empfaengerPostleitzahl;
    private String empfaengerOrt;
    private int datumRechnung;

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
    public int GetDatumRechnung() {
        return this.datumRechnung;
    }

    @Override
    public void SetDatumRechnung(int datumRechnung) {
        this.datumRechnung = datumRechnung;
    }
}
