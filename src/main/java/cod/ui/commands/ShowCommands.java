package cod.ui.commands;

import cod.CookieOnDemand;
import cod.CustomerDatabase;
import cod.ShoppingCart;
import cod.tcf.Customer;
import cod.ui.framework.Command;

import java.text.SimpleDateFormat;
import java.util.*;

public class ShowCommands extends Command<CookieOnDemand> {

	@Override
	public String identifier() { return "list"; }

	@Override
	public void execute() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        TreeMap<String, String> orderMap = new TreeMap<String, String>();
        String buffer = new String();
		Set<Customer> cstmrs = system.getCustomers().getSet();

		for(Customer c : cstmrs){
			ShoppingCart cart = system.getShoppingCart(c);
			buffer += c.getFirstName() + " (" + cart.getDateofPassage() + ") :";
			if (cart.contents().isEmpty()){
				buffer += "  Empty cart";
			} else {
				buffer += "  " + cart.contents();
			}

            orderMap.put(cart.getDateofPassage(), buffer);
		}

        Set<String> s = orderMap.keySet();
        for(String set : s)
        {
            System.out.println(orderMap.get(set));
        }

	}

	@Override
	public String describe() {
		return "Show the list of all commands (list)";
	}

    public boolean nullHour(String hour)
    {
        return (hour == null)? true : false;
    }
}
