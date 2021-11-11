package managed_beans;

import beans.KonfigurationTopfRechteck;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfRechteckExterneWasserzufuhr extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 22L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfRechteckExterneWasserzufuhr.class.toString());

    public KonfiguratorTopfRechteckExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfRechteck();
    }

    public KonfigurationTopfRechteck getArtikel() {
        return (KonfigurationTopfRechteck)this.artikel;
    }
}
