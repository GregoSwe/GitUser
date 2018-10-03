package application.service.impls.concrete.apiutils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class GitApiBuilder {
	private StringBuffer url;
	private List<String> params;

	GitApiBuilder() {
		url = new StringBuffer();
		params = new ArrayList();
		url.append("https://api.github.com/");
	}

	GitApiBuilder users() {
		url.append("users/");
		return this;
	}

	GitApiBuilder search() {
		url.append("search/");
		return this;
	}

	GitApiBuilder addUrl(String part) {
		url.append(part);
		return this;
	}

	GitApiBuilder addParam(String param) {
		params.add(param);
		return this;
	}

	URL request() throws MalformedURLException {
		return new URL(url.append(params.stream().collect(Collectors.joining("&"))).toString());
	}

}

