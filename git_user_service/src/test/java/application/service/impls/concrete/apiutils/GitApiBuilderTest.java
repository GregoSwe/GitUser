package application.service.impls.concrete.apiutils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GitApiBuilderTest {


	@Test
	public void rightUserRequest() throws MalformedURLException {

		URL url = new GitUserApi().url("random_name");
		assertThat(getActual(url), is("https://api.github.com/users/random_name"));

	}

	@Test
	public void rightResearchRequestWithLanguage() throws IOException {

		URL url = new GitSearchUserApiBuilder().byLanguage("Java").url();
		assertThat(getActual(url), is("https://api.github.com/search/users?q=language:Java"));

	}

	@Test
	public void rightResearchRequestWithSort() throws MalformedURLException {

		URL url = new GitSearchUserApiBuilder().sortedBy("random_thing").url();
		assertThat(getActual(url), is("https://api.github.com/search/users?q=sort:random_thing"));

	}

	@Test
	public void rightResearchRequestWithSortAndLanguage() throws MalformedURLException {

		URL request = new GitSearchUserApiBuilder().byLanguage("nice_language").sortedBy("random_thing").url();
		assertThat(getActual(request), is("https://api.github.com/search/users?q=language:nice_language+sort:random_thing"));

	}

	@Test
	public void rightResearchRequestWithSortAndLanguagePaged() throws MalformedURLException {

		URL request = new GitSearchUserApiBuilder().byLanguage("nice_language").sortedBy("random_thing").page(2).url();
		assertThat(getActual(request), is("https://api.github.com/search/users?q=language:nice_language+sort:random_thing&page=2"));

	}

	private String getActual(URL request) {
		return request.toString();
	}


}
