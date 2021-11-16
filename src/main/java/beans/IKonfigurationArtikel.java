package beans;

public interface IKonfigurationArtikel {
    enum Zustand {
        Ungueltig,
        Gueltig
    }

    IMerkmaleInformation getMerkmaleInformation();
    IMerkmaleKonfiguration getMerkmaleKonfiguration();
    IMerkmaleKalkulation getMerkmaleKalkulation();
    IArtikel getArtikel();
    void setArtikel(IArtikel artikel);
    String getIdentifier();
    void setZustand(Zustand zustand);
    Zustand getZustand();
}
