package database.beans;

public class PreisProEinheit implements IPreisProEinheit {
    private int identifier;
    private int artikelIdentifier;
    private int gueltigVon;
    private int gueltigBis;
    private float preis;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier =  identifier;
    }

    @Override
    public int GetArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void SetArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier =  artikelIdentifier;
    }

    @Override
    public int GetGueltigVon() {
        return this.gueltigVon;
    }

    @Override
    public void SetGueltigVon(int gueltigVon) {
        this.gueltigVon =  gueltigVon;
    }

    @Override
    public int GetGueltigBis() {
        return this.gueltigBis;
    }

    @Override
    public void SetGueltigBis(int gueltigBis) {
        this.gueltigBis =  gueltigBis;
    }

    @Override
    public float GetPreis() {
        return this.preis;
    }

    @Override
    public void SetPreis(float preis) {
        this.preis = preis;
    }
}
