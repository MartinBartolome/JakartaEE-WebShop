package dataAccessObjects;

import beans.IAnmeldeDaten;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class Kunde extends DataAccessObject implements IKunde {
    @Override
    public int get(IAnmeldeDaten anmeldeDaten) {
        Query query = this.entityManager.createQuery("SELECT k FROM Kunde k WHERE k.eMailAdresse=:eMailAdresse AND k.passwort=:passwort");
        query.setParameter("eMailAdresse", anmeldeDaten.getEmailAdresse());
        query.setParameter("passwort", anmeldeDaten.getPasswort());
        entities.Kunde kunde = (entities.Kunde)query.getSingleResult();
        return kunde.getIdentifier();
    }

    @Override
    public void insert(beans.IKunde kunde) {
        // Epoch seconds now - 01.01.2021 00:00:00
        final long nummer = java.time.Instant.now().getEpochSecond() - 1609459200;
        kunde.getKunde().setNummer(nummer);
        super.persist(kunde.getKunde());

        // Adresse & Zahlungsart
        kunde.getAdresse().setKundeIdentifier(kunde.getKunde().getIdentifier());
        super.persist(kunde.getAdresse());
        kunde.getZahlungsArt().setKundeIdentifier(kunde.getKunde().getIdentifier());
        super.persist(kunde.getZahlungsArt());
    }

    @Override
    public void update(beans.IKunde kunde) {
        super.merge(kunde.getKunde());
        super.merge(kunde.getAdresse());
        super.merge(kunde.getZahlungsArt());
    }

    @Override
    public beans.IKunde get(int kundeIdentifier) {
//        SELECT k.*,a.*,za.* FROM Kunde k INNEr JOIN Adresse a on a.KundeIdentifier=k.Identifier INNER JOIN ZahlungsArt za ON za.KundeIdentifier=k.Identifier
        TypedQuery<Object[]> query = this.entityManager.createQuery("SELECT k,a,za FROM Kunde k INNER JOIN Adresse a on a.identifier=k.identifier INNER JOIN ZahlungsArt za ON za.kundeIdentifier=k.identifier WHERE k.identifier=:Identifier", Object[].class);
        query.setParameter("Identifier", kundeIdentifier);
        beans.IKunde kunde = new beans.Kunde();
        Object[] result = query.getSingleResult();
        kunde.setKunde((entities.Kunde)result[0]);
        kunde.setAdresse((entities.Adresse)result[1]);
        kunde.setZahlungsArt((entities.ZahlungsArt)result[2]);

        return kunde;
        // To do
    }
}
