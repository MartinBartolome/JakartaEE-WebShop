package dataAccessObjects;

import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Artikel extends DataAccessObject implements IArtikel {
    @Override
    public List<beans.IArtikel> get(int sprache)  {
        try {
            List<beans.IArtikel> container = new ArrayList<>();
            TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT a.identifier,a.nummer,ab.beschreibung,gm1.wert AS artikelart,gm2.wert AS zustand,gm3.wert AS einheit,a.konfigurator FROM Artikel a INNER JOIN ArtikelBeschreibung ab ON ab.artikelIdentifier = a.identifier AND ab.sprache=:sprache INNER JOIN GruppeMerkmal gm1 ON gm1.identifier=a.artikelArt INNER JOIN GruppeMerkmal gm2 ON gm2.identifier=a.zustand INNER JOIN GruppeMerkmal gm3 ON gm3.identifier=a.einheit", Object[].class);
            query.setParameter("sprache", sprache);
            for (Object[] result : query.getResultList()) {
                beans.Artikel item = new beans.Artikel();
                item.setIdentifier((int)result[0]);
                item.setNummer((int)result[1]);
                item.setBeschreibung(result[2].toString());
                item.setArtikelArt(result[3].toString());
                item.setZustand(result[4].toString());
                item.setEinheit(result[5].toString());
                item.setKonfigurator(result[6].toString());
                container.add(item);
            }
            return container;
        } catch (Exception exception) {
            String text = exception.getMessage();
        }
        return null;
    }

    @Override
    public beans.IArtikel get(int identifier, int sprache) {
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT a.identifier,a.nummer,gm.wert AS einheit,ab.beschreibung,a.konfigurator FROM Artikel a INNER JOIN GruppeMerkmal gm ON gm.identifier=a.einheit INNER JOIN ArtikelBeschreibung ab ON ab.artikelIdentifier=a.identifier AND ab.sprache=:sprache WHERE a.identifier=:identifier", Object[].class);
        query.setParameter("identifier", identifier);
        query.setParameter("sprache", sprache);
        Object[] result = query.getSingleResult();
        beans.IArtikel artikel = new beans.Artikel();
        artikel.setIdentifier((int)result[0]);
        artikel.setNummer((int)result[1]);
        artikel.setEinheit(result[2].toString());
        artikel.setBeschreibung(result[3].toString());
        artikel.setKonfigurator(result[4].toString());
        return artikel;
    }
}
