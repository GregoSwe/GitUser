package application.service.impls.concrete.apiutils.jsonparser;

import java.util.List;

import application.model.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GitUserJsonParserTest {

	@Test
	public void getAllLoginFromJson() {
		List<String> res = new GitUserJsonParser().getUserLoginListFromJson(searchResultFixture);
		System.out.println(res);
		assertThat((long) res.size(), is(4L));
		assertThat(res, hasItems("JakeWharton", "daimajia", "Trinea", "stormzhang"));
	}


	@Test
	public void getUserFromJson() {
		User user = new GitUserJsonParser().getUserFromJson(userFixture);
		User expected = new User();
		expected.url = "main_page_url";
		expected.followers = 12;
		expected.name = "Marco Gre";
		expected.username = "gr3gorini";
		expected.avatar = "nice_avatar";

		assertThat(user.url, is(expected.url));
		assertThat(user.followers, is(expected.followers));
		assertThat(user.name, is(expected.name));
		assertThat(user.username, is(expected.username));
		assertThat(user.avatar, is(expected.avatar));

	}


	private String userFixture =
			"{\n" + "  \"login\": \"gr3gorini\",\n" + "  \"id\": 1063891,\n" + "  \"node_id\": \"\",\n" + "  \"avatar_url\": \"nice_avatar\",\n" + "  \"gravatar_id\": \"\",\n"
					+ "  \"url\": \"url1\",\n" + "  \"html_url\": \"main_page_url\",\n" + "  \"followers_url\": \" \",\n" + "  \"following_url\": \" \",\n"
					+ "  \"repos_url\": \"repo_url\",\n" + "  \"events_url\": \" \",\n" + "  \"received_events_url\": \" \",\n" + "  \"type\": \"User\",\n"
					+ "  \"site_admin\": false,\n" + "  \"name\": \"Marco Gre\",\n" + "  \"company\": \"Hope\",\n" + "  \"blog\": \" \",\n" + "  \"location\": \"Venice\",\n"
					+ "  \"email\": null,\n" + "  \"hireable\": null,\n" + "  \"bio\": \" \",\n" + "  \"public_repos\": 1,\n" + "  \"public_gists\": 2,\n"
					+ "  \"followers\": 12,\n" + "  \"following\": 298,\n" + "  \"created_at\": \"2011-09-20T02:40:45Z\",\n" + "  \"updated_at\": \"2018-08-19T06:37:10Z\"\n" + "}";

	private String searchResultFixture =
			"{\n" + "  \"total_count\": 1848491,\n" + "  \"incomplete_results\": false,\n" + "  \"items\": [\n" + "    {\n" + "      \"login\": \"JakeWharton\",\n"
					+ "      \"id\": 66577,\n" + "      \"node_id\": \"MDQ6VXNlcjY2NTc3\",\n" + "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/66577?v=4\",\n"
					+ "      \"gravatar_id\": \"\",\n" + "      \"url\": \"https://api.github.com/users/JakeWharton\",\n"
					+ "      \"html_url\": \"https://github.com/JakeWharton\",\n" + "      \"followers_url\": \"https://api.github.com/users/JakeWharton/followers\",\n"
					+ "      \"following_url\": \"https://api.github.com/users/JakeWharton/following{/other_user}\",\n"
					+ "      \"gists_url\": \"https://api.github.com/users/JakeWharton/gists{/gist_id}\",\n"
					+ "      \"starred_url\": \"https://api.github.com/users/JakeWharton/starred{/owner}{/repo}\",\n"
					+ "      \"subscriptions_url\": \"https://api.github.com/users/JakeWharton/subscriptions\",\n"
					+ "      \"organizations_url\": \"https://api.github.com/users/JakeWharton/orgs\",\n"
					+ "      \"repos_url\": \"https://api.github.com/users/JakeWharton/repos\",\n"
					+ "      \"events_url\": \"https://api.github.com/users/JakeWharton/events{/privacy}\",\n"
					+ "      \"received_events_url\": \"https://api.github.com/users/JakeWharton/received_events\",\n" + "      \"type\": \"User\",\n"
					+ "      \"site_admin\": false,\n" + "      \"score\": 1.0\n" + "    },\n" + "    {\n" + "      \"login\": \"daimajia\",\n" + "      \"id\": 2503423,\n"
					+ "      \"node_id\": \"MDQ6VXNlcjI1MDM0MjM=\",\n" + "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/2503423?v=4\",\n"
					+ "      \"gravatar_id\": \"\",\n" + "      \"url\": \"https://api.github.com/users/daimajia\",\n" + "      \"html_url\": \"https://github.com/daimajia\",\n"
					+ "      \"followers_url\": \"https://api.github.com/users/daimajia/followers\",\n"
					+ "      \"following_url\": \"https://api.github.com/users/daimajia/following{/other_user}\",\n"
					+ "      \"gists_url\": \"https://api.github.com/users/daimajia/gists{/gist_id}\",\n"
					+ "      \"starred_url\": \"https://api.github.com/users/daimajia/starred{/owner}{/repo}\",\n"
					+ "      \"subscriptions_url\": \"https://api.github.com/users/daimajia/subscriptions\",\n"
					+ "      \"organizations_url\": \"https://api.github.com/users/daimajia/orgs\",\n" + "      \"repos_url\": \"https://api.github.com/users/daimajia/repos\",\n"
					+ "      \"events_url\": \"https://api.github.com/users/daimajia/events{/privacy}\",\n"
					+ "      \"received_events_url\": \"https://api.github.com/users/daimajia/received_events\",\n" + "      \"type\": \"User\",\n"
					+ "      \"site_admin\": false,\n" + "      \"score\": 1.0\n" + "    },\n" + "    {\n" + "      \"login\": \"Trinea\",\n" + "      \"id\": 1169522,\n"
					+ "      \"node_id\": \"MDQ6VXNlcjExNjk1MjI=\",\n" + "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/1169522?v=4\",\n"
					+ "      \"gravatar_id\": \"\",\n" + "      \"url\": \"https://api.github.com/users/Trinea\",\n" + "      \"html_url\": \"https://github.com/Trinea\",\n"
					+ "      \"followers_url\": \"https://api.github.com/users/Trinea/followers\",\n"
					+ "      \"following_url\": \"https://api.github.com/users/Trinea/following{/other_user}\",\n"
					+ "      \"gists_url\": \"https://api.github.com/users/Trinea/gists{/gist_id}\",\n"
					+ "      \"starred_url\": \"https://api.github.com/users/Trinea/starred{/owner}{/repo}\",\n"
					+ "      \"subscriptions_url\": \"https://api.github.com/users/Trinea/subscriptions\",\n"
					+ "      \"organizations_url\": \"https://api.github.com/users/Trinea/orgs\",\n" + "      \"repos_url\": \"https://api.github.com/users/Trinea/repos\",\n"
					+ "      \"events_url\": \"https://api.github.com/users/Trinea/events{/privacy}\",\n"
					+ "      \"received_events_url\": \"https://api.github.com/users/Trinea/received_events\",\n" + "      \"type\": \"User\",\n" + "      \"site_admin\": false,\n"
					+ "      \"score\": 1.0\n" + "    },\n" + "    {\n" + "      \"login\": \"stormzhang\",\n" + "      \"id\": 2267900,\n"
					+ "      \"node_id\": \"MDQ6VXNlcjIyNjc5MDA=\",\n" + "      \"avatar_url\": \"https://avatars3.githubusercontent.com/u/2267900?v=4\",\n"
					+ "      \"gravatar_id\": \"\",\n" + "      \"url\": \"https://api.github.com/users/stormzhang\",\n"
					+ "      \"html_url\": \"https://github.com/stormzhang\",\n" + "      \"followers_url\": \"https://api.github.com/users/stormzhang/followers\",\n"
					+ "      \"following_url\": \"https://api.github.com/users/stormzhang/following{/other_user}\",\n"
					+ "      \"gists_url\": \"https://api.github.com/users/stormzhang/gists{/gist_id}\",\n"
					+ "      \"starred_url\": \"https://api.github.com/users/stormzhang/starred{/owner}{/repo}\",\n"
					+ "      \"subscriptions_url\": \"https://api.github.com/users/stormzhang/subscriptions\",\n"
					+ "      \"organizations_url\": \"https://api.github.com/users/stormzhang/orgs\",\n"
					+ "      \"repos_url\": \"https://api.github.com/users/stormzhang/repos\",\n"
					+ "      \"events_url\": \"https://api.github.com/users/stormzhang/events{/privacy}\",\n"
					+ "      \"received_events_url\": \"https://api.github.com/users/stormzhang/received_events\",\n" + "      \"type\": \"User\",\n"
					+ "      \"site_admin\": false,\n" + "      \"score\": 1.0\n" + "    }]}";


}
