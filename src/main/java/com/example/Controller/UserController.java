package com.example.Controller;

import com.example.Entity.User;
import com.example.Form.UserForm;
import com.example.Service.User.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET,value = "/userdetail")
    public ModelAndView getUserDetailPage(@RequestParam(value="id") String id){
        Integer userId = Integer.parseInt(id);
        User user= userService.getbyId(userId);
        System.out.println(user.getFirstname());
        ModelAndView mv = new ModelAndView("userdetail");
        mv.addObject("user",user);
        return mv;
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView getUsers(@RequestParam(value = "firstname", required = false) String firstname,
                                 @RequestParam(value = "lastname", required = false) String lastname) {
        List<User> userList = userService.getByNameSurname(firstname,lastname);
        System.out.println(userList);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("usersList",userList);
        return mv;
    }*/
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView getUsers(@ModelAttribute("user") UserForm user) {
        List<User> userList = userService.getByNameSurname(user.getFirstname(),user.getLastname());
        System.out.println(userList);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("usersList",userList);
        return mv;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ModelAndView findUsers(@ModelAttribute("user") UserForm user) {
        List<User> userList = userService.getByNameSurname(user.getFirstname(),user.getLastname());
        System.out.println(userList);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("usersList",userList);
        return mv;
    }
}
