package managed_beans;

import beans.KonfigurationArtikelKontrolleiheit;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorBewaesserungsSpitze extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 12L;
    private static final Logger log = Logger.getLogger(KonfiguratorBewaesserungsSpitze.class.toString());

    public KonfiguratorBewaesserungsSpitze() {
        super.artikel = new KonfigurationArtikelKontrolleiheit();
    }

    public KonfiguratorPumpeneinheit getArtikel() {
        return (KonfiguratorPumpeneinheit)this.artikel;
    }
}
