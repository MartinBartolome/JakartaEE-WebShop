package database.beans;

public interface IZahlungsArt {
    int GetIdentifier();
	void SetIdentifier(int identifier);
    int GetKundeIdentifier();
	void SetKundeIdentifier(int kundeIdentifier);
    int GetZahlungsArt();
	void SetZahlungsArt(int zahlungsArt);
    String GetNummerKreditkarte();
	void SetNummerKreditkarte(String nummerKreditkarte);
    String GetVerfallKreditkarte();
	void SetVerfallKreditkarte(String verfallKreditkarte);
}
