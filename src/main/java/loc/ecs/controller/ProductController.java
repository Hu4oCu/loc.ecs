package loc.ecs.controller;

import loc.ecs.entity.Carts;
import loc.ecs.entity.Products;
import loc.ecs.service.CartsService;
import loc.ecs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = "/product/{id}.html", method = RequestMethod.GET)
    public String product(Model model, @PathVariable("id") int id) {
        List<Carts> cart = cartsService.getCart(1);

        Integer product_count;
        if (cart.isEmpty())
            product_count = null;
        else
            product_count = cart.size();

        model.addAttribute("productCount", product_count);

        Products product = productsService.getProductsById(id);
        if (product.getName().contentEquals("Not Found"))
            return "error/404";
        else
            model.addAttribute("product", product);

        return "product";
    }

    @RequestMapping(value = {"/product", "/product/"}, method = RequestMethod.GET)
    public String defaultMethod() {
        return "error/500";
    }

}
