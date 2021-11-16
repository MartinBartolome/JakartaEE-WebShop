package beans;

public class KonfigurationPumpeneinheit extends KonfigurationArtikel {
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

        public String getBeschreibungInnendurchmesserSchlauch() {
            return this.merkmale.getMerkmale().get("KDS").getBeschreibung();
        }

        public String getInnendurchmesserSchlauch() {
            return this.merkmale.getMerkmale().get("KDS").getWert();
        }

        public void setInnendurchmesserSchlauch(String wert) {
            this.merkmale.getMerkmale().get("KDS").setWert(wert);
        }

        public String getBeschreibungFoerdermenge() {
            return this.merkmale.getMerkmale().get("KFM").getBeschreibung();
        }

        public String getFoerdermenge() {
            return this.merkmale.getMerkmale().get("KFM").getWert();
        }

        public void setFoerdermenge(String wert) {
            this.merkmale.getMerkmale().get("KFM").setWert(wert);
        }
    }

    private KonfigurationMerkmale konfigurationMerkmale;

    public KonfigurationPumpeneinheit() {
        konfigurationMerkmale = new KonfigurationMerkmale(super.merkmaleKonfiguration);
    }

    public KonfigurationMerkmale getKonfigurationMerkmale() {
        return this.konfigurationMerkmale;
    }
}
