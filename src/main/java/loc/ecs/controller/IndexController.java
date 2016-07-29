package loc.ecs.controller;

import loc.ecs.entity.Carts;
import loc.ecs.service.CartsService;
import loc.ecs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        List<Carts> cart = cartsService.getCart(1);

        Integer product_count = cart.size();

        mav.addObject("productCount", product_count);
        mav.addObject("products", productsService.getLast10Rows());

        return mav;
    }
}
