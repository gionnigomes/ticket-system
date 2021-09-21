package br.com.ticket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class SwaggerController {
	@RequestMapping(value = "/docs", method = RequestMethod.GET)
    public ModelAndView redirectDoc() {
		return new ModelAndView("redirect:swagger-ui.html");
    }

}
