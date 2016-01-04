package cod.persoCookies;

/**
 * Created by Quentin on 04/01/2016.
 */
public enum Dough {

    PLAIN("Plain"),
    CHOCOLATE("Chocolate");

    private String name;

    Dough(String value) { this.name = value; }

    public String describe() { return name; }

}
