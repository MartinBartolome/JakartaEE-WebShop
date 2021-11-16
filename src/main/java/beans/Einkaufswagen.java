package beans;

import java.util.*;

public class Einkaufswagen implements IEinkaufswagen {
    private Map<String, IKonfigurationArtikel> artikel;

    public Einkaufswagen() {
        this.artikel = new HashMap<>();
    }

    public List<IKonfigurationArtikel> getArtikel() {
        List<IKonfigurationArtikel> gueltigeArtikel = new ArrayList<>();
        for (IKonfigurationArtikel artikel : this.artikel.values()) {
            if (IKonfigurationArtikel.Zustand.Gueltig == artikel.getZustand()) {
                gueltigeArtikel.add(artikel);
            }
        }
        return gueltigeArtikel;
    }

    public IKonfigurationArtikel getArtikel(String identifier) {
        return this.artikel.get(identifier);
    }

    public void artikelHinzufuegen(IKonfigurationArtikel artikel) {
        this.artikel.put(artikel.getIdentifier(), artikel);
    }

    public void artikelLoeschen(String identifier) {
        this.artikel.remove(identifier);
    }
}
