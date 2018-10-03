package application.service.impls.concrete.apiutils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GitSearchUserApiBuilder {
	private GitApiBuilder builder;
	private Map<String, String> query;
	private Integer page;

	public GitSearchUserApiBuilder() {
		this.builder = new GitApiBuilder().search().addUrl("users?q=");
		query = new HashMap<>();
		page = null;
	}

	public GitSearchUserApiBuilder page(Integer page) {
		this.page = page;
		return this;
	}

	public GitSearchUserApiBuilder byLanguage(String language) {
		query.put("language", language);
		return this;
	}

	public GitSearchUserApiBuilder sortedBy(String sort) {
		query.put("sort", sort);
		return this;
	}

	public URL url() throws MalformedURLException {
		builder.addParam(query.entrySet().stream().map(entry -> String.format("%s:%s", entry.getKey(), entry.getValue())).collect(Collectors.joining("+")));
		if (page != null) {
			builder.addParam(String.format("page=%s", page.toString()));
		}
		return builder.request();
	}


}
