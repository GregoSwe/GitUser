package application.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

	@RequestMapping("{language}")
	public List<User> userWithNumber(@PathVariable String language) throws IOException {

		return service.getLoginByLanguage(language).stream().map(login -> {
			try {
				return service.getByLogin(login);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}).collect(Collectors.toList());


	}


}
