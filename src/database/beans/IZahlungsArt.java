package database.beans;

public interface IZahlungsArt {
    int getIdentifier();
	void setIdentifier(int identifier);
    int getKundeIdentifier();
	void setKundeIdentifier(int kundeIdentifier);
    int getZahlungsArt();
	void setZahlungsArt(int zahlungsArt);
    String getNummerKreditkarte();
	void setNummerKreditkarte(String nummerKreditkarte);
    String getVerfallKreditkarte();
	void setVerfallKreditkarte(String verfallKreditkarte);
}
