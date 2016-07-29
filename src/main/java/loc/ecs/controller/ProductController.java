package loc.ecs.controller;

import loc.ecs.entity.Carts;
import loc.ecs.entity.Products;
import loc.ecs.service.CartsService;
import loc.ecs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartsService cartsService;

    @RequestMapping(value = "/product/{id}.html", method = RequestMethod.GET)
    public ModelAndView product(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product");

        List<Carts> cart = cartsService.getCart(1);

        Integer product_count = cart.size();

        mav.addObject("productCount", product_count);

        Products product = productsService.getProductsById(id);
        if (product.getName().contentEquals("Not Found")) {
            mav.setViewName("error/404");
        }
        else {
            mav.addObject("product", product);
        }

        return mav;
    }

    @RequestMapping(value = {"/product", "/product/"}, method = RequestMethod.GET)
    public String defaultMethod() {
        return "error/500";
    }

}
