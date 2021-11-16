package dataAccessObjects;

import beans.IMerkmal;
import beans.Merkmal;
import entities.GruppeMerkmal;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merkmale extends DataAccessObject implements IMerkmale {
    public List<GruppeMerkmal> getSprachen() {
        Query query = this.entityManager.createQuery("SELECT g FROM GruppeMerkmal g WHERE g.gruppeIdentifier=2");
        return query.getResultList();
    }

    public Map<String, IMerkmal> getMerkmaleFuerKonfiguration(int artikelIdentifier, int sprache)
    {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT am.schluessel,am.wert,amb.beschreibung FROM ArtikelMerkmal am INNER JOIN ArtikelMerkmalBeschreibung amb ON amb.artikelMerkmalIdentifier=am.identifier AND amb.sprache=:sprache WHERE am.artikelIdentifier=:identifier AND am.schluessel LIKE('K%')", Object[].class);
        query.setParameter("identifier", artikelIdentifier);
        query.setParameter("sprache", sprache);
        Map<String, IMerkmal> container = new HashMap<>();
        for (Object[] result : query.getResultList()) {
            IMerkmal item = new Merkmal();
            item.setWert(result[1].toString());
            item.setBeschreibung(result[2].toString());
            container.put(result[0].toString(), item);
        }
        return container;
    }

    public Map<String, IMerkmal> getMerkmaleFuerKalkulation(int artikelIdentifier, int sprache)
    {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT am.schluessel,am.wert,amb.beschreibung FROM ArtikelMerkmal am INNER JOIN ArtikelMerkmalBeschreibung amb ON amb.artikelMerkmalIdentifier=am.identifier AND amb.sprache=:sprache WHERE am.artikelIdentifier=:identifier AND am.schluessel LIKE('P%')", Object[].class);
        query.setParameter("identifier", artikelIdentifier);
        query.setParameter("sprache", sprache);
        Map<String, IMerkmal> container = new HashMap<>();
        for (Object[] result : query.getResultList()) {
            IMerkmal item = new Merkmal();
            item.setWert(result[1].toString());
            item.setBeschreibung(result[2].toString());
            container.put(result[0].toString(), item);
        }
        return container;
    }

    public List<IMerkmal> getMerkmaleFuerInformation(int artikelIdentifier, int sprache)
    {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT am.wert,amb.beschreibung FROM ArtikelMerkmal am INNER JOIN ArtikelMerkmalBeschreibung amb ON amb.artikelMerkmalIdentifier=am.identifier AND amb.sprache=:sprache WHERE am.artikelIdentifier=:identifier AND am.schluessel LIKE('I%')", Object[].class);
        query.setParameter("identifier", artikelIdentifier);
        query.setParameter("sprache", sprache);
        List<IMerkmal> container = new ArrayList<>();
        for (Object[] result : query.getResultList()) {
            IMerkmal item = new Merkmal();
            item.setWert(result[0].toString());
            item.setBeschreibung(result[1].toString());
            container.add(item);
        }
        return container;
    }

    public Map<String, IMerkmal> getMerkmaleFuerKalkulation(int sprache) {
        TypedQuery<Object[]> query = this.entityManager.createQuery("Select gm.schluessel,gmb.beschreibung FROM GruppeMerkmal gm INNER JOIN GruppeMerkmalBeschreibung gmb ON gmb.gruppeMerkmalIdentifier=gm.identifier AND gmb.sprache=:sprache WHERE gm.gruppeIdentifier=6", Object[].class);
        query.setParameter("sprache", sprache);
        Map<String, IMerkmal> container = new HashMap<>();
        for (Object[] result : query.getResultList()) {
            IMerkmal item = new Merkmal();
            item.setWert("0.00");
            item.setBeschreibung(result[1].toString());
            container.put(result[0].toString(), item);
        }
        return container;
    }
}
