package database.beans;

public interface IGruppeMerkmal {
    int GetIdentifier();
	void SetIdentifier(int identifier);
    int GetGruppeIdentifier();
	void SetGruppeIdentifier(int gruppeIdentifier);
    String GetSchluessel();
	void SetSchluessel(String schluessel);
    String GetWert();
	void SetWert(String wert);
}
