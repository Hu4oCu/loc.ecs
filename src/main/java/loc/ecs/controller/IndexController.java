package loc.ecs.controller;

import loc.ecs.entity.Carts;
import loc.ecs.entity.Products;
import loc.ecs.service.CartsService;
import loc.ecs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Products> products = productsService.getLast10Rows();

        Map<Integer, Boolean> bought = new HashMap<>();

        if (!cart.isEmpty()) {
            for (Carts carts_items : cart) {
                for (Products products_id : products) {
                    if (carts_items.getPid() == products_id.getPid()) {
                        bought.put(products_id.getPid(), true);
                    } else {
                        if (bought.containsKey(products_id.getPid())) {
                            continue;
                        } else {
                            bought.put(products_id.getPid(), false);
                        }
                    }
                }
            }
        }
        else {
            for (Products products_id : products) {
                bought.put(products_id.getPid(), false);
            }
        }

        Integer product_count;
        if (cart.isEmpty())
            product_count = null;
        else
            product_count = cart.size();

        model.addAttribute("productCount", product_count);
        model.addAttribute("products", products);
        model.addAttribute("bought", bought);

        return "index";
    }
}
