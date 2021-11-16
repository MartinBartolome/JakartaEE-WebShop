package entities;

import jakarta.persistence.*;

@Entity
@Table(name="PreisProEinheit")
public class PreisProEinheit implements IPreisProEinheit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int artikelIdentifier = 0;
    private int gueltigVon = 0;
    private int gueltigBis = 0;
    private float preis = 0.0f;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getArtikelIdentifier() {
        return this.artikelIdentifier;
    }

    @Override
    public void setArtikelIdentifier(int artikelIdentifier) {
        this.artikelIdentifier =  artikelIdentifier;
    }

    @Override
    public int getGueltigVon() {
        return this.gueltigVon;
    }

    @Override
    public void setGueltigVon(int gueltigVon) {
        this.gueltigVon =  gueltigVon;
    }

    @Override
    public int getGueltigBis() {
        return this.gueltigBis;
    }

    @Override
    public void setGueltigBis(int gueltigBis) {
        this.gueltigBis =  gueltigBis;
    }

    @Override
    public float getPreis() {
        return this.preis;
    }

    @Override
    public void setPreis(float preis) {
        this.preis = preis;
    }
}
