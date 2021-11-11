package managed_beans;

import beans.KonfigurationSchlauch;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorSchlauch extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 15L;
    private static final Logger log = Logger.getLogger(KonfiguratorSchlauch.class.toString());

    public KonfiguratorSchlauch() {
        super.artikel = new KonfigurationSchlauch();
    }

    public KonfigurationSchlauch getArtikel() {
        return (KonfigurationSchlauch)this.artikel;
    }
}
