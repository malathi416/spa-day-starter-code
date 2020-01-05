package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (verify != null && verify.equals(user.getPassword())) {
            model.addAttribute("name", user.getUsername());
            return "/user/index";
        } else {
            model.addAttribute("errorMessage","Password is not matched");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/add";
        }
    }

}