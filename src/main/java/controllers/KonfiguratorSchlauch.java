package controllers;

import beans.KonfigurationSchlauch;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorSchlauch extends KonfiguratorBase {
    public KonfiguratorSchlauch() {
        super.artikel = new KonfigurationSchlauch();
    }

    public KonfigurationSchlauch getArtikel() {
        return (KonfigurationSchlauch)this.artikel;
    }
}
