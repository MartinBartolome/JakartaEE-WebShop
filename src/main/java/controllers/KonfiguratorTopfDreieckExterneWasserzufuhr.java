package controllers;

import beans.KonfigurationTopfDreieck;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorTopfDreieckExterneWasserzufuhr extends KonfiguratorBase {
    public KonfiguratorTopfDreieckExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfDreieck();
    }

    public KonfigurationTopfDreieck getArtikel() {
        return (KonfigurationTopfDreieck)this.artikel;
    }
}
