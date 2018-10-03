package application.service.impls.concrete.apiutils;

import java.net.MalformedURLException;
import java.net.URL;

class GitApiBuilder {
	private StringBuffer request;

	GitApiBuilder() {
		request = new StringBuffer();
		request.append("https://api.github.com/");
	}

	GitApiBuilder users() {
		request.append("users/");
		return this;
	}

	GitApiBuilder search() {
		request.append("search/");
		return this;
	}

	GitApiBuilder addParam(String param) {
		request.append(param);
		return this;
	}

	URL request() throws MalformedURLException {
		return new URL(request.toString());
	}

}

