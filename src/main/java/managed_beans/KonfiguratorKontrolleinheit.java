package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorKontrolleinheit extends ManagedBean {
    private static final long serialVersionUID = 13L;
    private static final Logger log = Logger.getLogger(KonfiguratorKontrolleinheit.class.toString());
}
