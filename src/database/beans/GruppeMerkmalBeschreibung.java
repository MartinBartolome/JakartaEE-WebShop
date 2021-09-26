package database.beans;

public class GruppeMerkmalBeschreibung implements IGruppeMerkmalBeschreibung{
    private int identifier;
    private int gruppeMerkmalIdentifier;
    private String text;
    private int sprache;

    public int GetIdentifier() {
        return this.identifier;
    }

    public void SetIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int GetGruppeMerkmalIdentifier() {
        return this.gruppeMerkmalIdentifier;
    }

    public void SetGruppeMerkmalIdentifier(int gruppeMerkmalIdentifier) {
        this.gruppeMerkmalIdentifier = gruppeMerkmalIdentifier;
    }

    public String GetText() {
        return this.text;
    }

    public void SetText(String text) {
        this.text = text;
    }

    public int GetSprache() {
        return this.sprache;
    }

    public void SetSprache(int sprache) {
        this.sprache = sprache;
    }
}