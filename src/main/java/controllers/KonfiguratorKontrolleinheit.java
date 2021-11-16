package controllers;

import beans.KonfigurationArtikelKontrolleiheit;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorKontrolleinheit extends KonfiguratorBase {
    public KonfiguratorKontrolleinheit() {
        super.artikel = new KonfigurationArtikelKontrolleiheit();
    }

    public KonfigurationArtikelKontrolleiheit getArtikel() {
        return (KonfigurationArtikelKontrolleiheit)this.artikel;
    }
}
