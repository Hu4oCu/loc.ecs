package loc.magazine.service;

import loc.magazine.entity.Carts;

public interface CartsService {
    Carts addtocart(Carts cart);
    Carts getCart(int uid);
    void delete(int uid);
    /*boolean isUserLoggedIn(int uid);*/
}
