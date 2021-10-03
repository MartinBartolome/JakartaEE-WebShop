package database.beans;

public class Lagerbestand implements ILagerbestand {
    private int identifier;
    private int lagerIdentifier;
    private int artikelIdentifier;
    private float verfuegbareEinheiten;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getLagerIdentifier() {
        return this.lagerIdentifier;
    }

    @Override
    public void setLagerIdentifier(int lagerIdentifier) {
        this.lagerIdentifier = lagerIdentifier;
    }

    @Override
    public int getArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void setArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier = artikelIdentifier;
    }

    @Override
    public float getVerfuegbareEinheiten() {
        return this.verfuegbareEinheiten;
    }

    @Override
    public void setVerfuegbareEinheiten(float verfuegbareEinheiten) {
        this.verfuegbareEinheiten = verfuegbareEinheiten;
    }
}
