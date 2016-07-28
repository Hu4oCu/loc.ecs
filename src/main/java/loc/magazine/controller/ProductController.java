package loc.magazine.controller;

import loc.magazine.entity.Products;
import loc.magazine.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/product/{id}.html", method = RequestMethod.GET)
    public ModelAndView product(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("product");

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
