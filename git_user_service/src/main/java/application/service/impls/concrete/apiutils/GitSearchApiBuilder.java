package application.service.impls.concrete.apiutils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GitSearchApiBuilder {
	private GitApiBuilder builder;
	private Map<String, String> query;

	public GitSearchApiBuilder() {
		this.builder = new GitApiBuilder().search().addParam("users?q=");
		query = new HashMap<>();
	}


	public GitSearchApiBuilder byLanguage(String language) {
		query.put("language", language);
		return this;
	}

	public GitSearchApiBuilder sortedBy(String sort) {
		query.put("sort", sort);
		return this;
	}

	public URL url() throws MalformedURLException {
		builder.addParam(query.entrySet().stream().map(entry -> String.format("%s:%s", entry.getKey(), entry.getValue())).collect(Collectors.joining("+")));

		return builder.request();
	}


}
