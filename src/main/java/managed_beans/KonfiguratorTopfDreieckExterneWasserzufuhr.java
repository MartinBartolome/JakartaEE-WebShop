package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfDreieckExterneWasserzufuhr extends ManagedBean {
    private static final long serialVersionUID = 16L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfDreieckExterneWasserzufuhr.class.toString());
}
