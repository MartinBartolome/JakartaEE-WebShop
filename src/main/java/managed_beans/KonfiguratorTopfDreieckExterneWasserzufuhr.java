package managed_beans;

import beans.KonfigurationTopfDreieck;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfDreieckExterneWasserzufuhr extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 16L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfDreieckExterneWasserzufuhr.class.toString());

    public KonfiguratorTopfDreieckExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfDreieck();
    }

    public KonfigurationTopfDreieck getArtikel() {
        return (KonfigurationTopfDreieck)this.artikel;
    }
}
