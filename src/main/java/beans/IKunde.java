package beans;

public interface IKunde {
    entities.IKunde getKunde();
    void setKunde(entities.IKunde kunde);
    entities.IAdresse getAdresse();
    void setAdresse(entities.IAdresse adresse);
    entities.IZahlungsArt getZahlungsArt();
    void setZahlungsArt(entities.IZahlungsArt zahlungsArt);
}
