package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.model.User;
import application.service.GitUserService;
import application.service.impls.concrete.GitUserServiceFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	private GitUserService service;

	public UserController() {
		service = new GitUserServiceFactory().getApiUserService(true);
	}

	@RequestMapping("/")
	public String index() {
		return "please enter a language";
	}

	@RequestMapping("{language}/{page}")
	public List<User> userByLanguagePaged(@PathVariable String language, @PathVariable Integer page) {
		return manageReponse(language, page);
	}

	@RequestMapping("{language}")
	public List<User> userByLanguage(@PathVariable String language) {
		return manageReponse(language, 1);
	}

	private List<User> manageReponse(@PathVariable String language, @PathVariable Integer page) {
		List<User> result = new ArrayList<>();
		try {
			List<String> users = service.getLoginByLanguage(language, page);
			manageUserList(result, users);
		} catch (IOException e) {
			addDummyUser(result, e);
		}

		return result;
	}


	private void manageUserList(List<User> result, List<String> users) {
		for (String s : users) {
			try {
				result.add(service.getByLogin(s));
			} catch (IOException e) {
				addDummyUser(result, e);
				break;
			}
		}
	}

	private void addDummyUser(List<User> result, IOException e) {
		User u = new User();
		u.name = "error";
		u.username = e.getMessage();
		result.add(u);
	}


}
