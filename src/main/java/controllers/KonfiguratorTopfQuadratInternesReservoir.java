package controllers;

import beans.KonfigurationTopfQuadrat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorTopfQuadratInternesReservoir extends KonfiguratorBase {
    public KonfiguratorTopfQuadratInternesReservoir() {
        super.artikel = new KonfigurationTopfQuadrat();
    }

    public KonfigurationTopfQuadrat getArtikel() {
        return (KonfigurationTopfQuadrat)this.artikel;
    }
}
