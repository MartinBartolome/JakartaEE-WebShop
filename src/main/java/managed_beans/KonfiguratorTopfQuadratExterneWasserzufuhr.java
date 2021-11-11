package managed_beans;

import beans.KonfigurationTopfQuadrat;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfQuadratExterneWasserzufuhr extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 20L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfQuadratExterneWasserzufuhr.class.toString());

    public KonfiguratorTopfQuadratExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfQuadrat();
    }

    public KonfigurationTopfQuadrat getArtikel() {
        return (KonfigurationTopfQuadrat)this.artikel;
    }
}
