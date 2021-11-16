package beans;

public class KonfigurationSchlauch extends KonfigurationArtikel {
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

        public String getBeschreibungLaenge() {
            return this.merkmale.getMerkmale().get("KL").getBeschreibung();
        }

        public String getLaenge() {
            return this.merkmale.getMerkmale().get("KL").getWert();
        }

        public void setLaenge(String wert) {
            this.merkmale.getMerkmale().get("KL").setWert(wert);
        }

        public String getBeschreibungInnendurchmesser() {
            return this.merkmale.getMerkmale().get("KDS").getBeschreibung();
        }

        public String getInnendurchmesser() {
            return this.merkmale.getMerkmale().get("KDS").getWert();
        }

        public void setInnendurchmesser(String wert) {
            this.merkmale.getMerkmale().get("KDS").setWert(wert);
        }
    }

    private KonfigurationMerkmale konfigurationMerkmale;

    public KonfigurationSchlauch() {
        konfigurationMerkmale = new KonfigurationMerkmale(super.merkmaleKonfiguration);
    }

    public KonfigurationMerkmale getKonfigurationMerkmale() {
        return this.konfigurationMerkmale;
    }
}
