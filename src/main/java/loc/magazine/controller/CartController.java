package loc.magazine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cart");

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addtocart(@RequestParam(name = "pid", defaultValue = "0") int pid) {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("redirect:/");
        mav.addObject("productCount", pid);

        return mav;
    }
}
