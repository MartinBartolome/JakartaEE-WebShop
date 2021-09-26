package database.beans;

public class ZahlungsArt implements  IZahlungsArt {
    private int identifier;
    private int kundeIdentifier;
    private int zahlungsArt;
    private String nummerKreditkarte;
    private String verfallKreditkarte;

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
    public int GetZahlungsArt() {
        return this.zahlungsArt;
    }

    @Override
    public void SetZahlungsArt(int zahlungsArt) {
        this.zahlungsArt = zahlungsArt;
    }

    @Override
    public String GetNummerKreditkarte() {
        return this.nummerKreditkarte;
    }

    @Override
    public void SetNummerKreditkarte(String nummerKreditkarte) {
        this.nummerKreditkarte = nummerKreditkarte;
    }

    @Override
    public String GetVerfallKreditkarte() {
        return this.verfallKreditkarte;
    }

    @Override
    public void SetVerfallKreditkarte(String verfallKreditkarte) {
        this.verfallKreditkarte = verfallKreditkarte;
    }
}
