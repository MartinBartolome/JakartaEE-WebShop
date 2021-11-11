package managed_beans;

import beans.KonfigurationArtikelKontrolleiheit;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@ViewScoped
public class KonfiguratorKontrolleinheit extends KonfiguratorManagedBean {
    private static final long serialVersionUID = 13L;
    private static final Logger log = Logger.getLogger(KonfiguratorKontrolleinheit.class.toString());

    public KonfiguratorKontrolleinheit() {
        super.artikel = new KonfigurationArtikelKontrolleiheit();
    }

    public KonfigurationArtikelKontrolleiheit getArtikel() {
        return (KonfigurationArtikelKontrolleiheit)this.artikel;
    }
}
