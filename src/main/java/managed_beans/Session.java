package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class Session implements Serializable, ISession {
    private int benutzerIdentifier = -1;

    public void setBenutzerIdentifier(int benutzerIdentifier) {
        this.benutzerIdentifier = benutzerIdentifier;
    }

    public int getBenutzerIdentifier() {
        return this.benutzerIdentifier;
    }
}
