package cod.ui.commands;

import cod.CookieOnDemand;
import cod.tcf.Customer;
import cod.tcf.Voucher;
import cod.ui.framework.Command;

import java.util.List;

/**
 * Created by user on 04/01/2016.
 */
public class SetDateHour extends Command<CookieOnDemand> {

    private Customer customer;

    private String dateOfPassage;

    @Override
    public String identifier() { return "set"; }

    @Override
    public void load(List<String> args) {
        customer = system.getCustomers().findByFirstName(args.get(0)).get();
        dateOfPassage = args.get(1);
    }

    @Override
    public void execute() {
        system.getShoppingCart(customer).setDateOfPassage(dateOfPassage);
    }

    @Override
    public String describe() {
        return "Set the date and hour to get your cookies (set CUSTOMER DATE (format yyyy-MM-dd))";
    }
}
