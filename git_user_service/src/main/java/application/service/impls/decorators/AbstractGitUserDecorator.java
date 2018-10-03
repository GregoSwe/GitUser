package application.service.impls.decorators;

import java.io.IOException;
import java.util.List;

import application.model.User;
import application.service.GitUserService;

abstract class AbstractGitUserDecorator implements GitUserService {

	private GitUserService component;

	AbstractGitUserDecorator(GitUserService component) {
		this.component = component;
	}

	@Override
	public List<String> getLoginByLanguage(String language) throws IOException {
		return component.getLoginByLanguage(language);
	}

	@Override
	public User getByLogin(String login) throws IOException {
		return component.getByLogin(login);
	}


}

