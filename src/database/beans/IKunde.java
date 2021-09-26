package database.beans;

public interface IKunde {
    int GetIdentifier();
	void SetIdentifier(int identifier);
    int GetNummer();
	void SetNummer(int nummer);
    String GetName();
	void SetName(String name);
    String GetVorname();
	void SetVorname(String vorname);
    String GetTelefonNummer();
	void SetTelefonNummer(String telefonNummer);
    String GetEMailAdresse();
	void SetEMailAdresse(String eMailAdresse);
    int GetZustand();
	void SetZustand(int zustand);
    int GetSprache();
	void SetSprache(int sprache);
}
