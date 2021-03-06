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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String cart(Model model) {
        List<Carts> cart = cartsService.getCart(1);
        List<Products> products = cart.stream().map(cartItem ->
                productsService.getProductsById(cartItem.getPid()))
                .collect(Collectors.toList());

        Integer product_count;
        if (cart.isEmpty())
            product_count = null;
        else
            product_count = cart.size();

        model.addAttribute("productCount", product_count);
        model.addAttribute("cart_items", products);

        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addtocart(@RequestParam(name = "pid") Integer pid) {
        List<Carts> cart = cartsService.getCart(1);

        Carts newItem = new Carts(1, pid, 1);

        cartsService.addtocart(newItem);
        cart.add(newItem);

        Integer product_count = cart.size();

        return product_count.toString();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ResponseBody
    public String removefromcart(@RequestParam(name = "uid") Integer uid, @RequestParam(name = "pid") Integer pid) {
        cartsService.deletePid(1, pid);

        Integer product_count = cartsService.getCart(1).size();

        return product_count.toString();
    }

}
