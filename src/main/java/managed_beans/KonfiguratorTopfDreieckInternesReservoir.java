package managed_beans;

import beans.KonfigurationTopfDreieck;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfDreieckInternesReservoir extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 17L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfDreieckInternesReservoir.class.toString());

    public KonfiguratorTopfDreieckInternesReservoir() {
        super.artikel = new KonfigurationTopfDreieck();
    }

    public KonfigurationTopfDreieck getArtikel() {
        return (KonfigurationTopfDreieck)this.artikel;
    }
}
