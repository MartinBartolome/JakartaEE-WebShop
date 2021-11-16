package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class AktivierungsCodeAnfordern extends ManagedBean {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(AktivierungsCodeAnfordern.class.toString());
}
