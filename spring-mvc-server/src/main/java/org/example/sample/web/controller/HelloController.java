package org.example.sample.web.controller;

import org.example.sample.core.domain.Hello;
import org.example.sample.core.service.api.HelloService;
import org.example.sample.web.model.FormHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller demonstrates how regular HTML requests can be mapped to JSP pages.
 *
 * The controller method is responsible for fetching the DTO from the repository and converting the objects into web
 * forms, note the DTO can be passed directly to the view, but that tightly couples web and data tiers.
 */
@Controller
@RequestMapping(value = "/")
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ModelAndView getById(@PathVariable Long id) {
        final Hello hello = helloService.findById(id);
        final FormHello model;

        if (hello == null) {
            model = new FormHello(0L, "someone");
        } else {
            model = new FormHello(hello);
        }

        return new ModelAndView("hello", "formHello", model);
    }
}
