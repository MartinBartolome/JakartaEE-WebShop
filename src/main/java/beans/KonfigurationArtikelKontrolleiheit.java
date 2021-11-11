package beans;

import java.util.Map;

public class KonfigurationArtikelKontrolleiheit extends KonfigurationArtikel {
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
    }

    private KonfigurationMerkmale konfigurationMerkmale;

    public KonfigurationArtikelKontrolleiheit() {
        konfigurationMerkmale = new KonfigurationMerkmale(super.merkmaleKonfiguration);
    }

    public KonfigurationMerkmale getKonfigurationMerkmale() {
        return this.konfigurationMerkmale;
    }
}
