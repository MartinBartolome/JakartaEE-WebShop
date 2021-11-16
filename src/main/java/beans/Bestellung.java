package beans;

import java.util.HashMap;
import java.util.Map;

public class Bestellung {
    public class Kalkulation {
        private Map<String, IMerkmal> merkmale = null;

        public void setMerkmale(Map<String, IMerkmal> merkmale) {
            this.merkmale = merkmale;
        }

        public Map<String, IMerkmal> getMerkmale() {
            return this.merkmale;
        }

        public String getBeschreibungVersandkosten() {
            return this.merkmale.get("VK").getBeschreibung();
        }

        public float getVersandkosten() {
            return Float.parseFloat(this.merkmale.get("VK").getWert());
        }

        public void setVersandkosten(float versandkosten) {
            this.merkmale.get("VK").setWert(Float.toString(versandkosten));
        }

        public String getBeschreibungSteuern() {
            return this.merkmale.get("ST").getBeschreibung();
        }

        public float getSteuern() {
            return Float.parseFloat(this.merkmale.get("ST").getWert());
        }

        public void setSteuern(float steuern) {
            this.merkmale.get("ST").setWert(Float.toString(steuern));
        }

        public String getBeschreibungBetrag() {
            return this.merkmale.get("BT").getBeschreibung();
        }

        public float getBetrag() {
            return Float.parseFloat(this.merkmale.get("BT").getWert());
        }

        public void setBetrag(float betrag) {
            this.merkmale.get("BT").setWert(Float.toString(betrag));
        }
    }

    private IEinkaufswagen einkaufswagen = null;
    private Kalkulation kalkulation = null;
    private IKunde kunde = null;

    public Bestellung() {
        this.kalkulation = new Kalkulation();
    }

    public void setEinkaufswagen(IEinkaufswagen einkaufswagen) {
        this.einkaufswagen = einkaufswagen;
    }

    public void setKunde(IKunde kunde) {
        this.kunde = kunde;
    }

    public IEinkaufswagen getEinkaufswagen() {
        return this.einkaufswagen;
    }

    public IKunde getKunde() {
        return this.kunde;
    }

    public Kalkulation getKalkulation() {
            return this.kalkulation;
    }
}
