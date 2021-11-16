package controllers;

import beans.KonfigurationTopfRechteck;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorTopfRechteckExterneWasserzufuhr extends KonfiguratorBase {
    public KonfiguratorTopfRechteckExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfRechteck();
    }

    public KonfigurationTopfRechteck getArtikel() {
        return (KonfigurationTopfRechteck)this.artikel;
    }
}
