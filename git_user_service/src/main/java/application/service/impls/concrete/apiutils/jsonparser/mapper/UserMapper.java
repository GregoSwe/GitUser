package application.service.impls.concrete.apiutils.jsonparser.mapper;

import java.util.Map;

import application.model.User;

public class UserMapper {

	public static User fromMap(Map map) {
		User user = new User();
		user.username = (String) map.get("login");
		user.name = (String) map.get("name");
		user.avatar = (String) map.get("avatar_url");
		user.followers = (double) map.get("followers");
		user.url = (String) map.get("html_url");
		return user;
	}

}
