package managed_beans;

import beans.KonfigurationTopfRechteck;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfRechteckInternesReservoir extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 23L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfRechteckInternesReservoir.class.toString());

    public KonfiguratorTopfRechteckInternesReservoir() {
        super.artikel = new KonfigurationTopfRechteck();
    }

    public KonfigurationTopfRechteck getArtikel() {
        return (KonfigurationTopfRechteck)this.artikel;
    }
}
