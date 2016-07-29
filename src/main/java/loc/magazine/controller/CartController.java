package loc.magazine.controller;

import loc.magazine.entity.Carts;
import loc.magazine.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cart");

        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addtocart(@RequestParam(name = "pid", defaultValue = "0") Integer pid) {
        List<Carts> cart = cartsService.getCart(1);

        Integer product_count = cart.size();

        return product_count.toString();
    }

}
