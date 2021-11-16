package beans;

public class KonfigurationTopfKreis extends KonfigurationArtikel {
    public class KonfigurationMerkmale {
        IMerkmaleKonfiguration merkmale;

        public KonfigurationMerkmale(IMerkmaleKonfiguration merkmale) {
            this.merkmale = merkmale;
        }

        public String getBeschreibungFarbe() {
            return this.merkmale.getMerkmale().get("KFarbe").getBeschreibung();
        }

        public String getFarbe() {
            return this.merkmale.getMerkmale().get("KFarbe").getWert();
        }

        public void setFarbe(String wert) {
            this.merkmale.getMerkmale().get("KFarbe").setWert(wert);
        }

        public String getBeschreibungHoehe() {
            return this.merkmale.getMerkmale().get("KH").getBeschreibung();
        }

        public String getHoehe() {
            return this.merkmale.getMerkmale().get("KH").getWert();
        }

        public void setHoehe(String wert) {
            this.merkmale.getMerkmale().get("KH").setWert(wert);
        }

        public String getBeschreibungBohrungPositionY() {
            return this.merkmale.getMerkmale().get("KBY").getBeschreibung();
        }

        public String getBohrungPositionY() {
            return this.merkmale.getMerkmale().get("KBY").getWert();
        }

        public void setBohrungPositionY(String wert) {
            this.merkmale.getMerkmale().get("KBY").setWert(wert);
        }

        public String getBeschreibungDurchmesser() {
            return this.merkmale.getMerkmale().get("KDS").getBeschreibung();
        }

        public String getDurchmesser() {
            return this.merkmale.getMerkmale().get("KDS").getWert();
        }

        public void setDurchmesser(String wert) {
            this.merkmale.getMerkmale().get("KDS").setWert(wert);
        }
    }

    private KonfigurationMerkmale konfigurationMerkmale;

    public KonfigurationTopfKreis() {
        konfigurationMerkmale = new KonfigurationMerkmale(super.merkmaleKonfiguration);
    }

    public KonfigurationMerkmale getKonfigurationMerkmale() {
        return this.konfigurationMerkmale;
    }
}
