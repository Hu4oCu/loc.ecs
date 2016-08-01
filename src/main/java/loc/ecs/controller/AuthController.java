package loc.ecs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@Controller
public class AuthController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {


        return "signup";
    }

    @RequestMapping(value = "/signin", method = {RequestMethod.GET, RequestMethod.POST})
    public String signin(Model model, HttpSession httpSession) {

        return "signin";
    }

}
