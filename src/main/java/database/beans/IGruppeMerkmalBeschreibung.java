package database.beans;

public interface IGruppeMerkmalBeschreibung {
    int getIdentifier();
	void setIdentifier(int Identifier);
    int getGruppeMerkmalIdentifier();
	void setGruppeMerkmalIdentifier(int GruppeMerkmalIdentifier);
    String getText();
	void setText(String Text);
    int getSprache();
	void setSprache(int Sprache);
}
