package cod.ui.commands;

import cod.CookieOnDemand;
import cod.ShoppingCart;
import cod.tcf.Cookie;
import cod.tcf.Customer;
import cod.tcf.Item;
import cod.tcf.Recipes;
import cod.ui.framework.Command;

import java.util.List;

public class ValidateUserCommand extends Command<CookieOnDemand> {

	protected Customer customer;

	@Override
	public String identifier() { return "validate"; }

	@Override
	public void load(List<String> args) {
		customer = system.getCustomers().findByFirstName(args.get(0)).get();
	}

	@Override
	public void execute() {
		ShoppingCart cart = system.getShoppingCart(customer);
		if(!cart.dateIsNull())
			cart.validate();
	}

	@Override
	public String describe() {
		return "Validate the Costumer's command (validate CUSTOMER)";
	}
}
