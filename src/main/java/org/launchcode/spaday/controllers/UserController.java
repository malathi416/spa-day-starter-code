package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "/user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
//            model.addAttribute(new User());
            return "/user/add";
        }
//        if(user.getPassword().equals(user.getVerifyPassword())){
//            model.addAttribute("name", user.getUsername());
//
//            return "user/index";
//        }
        else {
            model.addAttribute("name", user.getUsername());
            return "/user/index";
        }
        }
//        if (verify != null && verify.equals(user.getPassword())) {
//            model.addAttribute("name", user.getUsername());
//            return "/user/index";
//        } else {
//            model.addAttribute("errorMessage","Password is not matched");
//            model.addAttribute("username",user.getUsername());
//            model.addAttribute("email", user.getEmail());
//            return "/user/add";
//        }
    }

