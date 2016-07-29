package loc.magazine.controller;

import loc.magazine.entity.Carts;
import loc.magazine.entity.Products;
import loc.magazine.service.CartsService;
import loc.magazine.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartsService cartsService;

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cart");

        List<Carts> cart = cartsService.getCart(1);
        List<Products> products = cart.stream().map(cartItem -> productsService.getProductsById(cartItem.getPid()))
                .collect(Collectors.toList());

        mav.addObject("cart_items", products);

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
