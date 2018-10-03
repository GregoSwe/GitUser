package application.service.impls.decorators;


import java.io.IOException;
import java.util.List;

import application.model.User;
import application.service.GitUserService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class CacheServiceDecoratorTest {

	private GitUserService service;
	private MockedService mc;

	@Before
	public void setup() {
		mc = new MockedService();
		service = new CacheServiceDecorator(mc);
	}

	@Test
	public void cacheProperly() throws IOException {
		User u = service.getByLogin("doesn't matter");
		User u1 = service.getByLogin("doesn't matter");
		assertThat(mc.count, is(1));
		assertThat(u, is(u1));

		User u2 = service.getByLogin("just another one");
		assertThat(mc.count, is(2));
		assertThat(u, not(is(u2)));

	}


	public class MockedService implements GitUserService {
		int count = 0;

		@Override
		public List<String> getLoginByLanguage(String language) {
			return null;
		}

		@Override
		public User getByLogin(String login) {
			count++;
			User u = new User();
			u.username = login;
			return u;
		}
	}


}
