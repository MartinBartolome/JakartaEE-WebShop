package beans;

public class KonfigurationTopfDreieck extends KonfigurationArtikel {
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

        public String getBeschreibungBohrungSeite() {
            return this.merkmale.getMerkmale().get("KBS").getBeschreibung();
        }

        public String getBohrungSeite() {
            return this.merkmale.getMerkmale().get("KBS").getWert();
        }

        public void setBohrungSeite(String wert) {
            this.merkmale.getMerkmale().get("KBS").setWert(wert);
        }

        public String getBeschreibungBohrungPositionX() {
            return this.merkmale.getMerkmale().get("KBX").getBeschreibung();
        }

        public String getBohrungPositionX() {
            return this.merkmale.getMerkmale().get("KBX").getWert();
        }

        public void setBohrungPositionX(String wert) {
            this.merkmale.getMerkmale().get("KBX").setWert(wert);
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

        public String getBeschreibungSeiteA() {
            return this.merkmale.getMerkmale().get("KSA").getBeschreibung();
        }

        public String getLaengeSeiteA() {
            return this.merkmale.getMerkmale().get("KSA").getWert();
        }

        public void setLaengeSeiteA(String wert) {
            this.merkmale.getMerkmale().get("KSA").setWert(wert);
        }

        public String getBeschreibungSeiteC() {
            return this.merkmale.getMerkmale().get("KSC").getBeschreibung();
        }

        public String getLaengeSeiteC() {
            return this.merkmale.getMerkmale().get("KSC").getWert();
        }

        public void setLaengeSeiteC(String wert) {
            this.merkmale.getMerkmale().get("KSC").setWert(wert);
        }

        public String getBeschreibungSeiteB() {
            return this.merkmale.getMerkmale().get("KSB").getBeschreibung();
        }

        public String getLaengeSeiteB() {
            return this.merkmale.getMerkmale().get("KSB").getWert();
        }

        public void setLaengeSeiteB(String wert) {
            this.merkmale.getMerkmale().get("KSB").setWert(wert);
        }
    }

    private KonfigurationMerkmale konfigurationMerkmale;

    public KonfigurationTopfDreieck() {
        konfigurationMerkmale = new KonfigurationMerkmale(super.merkmaleKonfiguration);
    }

    public KonfigurationMerkmale getKonfigurationMerkmale() {
        return this.konfigurationMerkmale;
    }
}
