package database.beans;

public class Gruppe implements IGruppe {
    private int identifier;
    private String kommentar;

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = this.identifier;
    }

    @Override
    public String getKommentar() {
        return this.kommentar;
    }

    @Override
    public void setKommentar(String kommentar) {
        this.kommentar = this.kommentar;
    }
}
