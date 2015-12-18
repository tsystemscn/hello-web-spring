package com.tsystems.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC hello world.
 */
@Controller
public class HelloController {

    private  static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }

    @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("message") String message) {
        // view: hello.jsp
        String viewName = "hello";
        // model
        ModelMap map = new ModelMap();
        map.put("message", message);
        LOG.info("hello method -> message: " + message);
        return new ModelAndView(viewName, map);
    }
}
