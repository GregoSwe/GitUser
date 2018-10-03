package application.service.impls.concrete;

import application.service.GitUserService;
import application.service.impls.decorators.CacheServiceDecorator;

public class GitUserServiceFactory {

	public GitUserService getApiUserService(boolean withCache) {
		GitUserService service = new ApiGitUserService();
		if (withCache) {
			service = new CacheServiceDecorator(service);
		}
		return service;
	}
}

