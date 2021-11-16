package managed_beans;

import beans.KonfigurationTopfKreis;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfKreisInternesReservoir extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 19L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfKreisInternesReservoir.class.toString());

    public KonfiguratorTopfKreisInternesReservoir() {
        super.artikel = new KonfigurationTopfKreis();
    }

    public KonfigurationTopfKreis getArtikel() {
        return (KonfigurationTopfKreis)this.artikel;
    }
}
