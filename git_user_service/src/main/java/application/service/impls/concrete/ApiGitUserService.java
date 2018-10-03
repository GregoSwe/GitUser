package application.service.impls.concrete;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import application.model.User;
import application.service.GitUserService;
import application.service.impls.concrete.apiutils.GitSearchApiBuilder;
import application.service.impls.concrete.apiutils.GitUserApi;
import application.service.impls.concrete.apiutils.connection.UrlResolver;
import application.service.impls.concrete.apiutils.jsonparser.GitUserJsonParser;

class ApiGitUserService implements GitUserService {


	@Override
	public List<String> getLoginByLanguage(String language) throws IOException {
		URL request = new GitSearchApiBuilder().byLanguage(language).sortedBy("followers").url();
		String content = UrlResolver.getContent(request);
		return new GitUserJsonParser().getUserLoginListFromJson(content);
	}

	@Override
	public User getByLogin(String login) throws IOException {
		URL request = new GitUserApi().url(login);
		String content = UrlResolver.getContent(request);
		return new GitUserJsonParser().getUserFromJson(content);
	}
}
