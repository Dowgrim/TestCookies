package cod.ui.commands;

import cod.CookieOnDemand;
import cod.CustomerDatabase;
import cod.ShoppingCart;
import cod.tcf.Customer;
import cod.ui.framework.Command;

import java.util.List;
import java.util.Set;

public class ShowCommands extends Command<CookieOnDemand> {

	@Override
	public String identifier() { return "list"; }

	@Override
	public void execute() {
		Set<Customer> cstmrs = system.getCustomers().getSet();
		for(Customer c : cstmrs){
			ShoppingCart cart = system.getShoppingCart(c);
			System.out.println(c.getFirstName() + " (" + c.getDateofPassage() + ") :");
			if (cart.contents().isEmpty()){
				System.out.println("  Empty cart");
			} else {
				System.out.println("  " + cart.contents());
			}
		}

	}

	@Override
	public String describe() {
		return "Show the list of all commands (list)";
	}
}
