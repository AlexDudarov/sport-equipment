package gmail.alexdudarkov.document.service.impl;


import gmail.alexdudarkov.document.repository.model.User;
import gmail.alexdudarkov.document.service.ServiceAbstract;

public class UserService extends ServiceAbstract<User> {
	public UserService(Class<User> typeParameterClass) {
		super(typeParameterClass);
	}
}
