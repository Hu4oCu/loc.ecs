package loc.ecs.service.impl;

import loc.ecs.entity.Carts;
import loc.ecs.repository.CartsRepository;
import loc.ecs.service.CartsService;
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
    public void deleteUid(int uid) {
        cartsRepository.deleteByUid(uid);
    }

    @Override
    public void deletePid(int uid,int pid) {
        cartsRepository.deleteByPid(uid, pid);
        cartsRepository.flush();
    }

}
