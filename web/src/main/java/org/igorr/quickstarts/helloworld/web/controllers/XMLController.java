package org.igorr.quickstarts.helloworld.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.igorr.quickstarts.helloworld.web.models.Coffee;

@Controller
@RequestMapping("/coffee")
public class XMLController {

    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody
    Coffee getCoffeeInXML(@PathVariable String name) {
        return new Coffee(name, 100);
    }

}