package org.example.sample.web.controller;

import org.example.sample.core.service.api.HelloService;
import org.example.sample.web.rest.RestHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demonstrates how a rest service can be built with spring MVC.
 *
 * Note: The only difference between this and the regular controller is the return type of the action method.
 */
@Controller
@RequestMapping(value = "/api")
public class RestController {

    private final HelloService helloService;

    @Autowired
    public RestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{name}")
    @ResponseBody
    public RestHello getByName(@PathVariable String name) {
        final RestHello restHello = new RestHello();
        restHello.setId(helloService.findOrAddByName(name));
        restHello.setName(name);
        return restHello;
    }
}
