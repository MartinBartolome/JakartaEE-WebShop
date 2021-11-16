package beans;

public class AnmeldeDaten implements  IAnmeldeDaten {
    private String eMailAdresse;
    private String passwort;

    @Override
    public String getEmailAdresse() {
        return this.eMailAdresse;
    }

    @Override
    public void setEmailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    @Override
    public String getPasswort() {
        return this.passwort;
    }

    @Override
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
