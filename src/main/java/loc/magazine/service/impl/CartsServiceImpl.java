package loc.magazine.service.impl;

import loc.magazine.entity.Carts;
import loc.magazine.repository.CartsRepository;
import loc.magazine.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsServiceImpl implements CartsService {
    @Autowired
    private CartsRepository cartsRepository;

    @Override
    public Carts addtocart(Carts cart) {
        return cartsRepository.saveAndFlush(cart);
    }

    @Override
    public List<Carts> getCart(int uid) {
        return cartsRepository.getCartByUid(uid);
    }

    @Override
    public void delete(int uid) {
        cartsRepository.delete(uid);
    }
}
