package managed_beans;

import beans.KonfigurationPumpeneinheit;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorPumpeneinheit extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 14L;
    private static final Logger log = Logger.getLogger(KonfiguratorPumpeneinheit.class.toString());

    public KonfiguratorPumpeneinheit() {
        super.artikel = new KonfigurationPumpeneinheit();
    }

    public KonfigurationPumpeneinheit getArtikel() {
        return (KonfigurationPumpeneinheit)this.artikel;
    }
}
