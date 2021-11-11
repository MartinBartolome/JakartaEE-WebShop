package beans;

public class KonfigurationBewaesserungsSpitze extends KonfigurationArtikel {
    public class KonfigurationMerkmale {
        IMerkmaleKonfiguration merkmale;

        public KonfigurationMerkmale(IMerkmaleKonfiguration merkmale) {
            this.merkmale = merkmale;
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

        public String getBeschreibungStablaenge() {
            return this.merkmale.getMerkmale().get("KL").getBeschreibung();
        }

        public String getStablaenge() {
            return this.merkmale.getMerkmale().get("KL").getWert();
        }

        public void setStablaenge(String wert) {
            this.merkmale.getMerkmale().get("KL").setWert(wert);
        }
    }

    private KonfigurationMerkmale konfigurationMerkmale;

    public KonfigurationBewaesserungsSpitze() {
        konfigurationMerkmale = new KonfigurationMerkmale(super.merkmaleKonfiguration);
    }

    public KonfigurationMerkmale getKonfigurationMerkmale() {
        return this.konfigurationMerkmale;
    }
}
