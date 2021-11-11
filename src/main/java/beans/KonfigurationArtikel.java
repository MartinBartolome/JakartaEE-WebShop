package beans;

import java.util.*;

public class KonfigurationArtikel implements IKonfigurationArtikel {
    private String identifier = "";
    private List<IArtikelMerkmal> merkmaleInformation;
    private IArtikel artikel;
    private Zustand zustand = Zustand.Ungueltig;
    private IMerkmaleKalkulation merkmaleKalkulation;
    protected IMerkmaleKonfiguration merkmaleKonfiguration;

    public KonfigurationArtikel() {
        this.identifier = UUID.randomUUID().toString();
        this.merkmaleInformation = new ArrayList<>();
        this.merkmaleKalkulation = new MerkmaleKalkulation();
        this.merkmaleKonfiguration = new MerkmaleKonfiguration();
    }

    public List<IArtikelMerkmal> getMerkmaleInformation() {
        return this.merkmaleInformation;
    }

    public IMerkmaleKonfiguration getMerkmaleKonfiguration() {
        return this.merkmaleKonfiguration;
    }

    public IMerkmaleKalkulation getMerkmaleKalkulation() {
        return this.merkmaleKalkulation;
    }

    public IArtikel getArtikel() {
        return this.artikel;
    }

    public void setArtikel(IArtikel artikel) {
        this.artikel = artikel;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public Zustand getZustand() {
        return this.zustand;
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
