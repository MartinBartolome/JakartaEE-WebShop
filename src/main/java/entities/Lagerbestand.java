package entities;

import jakarta.persistence.*;

@Entity
@Table(name="Lagerbestand")
public class Lagerbestand implements ILagerbestand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int lagerIdentifier = 0;
    private int artikelIdentifier = 0;
    private float verfuegbareEinheiten = 0.0f;

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
