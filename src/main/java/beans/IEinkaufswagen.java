package beans;

import java.util.List;

public interface IEinkaufswagen {
    List<IKonfigurationArtikel> getArtikel();
    IKonfigurationArtikel getArtikel(String identifier);
    void artikelHinzufuegen(IKonfigurationArtikel artikel);
    void artikelLoeschen(String identifier);
}
