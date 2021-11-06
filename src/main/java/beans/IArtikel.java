package beans;

public interface IArtikel {
     int getIdentifier();
     void setIdentifier(int identifier);
     int getNummer();
     void setNummer(int nummer);
     String getArtikelArt();
     void setArtikelArt(String artikelArt);
     String getEinheit();
     void setEinheit(String einheit);
     String getBeschreibung();
     void setBeschreibung(String beschreibung);
     String getZustand();
     void setZustand(String zustand);
}
