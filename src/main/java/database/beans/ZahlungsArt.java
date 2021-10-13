package database.beans;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class ZahlungsArt implements  IZahlungsArt {
    private int identifier;
    private int kundeIdentifier;
    private int zahlungsArt;
    private String nummerKreditkarte;
    private String verfallKreditkarte;
    private String selectedItem;
    private List<String> items;

    @PostConstruct
    public void init()
    {
        items = new ArrayList<>();
        selectedItem = "Item 1";
        items.add( selectedItem );
        items.add( "Item 2" );
        items.add( "Item 3" );
    }

    @Override
    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getKundeIdentifier() {
        return this.kundeIdentifier;
    }

    @Override
    public void setKundeIdentifier(int kundeIdentifier) {
        this.kundeIdentifier = kundeIdentifier;
    }

    @Override
    public int getZahlungsArt() {
        return this.zahlungsArt;
    }

    @Override
    public void setZahlungsArt(int zahlungsArt) {
        this.zahlungsArt = zahlungsArt;
    }

    @Override
    public String getNummerKreditkarte() {
        return this.nummerKreditkarte;
    }

    @Override
    public void setNummerKreditkarte(String nummerKreditkarte) {
        this.nummerKreditkarte = nummerKreditkarte;
    }

    @Override
    public String getVerfallKreditkarte() {
        return this.verfallKreditkarte;
    }

    @Override
    public void setVerfallKreditkarte(String verfallKreditkarte) {
        this.verfallKreditkarte = verfallKreditkarte;
    }
}
