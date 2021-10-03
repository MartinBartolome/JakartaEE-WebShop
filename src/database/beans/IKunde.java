package database.beans;

public interface IKunde {
    int getIdentifier();
	void setIdentifier(int identifier);
    int getNummer();
	void setNummer(int nummer);
    String getName();
	void setName(String name);
    String getVorname();
	void setVorname(String vorname);
    String getTelefonNummer();
	void setTelefonNummer(String telefonNummer);
    String getEMailAdresse();
	void setEMailAdresse(String eMailAdresse);
    int getZustand();
	void setZustand(int zustand);
    int getSprache();
	void setSprache(int sprache);
}
