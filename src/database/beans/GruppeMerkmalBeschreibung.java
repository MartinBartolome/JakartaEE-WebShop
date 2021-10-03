package database.beans;

public class GruppeMerkmalBeschreibung implements IGruppeMerkmalBeschreibung{
    private int identifier;
    private int gruppeMerkmalIdentifier;
    private String text;
    private int sprache;

    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getGruppeMerkmalIdentifier() {
        return this.gruppeMerkmalIdentifier;
    }

    public void setGruppeMerkmalIdentifier(int gruppeMerkmalIdentifier) {
        this.gruppeMerkmalIdentifier = gruppeMerkmalIdentifier;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSprache() {
        return this.sprache;
    }

    public void setSprache(int sprache) {
        this.sprache = sprache;
    }
}