package beans;

import java.util.List;

public interface IKonfigurationArtikel {
    enum Zustand {
        Ungueltig,
        Gueltig
    }

    List<IArtikelMerkmal> getMerkmaleInformation();
    IMerkmaleKonfiguration getMerkmaleKonfiguration();
    IMerkmaleKalkulation getMerkmaleKalkulation();
    IArtikel getArtikel();
    void setArtikel(IArtikel artikel);
    String getIdentifier();
    void setZustand(Zustand zustand);
    Zustand getZustand();
}
