package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfKreisExterneWasserzufuhr extends ManagedBean {
    private static final long serialVersionUID = 18L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfKreisExterneWasserzufuhr.class.toString());
}
