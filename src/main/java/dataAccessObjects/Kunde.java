package dataAccessObjects;

import beans.IAnmeldeDaten;
import jakarta.persistence.Query;

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
        Query query = this.entityManager.createQuery("SELECT k FROM Kunde k WHERE k.nummer=:nummer");
        query.setParameter("nummer", nummer);
        final int identifier = ((entities.Kunde)query.getSingleResult()).getIdentifier();
        // Adresse & Zahlungsart
        kunde.getAdresse().setKundeIdentifier(identifier);
        super.persist(kunde.getAdresse());
        kunde.getZahlungsArt().setKundeIdentifier(identifier);
        super.persist(kunde.getZahlungsArt());
    }

    @Override
    public void update(beans.IKunde kunde) {
// Todo
    }

    @Override
    public beans.IKunde get(int kundeIdentifier) {


//        SELECT k.*,a.*,za.* FROM Kunde k INNEr JOIN Adresse a on a.KundeIdentifier=k.Identifier INNER JOIN ZahlungsArt za ON za.KundeIdentifier=k.Identifier

        return  null;
        // To do
    }
}
