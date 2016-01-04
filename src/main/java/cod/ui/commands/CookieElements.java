package cod.ui.commands;

import cod.CookieOnDemand;
import cod.ProductCatalogue;
import cod.persoCookies.Dough;
import cod.tcf.Cookie;
import cod.ui.framework.Command;

/**
 * Created by Quentin on 04/01/2016.
 */
public class CookieElements extends Command<CookieOnDemand> {
    @Override
    public String identifier() {
        return "ingredients";
    }

    @Override
    public void execute() {
        System.out.println(" Dough :");
        for (Dough dough : Dough.values()) {
            System.out.println("  - " + dough.toString());
        }

    }

    @Override
    public String describe() {
        return "List the different ingredients of a cookie";
    }
}
