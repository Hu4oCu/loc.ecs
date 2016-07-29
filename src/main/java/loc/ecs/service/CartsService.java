package loc.ecs.service;

import loc.ecs.entity.Carts;

import java.util.List;

public interface CartsService {
    Carts addtocart(Carts cart);
    List<Carts> getCart(int uid);
    void deleteUid(int uid);
    void deletePid(int uid, int pid);
    /*boolean isUserLoggedIn(int uid);*/
}
