package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class Home  extends ManagedBean {
    private static final long serialVersionUID = 11L;
    private static final Logger logger = Logger.getLogger(Anmelden.class.toString());

    public String getPageAnmelden()
    {
        return "anmelden.xhtml";
    }

    public String getPageBenutzerProfilAnlegen()
    {
        return "benutzerprofilAnlegen.xhtml";
    }

    public String getPageBenutzerProfilEditieren()
    {
        return "benutzerprofilEditieren.xhtml";
    }
}
