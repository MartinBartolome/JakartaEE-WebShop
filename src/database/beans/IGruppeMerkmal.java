package database.beans;

public interface IGruppeMerkmal {
    int getIdentifier();
	void setIdentifier(int identifier);
    int getGruppeIdentifier();
	void setGruppeIdentifier(int gruppeIdentifier);
    String getSchluessel();
	void setSchluessel(String schluessel);
    String getWert();
	void setWert(String wert);
}
