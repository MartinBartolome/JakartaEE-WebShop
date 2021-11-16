package entities;

public interface IGruppeMerkmalBeschreibung {
    int getIdentifier();
    void setIdentifier(int identifier);
    int getGruppeMerkmalIdentifier();
	void setGruppeMerkmalIdentifier(int GruppeMerkmalIdentifier);
    String getBeschreibung();
	void setBeschreibung(String beschreibung);
    int getSprache();
	void setSprache(int Sprache);
}
