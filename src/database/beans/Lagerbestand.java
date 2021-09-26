package database.beans;

public class Lagerbestand implements ILagerbestand {
    private int identifier;
    private int lagerIdentifier;
    private int artikelIdentifier;
    private float verfuegbareEinheiten;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int GetLagerIdentifier() {
        return this.lagerIdentifier;
    }

    @Override
    public void SetLagerIdentifier(int lagerIdentifier) {
        this.lagerIdentifier = lagerIdentifier;
    }

    @Override
    public int GetArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void SetArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
    }

    @Override
    public float GetVerfuegbareEinheiten() {
        return this.verfuegbareEinheiten;
    }

    @Override
    public void SetVerfuegbareEinheiten(float verfuegbareEinheiten) {
        this.verfuegbareEinheiten = verfuegbareEinheiten;
    }
}
