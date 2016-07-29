package loc.ecs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/auth")
@Controller
public class AuthController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("signup");

        return mav;
    }

    @RequestMapping(value = "/signin", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView signin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("signin");

        return mav;
    }

}
