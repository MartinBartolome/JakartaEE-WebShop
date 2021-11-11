package managed_beans;

import beans.KonfigurationTopfKreis;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfKreisExterneWasserzufuhr extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 18L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfKreisExterneWasserzufuhr.class.toString());

    public KonfiguratorTopfKreisExterneWasserzufuhr() {
        super.artikel = new KonfigurationTopfKreis();
    }

    public KonfigurationTopfKreis getArtikel() {
        return (KonfigurationTopfKreis)this.artikel;
    }
}
