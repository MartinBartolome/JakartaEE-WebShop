package entities;

import jakarta.persistence.*;

@Entity
@Table(name="ZahlungsArt")
public class ZahlungsArt implements IZahlungsArt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int kundeIdentifier = 0;
    private int zahlungsArt = 0;
    private String nummerKreditkarte = "";
    private String verfallKreditkarte = "";

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
    public int getZahlungsArt() {
        return this.zahlungsArt;
    }

    @Override
    public void setZahlungsArt(int zahlungsArt) {
        this.zahlungsArt = zahlungsArt;
    }

    @Override
    public String getNummerKreditkarte() {
        return this.nummerKreditkarte;
    }

    @Override
    public void setNummerKreditkarte(String nummerKreditkarte) {
        this.nummerKreditkarte = nummerKreditkarte;
    }

    @Override
    public String getVerfallKreditkarte() {
        return this.verfallKreditkarte;
    }

    @Override
    public void setVerfallKreditkarte(String verfallKreditkarte) {
        this.verfallKreditkarte = verfallKreditkarte;
    }
}
