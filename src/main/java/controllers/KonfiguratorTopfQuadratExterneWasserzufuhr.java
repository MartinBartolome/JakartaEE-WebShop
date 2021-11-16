package controllers;

import beans.KonfigurationTopfQuadrat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorTopfQuadratExterneWasserzufuhr extends KonfiguratorBase {
    public KonfiguratorTopfQuadratExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfQuadrat();
    }

    public KonfigurationTopfQuadrat getArtikel() {
        return (KonfigurationTopfQuadrat)this.artikel;
    }
}
