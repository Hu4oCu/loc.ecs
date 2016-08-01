package loc.ecs.controller;

import loc.ecs.entity.Carts;
import loc.ecs.service.CartsService;
import loc.ecs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartsService cartsService;

    @SessionScope
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<Carts> cart = cartsService.getCart(1);

        Integer product_count;
        if (cart.isEmpty())
            product_count = null;
        else
            product_count = cart.size();

        model.addAttribute("productCount", product_count);
        model.addAttribute("products", productsService.getLast10Rows());

        return "index";
    }
}
