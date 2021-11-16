package beans;

public class Kunde implements IKunde {
    private entities.IKunde kunde = null;
    private entities.IAdresse adresse = null;
    private entities.IZahlungsArt zahlungsArt = null;

    public entities.IKunde getKunde() {
        return this.kunde;
    }

    public void setKunde(entities.IKunde kunde) {
        this.kunde = kunde;
    }

    public void setAdresse(entities.IAdresse adresse) {
        this.adresse = adresse;
    }

    public entities.IAdresse getAdresse() {
        return this.adresse;
    }

    public entities.IZahlungsArt getZahlungsArt() {
        return this.zahlungsArt;
    }

    public void setZahlungsArt(final entities.IZahlungsArt zahlungsArt) {
        this.zahlungsArt = zahlungsArt;
    }
}
