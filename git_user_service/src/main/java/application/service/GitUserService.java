package application.service;

import java.io.IOException;
import java.util.List;

import application.model.User;

public interface GitUserService {

	List<String> getLoginByLanguage(String language) throws IOException;

	User getByLogin(String login) throws IOException;


}
