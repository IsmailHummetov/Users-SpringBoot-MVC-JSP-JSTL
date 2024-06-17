package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET,value = "/")
        public ModelAndView showHelloJsp(@RequestParam(value = "name",defaultValue = "World",
            required = true)String firstname){
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name",firstname);
        return mv;
    }
}
