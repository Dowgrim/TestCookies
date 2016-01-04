package cod.persoCookies;

import cod.tcf.Cookie;

/**
 * Created by Quentin on 04/01/2016.
 */
public class PersoCookie implements Cookie {

    private Dough dough;

    public PersoCookie(Dough dough) {
        this.dough = dough;
    }

    @Override
    public String describe() {
        return "COOKIE (Dough : " + dough + ")";
    }
}
