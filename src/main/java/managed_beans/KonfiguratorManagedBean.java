package managed_beans;

import beans.KonfigurationArtikel;
import beans.IArtikel;
import beans.IKonfigurationArtikel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Named
@RequestScoped
public class KonfiguratorManagedBean extends ManagedBean {
    protected IKonfigurationArtikel artikel;

    protected beans.IEinkaufswagen getEinkaufswagen() {
        return (beans.IEinkaufswagen)getSessionValue("Einkaufswagen");
    }

    protected KonfiguratorManagedBean() {
        if (null == getSessionValue("Einkaufswagen")) {
            setSessionValue("Einkaufswagen", new beans.Einkaufswagen());
        }
    }

    public void initialize() {
        try {
            leseArtikel();
            leseMerkmaleInformation();
            leseMerkmaleKonfiguration();
            leseMerkmaleKalkulation();
            getEinkaufswagen().artikelHinzufuegen(this.artikel);
        } catch(Exception exObj) {
            FacesContext.getCurrentInstance().addMessage("loginForm:loginName", new FacesMessage("Username Or Password Is Incorrect"));
        }
    }

    private void leseArtikel() {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT a.identifier,a.nummer,gm.wert AS einheit,ab.beschreibung,a.konfigurator FROM Artikel a INNER JOIN GruppeMerkmal gm ON gm.identifier=a.einheit INNER JOIN ArtikelBeschreibung ab ON ab.artikelIdentifier=a.identifier AND ab.sprache=:sprache WHERE a.identifier=:identifier", Object[].class);
        query.setParameter("identifier", getSessionValue("ArtikelIdentifier"));
        query.setParameter("sprache", getSessionValue("Sprache"));
        Object[] result = query.getSingleResult();
        IArtikel artikel = new beans.Artikel();
        artikel.setIdentifier((int)result[0]);
        artikel.setNummer((int)result[1]);
        artikel.setEinheit(result[2].toString());
        artikel.setBeschreibung(result[3].toString());
        artikel.setKonfigurator(result[4].toString());
        this.artikel.setArtikel(artikel);
    }

    private void leseMerkmaleInformation() {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT am.wert,amb.beschreibung FROM ArtikelMerkmal am INNER JOIN ArtikelMerkmalBeschreibung amb ON amb.artikelMerkmalIdentifier=am.identifier AND amb.sprache=:sprache WHERE am.artikelIdentifier=:identifier AND am.schluessel LIKE('I%')", Object[].class);
        query.setParameter("identifier", getSessionValue("ArtikelIdentifier"));
        query.setParameter("sprache", getSessionValue("Sprache"));
        for (Object[] result : query.getResultList()) {
            beans.IArtikelMerkmal item = new beans.ArtikelMerkmal();
            item.setWert(result[0].toString());
            item.setBeschreibung(result[1].toString());
            this.artikel.getMerkmaleInformation().add(item);
        }
    }

    private void leseMerkmaleKonfiguration() {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT am.schluessel,am.wert,amb.beschreibung FROM ArtikelMerkmal am INNER JOIN ArtikelMerkmalBeschreibung amb ON amb.artikelMerkmalIdentifier=am.identifier AND amb.sprache=:sprache WHERE am.artikelIdentifier=:identifier AND am.schluessel LIKE('K%')", Object[].class);
        query.setParameter("identifier", getSessionValue("ArtikelIdentifier"));
        query.setParameter("sprache", getSessionValue("Sprache"));
        for (Object[] result : query.getResultList()) {
            beans.IArtikelMerkmal item = new beans.ArtikelMerkmal();
            item.setWert(result[1].toString());
            item.setBeschreibung(result[2].toString());
            this.artikel.getMerkmaleKonfiguration().getMerkmale().put(result[0].toString(), item);
        }
    }

    private void leseMerkmaleKalkulation() {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT am.schluessel,am.wert,amb.beschreibung FROM ArtikelMerkmal am INNER JOIN ArtikelMerkmalBeschreibung amb ON amb.artikelMerkmalIdentifier=am.identifier AND amb.sprache=:sprache WHERE am.artikelIdentifier=:identifier AND am.schluessel LIKE('P%')", Object[].class);
        query.setParameter("identifier", getSessionValue("ArtikelIdentifier"));
        query.setParameter("sprache", getSessionValue("Sprache"));
        for (Object[] result : query.getResultList()) {
            beans.IArtikelMerkmal item = new beans.ArtikelMerkmal();
            item.setWert(result[1].toString());
            item.setBeschreibung(result[2].toString());
            this.artikel.getMerkmaleKalkulation().getMerkmale().put(result[0].toString(), item);
        }
    }

    public String inEinkaufswagenLegen() {
        IKonfigurationArtikel artikel = getEinkaufswagen().getArtikel(getRequestParameter("ArtikelIdentifier"));
        artikel.setZustand(IKonfigurationArtikel.Zustand.Gueltig);
        return "loadArtikelAuswahl";
    }
}
