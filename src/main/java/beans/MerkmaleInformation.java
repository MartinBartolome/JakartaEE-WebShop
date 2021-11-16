package beans;

import java.util.List;

public class MerkmaleInformation implements IMerkmaleInformation {
    private List<IMerkmal> merkmale = null;

    public void setMerkmale(List<IMerkmal> merkmale) {
        this.merkmale = merkmale;
    }

    public List<IMerkmal> getMerkmale() {
        return this.merkmale;
    }
}
