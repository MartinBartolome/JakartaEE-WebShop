package controllers;

import beans.KonfigurationTopfKreis;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorTopfKreisExterneWasserzufuhr extends KonfiguratorBase {
    public KonfiguratorTopfKreisExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfKreis();
    }

    public KonfigurationTopfKreis getArtikel() {
        return (KonfigurationTopfKreis)this.artikel;
    }
}
