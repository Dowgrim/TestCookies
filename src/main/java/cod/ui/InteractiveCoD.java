package cod.ui;

import cod.CookieOnDemand;
import cod.impl.VolatileCoD;
import cod.ui.commands.*;
import cod.ui.framework.Shell;

public class InteractiveCoD extends Shell<CookieOnDemand> {

	public InteractiveCoD() {

		// Instantiating the CookieOnDemand system
		this.system  = new VolatileCoD();
		this.invite  = "CoD";

		// Registering the command available for the user
		register(
				Bye.class,
				ListPreMadeCookies.class,
				CreateCustomer.class,
				OrderCookie.class,
				ShowCart.class,
				RemoveCookie.class,
				ProcessCart.class
		);

	}

}
