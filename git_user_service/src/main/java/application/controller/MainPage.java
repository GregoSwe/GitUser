package application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainPage {

	@RequestMapping("/")
	public String index() {
		return "Hello, please your url should be /user/{language}. This will return the first 100 results. If you need the others, go with /user/{language}/{number of page}";
	}
}
