package controllers;

import beans.KonfigurationPumpeneinheit;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KonfiguratorPumpeneinheit extends KonfiguratorBase {
    public KonfiguratorPumpeneinheit() {
        super.artikel = new KonfigurationPumpeneinheit();
    }

    public KonfigurationPumpeneinheit getArtikel() {
        return (KonfigurationPumpeneinheit)this.artikel;
    }
}
