package cod.impl;

import cod.ShoppingCart;
import cod.tcf.Item;

import java.util.*;

public class VolatileShoppingCart implements ShoppingCart {

	private Set<Item> items = new HashSet<>();
	private boolean valide = false;

    private String dateOfPassage;

	@Override
	public void add(Item i) {
		// handling the case where the same cookie is already on the shopping cart
		Optional<Item> existing = items.stream().filter(e -> e.getCookie().equals(i.getCookie())).findFirst();
		if(existing.isPresent()) {
			items.remove(existing.get());
			Item toAdd = new Item(i.getCookie(), i.getQuantity() + existing.get().getQuantity());
			if(toAdd.getQuantity() > 0) { items.add(toAdd); }
		} else {
			items.add(i);
		}
	}

    public void setDateOfPassage(String s)
    {
        this.dateOfPassage = s;
    }

    public String getDateofPassage()
    {
        return dateOfPassage;
    }

	@Override
	public void validate(){
		valide = true;
	}

	@Override
	public void remove(Item i) { add(new Item(i.getCookie(), -i.getQuantity())); }

	@Override
	public boolean contains(Item i) { return items.contains(i); }

	@Override
	public int size() { return items.size(); }

	@Override
	public List<Item> contents() {
		List<Item> result = new LinkedList<>();
		result.addAll(items);
		return result;
	}

    public boolean dateIsNull()
    {
        return(dateOfPassage == null)? true : false;
    }

}
