package gmail.alexdudarkov.document.web;

import java.util.HashMap;
import java.util.Map;

import gmail.alexdudarkov.document.web.command.Command;
import gmail.alexdudarkov.document.web.command.CommandName;
import gmail.alexdudarkov.document.web.command.impl.*;


final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	public CommandProvider() {
		repository.put(CommandName.LOGIN, new LogIn());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.CATALOG_SEARCH, new CatalogSearch());
		repository.put(CommandName.ADMINISTRATION, new Administration());
		repository.put(CommandName.SHOPPING_CART, new ShoppingCart());
		repository.put(CommandName.EXIT, new Exit());
		repository.put(CommandName.ADD_TO_CART, new AddToCart());
		repository.put(CommandName.TO_ORDER, new ToOrder());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			System.out.println(commandName);
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
