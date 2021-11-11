package managed_beans;

import beans.Artikel;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@ViewScoped
public class ArtikelAuswahl extends ManagedBean {
    private static final long serialVersionUID = 4L;
    private static final Logger log = Logger.getLogger(ArtikelAuswahl.class.toString());
    private List<beans.IArtikel> artikel;

    public void initialize() {
        suchen();
    }

    public String getPageAbmelden() {
        return "";
    }

    public String getPageEinkaufswagen() {
        return "einkaufswagen.xhtml";
    }

    public List<beans.IArtikel> getArtikel() {
        return this.artikel;
    }

    public void suchen() {
        try {
            setSessionValue("ArtikelIdentifier", 0);
            this.artikel = new ArrayList<>();
            // Add filtering....
            // TODO
            TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT a.identifier,a.nummer,ab.beschreibung,gm1.wert AS artikelart,gm2.wert AS zustand,gm3.wert AS einheit,a.konfigurator FROM Artikel a INNER JOIN ArtikelBeschreibung ab ON ab.artikelIdentifier = a.identifier AND ab.sprache=:sprache INNER JOIN GruppeMerkmal gm1 ON gm1.identifier=a.artikelArt INNER JOIN GruppeMerkmal gm2 ON gm2.identifier=a.zustand INNER JOIN GruppeMerkmal gm3 ON gm3.identifier=a.einheit", Object[].class);
            query.setParameter("sprache", (int) getSessionValue("Sprache"));
            // Add filtering....
            // TODO
            for (Object[] result : query.getResultList()) {
                Artikel item = new Artikel();
                item.setIdentifier((int)result[0]);
                item.setNummer((int)result[1]);
                item.setBeschreibung(result[2].toString());
                item.setArtikelArt(result[3].toString());
                item.setZustand(result[4].toString());
                item.setEinheit(result[5].toString());
                item.setKonfigurator(result[6].toString());
                this.artikel.add(item);
            }
        } catch (Exception exception) {
            String text = exception.getMessage();
        }
    }

    public String artikelInKonfiguratorLaden() {
        setSessionValue("ArtikelIdentifier", Integer.parseInt(getRequestParameter("ArtikelIdentifier")));
        return "load" + getRequestParameter("ArtikelKonfigurator");
    }
}
