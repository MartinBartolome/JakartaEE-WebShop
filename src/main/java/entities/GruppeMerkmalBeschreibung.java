package entities;

import jakarta.persistence.*;

@Entity
@Table(name="GruppeMerkmalBeschreibung")
public class GruppeMerkmalBeschreibung implements IGruppeMerkmalBeschreibung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifier = 0;
    private int gruppeMerkmalIdentifier = 0;
    private String beschreibung = "";
    private int sprache = 0;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getGruppeMerkmalIdentifier() {
        return this.gruppeMerkmalIdentifier;
    }

    public void setGruppeMerkmalIdentifier(int gruppeMerkmalIdentifier) {
        this.gruppeMerkmalIdentifier = gruppeMerkmalIdentifier;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getSprache() {
        return this.sprache;
    }

    public void setSprache(int sprache) {
        this.sprache = sprache;
    }
}