package managed_beans;

import beans.Artikel;
import beans.IKonfigurationArtikel;
import beans.KonfigurationArtikel;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@ViewScoped
public class Einkaufswagen  extends ManagedBean {
    private static final long serialVersionUID = 10L;
    private static final Logger log = Logger.getLogger(Einkaufswagen.class.toString());

    public beans.IEinkaufswagen getEinkaufswagen() {
        return (beans.IEinkaufswagen)getSessionValue("Einkaufswagen");
    }

    public void initialize() {
        // Testdata
        beans.IEinkaufswagen einkaufswagen = new beans.Einkaufswagen();
        setSessionValue("Einkaufswagen", einkaufswagen);
        for (int counter = 1; counter < 10; counter++) {
            IKonfigurationArtikel artikel = new KonfigurationArtikel();
            beans.IArtikel item = new Artikel();
            item.setNummer(counter);
            item.setKonfigurator("KonfiguratorKontrolleinheit");
            item.setBeschreibung("Test Artikel" + counter);
            artikel.setArtikel(item);
            artikel.setZustand(IKonfigurationArtikel.Zustand.Gueltig);
            einkaufswagen.artikelHinzufuegen(artikel);
        }
    }

    public String artikelLoeschen() {
        getEinkaufswagen().artikelLoeschen(getRequestParameter("ArtikelIdentifier"));
        return "loadEinkaufswagen";
    }

    public String artikelEditieren() {
        beans.IArtikel artikel = getEinkaufswagen().getArtikel(getRequestParameter("ArtikelIdentifier")).getArtikel();
        setSessionValue("ArtikelIdentifier", artikel.getIdentifier());
        return "load" + artikel.getKonfigurator();
    }
}
