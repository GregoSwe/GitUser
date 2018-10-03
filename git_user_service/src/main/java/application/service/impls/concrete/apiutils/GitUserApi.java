package application.service.impls.concrete.apiutils;

import java.net.MalformedURLException;
import java.net.URL;

public class GitUserApi {
	private GitApiBuilder builder;

	public GitUserApi() {
		this.builder = new GitApiBuilder().users();
	}

	public URL url(String name) throws MalformedURLException {
		return builder.addParam(name).request();
	}
}

