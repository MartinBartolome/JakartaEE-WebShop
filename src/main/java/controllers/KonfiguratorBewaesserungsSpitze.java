package controllers;

import beans.KonfigurationBewaesserungsSpitze;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorBewaesserungsSpitze extends KonfiguratorBase {
    public KonfiguratorBewaesserungsSpitze() {
        super.artikel = new KonfigurationBewaesserungsSpitze();
    }

    public KonfigurationBewaesserungsSpitze getArtikel() {
        return (KonfigurationBewaesserungsSpitze)this.artikel;
    }
}
