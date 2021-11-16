package entities;

import jakarta.persistence.*;

@Entity
@Table(name="Rechnung")
public class Rechnung implements IRechnung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int kundeIdentifier = 0;
    private String empfaengerName = "";
    private String empfaengerVorname = "";
    private String empfaengerAddresse = "";
    private String empfaengerPostleitzahl = "";
    private String empfaengerOrt = "";
    private int datumRechnung = 0;

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
    public int getDatumRechnung() {
        return this.datumRechnung;
    }

    @Override
    public void setDatumRechnung(int datumRechnung) {
        this.datumRechnung = datumRechnung;
    }
}
