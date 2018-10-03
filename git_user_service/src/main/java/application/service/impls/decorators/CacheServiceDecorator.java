package application.service.impls.decorators;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import application.model.User;
import application.service.GitUserService;

public class CacheServiceDecorator extends AbstractGitUserDecorator {

	private Map<String, User> cache;

	public CacheServiceDecorator(GitUserService component) {
		super(component);
		cache = new HashMap<>();
	}

	@Override
	public User getByLogin(String login) throws IOException {
		User user = cache.get(login);
		if (user != null) {
			return user;
		}
		user = super.getByLogin(login);
		cache.put(user.username, user);
		return user;
	}
}
