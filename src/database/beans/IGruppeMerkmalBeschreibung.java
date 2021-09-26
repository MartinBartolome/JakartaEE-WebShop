package database.beans;

public interface IGruppeMerkmalBeschreibung {
    int GetIdentifier();
	void SetIdentifier(int Identifier);
    int GetGruppeMerkmalIdentifier();
	void SetGruppeMerkmalIdentifier(int GruppeMerkmalIdentifier);
    String GetText();
	void SetText(String Text);
    int GetSprache();
	void SetSprache(int Sprache);
}
