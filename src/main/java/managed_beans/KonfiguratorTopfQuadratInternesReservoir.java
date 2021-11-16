package managed_beans;

import beans.KonfigurationTopfQuadrat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfQuadratInternesReservoir extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 21L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfQuadratInternesReservoir.class.toString());

    public KonfiguratorTopfQuadratInternesReservoir() {
        super.artikel = new KonfigurationTopfQuadrat();
    }

    public KonfigurationTopfQuadrat getArtikel() {
        return (KonfigurationTopfQuadrat)this.artikel;
    }
}
