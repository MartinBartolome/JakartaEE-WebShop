package entities;

import jakarta.persistence.*;

@Entity
@Table(name="GruppeMerkmal")
public class GruppeMerkmal implements IGruppeMerkmal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Identifier")
    private int identifier = 0;
    @Column(name = "GruppeIdentifier")
    private int gruppeIdentifier = 0;
    @Column(name = "Schluessel")
    private String schluessel = "";
    @Column(name = "Wert")
    private String wert = "";

    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getGruppeIdentifier() {
        return this.gruppeIdentifier;
    }

    public void setGruppeIdentifier(int gruppeIdentifier) {
        this.gruppeIdentifier = gruppeIdentifier;
    }

    public String getSchluessel() {
        return this.schluessel;
    }

    public void setSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }

    public String getWert() {
        return this.wert;
    }

    public void setWert(String wert) {
        this.wert = wert;
    }
}