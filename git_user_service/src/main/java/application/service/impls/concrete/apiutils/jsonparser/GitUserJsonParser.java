package application.service.impls.concrete.apiutils.jsonparser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import application.model.User;
import application.service.impls.concrete.apiutils.jsonparser.mapper.UserMapper;
import com.google.gson.Gson;

public class GitUserJsonParser {

	public List<String> getUserLoginListFromJson(String json) {
		Result x = new Gson().fromJson(json, Result.class);
		return x.items.stream().map(i -> i.login).collect(Collectors.toList());
	}

	public User getUserFromJson(String json) {
		Map res = new Gson().fromJson(json, Map.class);
		return UserMapper.fromMap(res);
	}


	private class Result {
		List<Login> items;

		private class Login {
			String login;
		}
	}

}
