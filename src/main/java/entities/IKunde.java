package entities;

public interface IKunde {
    int getIdentifier();
    void setIdentifier(int identifier);
    long getNummer();
	void setNummer(long nummer);
    String getName();
	void setName(String name);
    String getVorname();
	void setVorname(String vorname);
    String getTelefonNummer();
	void setTelefonNummer(String telefonNummer);
    String getEMailAdresse();
	void setEMailAdresse(String eMailAdresse);
    String getPasswort();
    void setPasswort(String passwort);
    int getZustand();
	void setZustand(int zustand);
    int getSprache();
	void setSprache(int sprache);
}
