package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorPumpeneinheit extends ManagedBean {
    private static final long serialVersionUID = 14L;
    private static final Logger log = Logger.getLogger(KonfiguratorPumpeneinheit.class.toString());
}
