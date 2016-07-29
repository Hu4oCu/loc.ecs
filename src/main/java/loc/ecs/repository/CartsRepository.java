package loc.ecs.repository;

import loc.ecs.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartsRepository extends JpaRepository<Carts, Integer> {
    @Query(value = "SELECT * FROM ecs_cart WHERE user_id= :uid", nativeQuery = true)
    List<Carts> getCartByUid(@Param("uid") int uid);

    @Query(value = "DELETE FROM ecs_cart WHERE user_id= :uid", nativeQuery = true)
    void deleteByUid(@Param("uid") int uid);

    @Query(value = "DELETE FROM ecs_cart WHERE user_id= :uid AND product_id= :pid", nativeQuery = true)
    void deleteByPid(@Param("uid") int uid, @Param("pid") int pid);

}
