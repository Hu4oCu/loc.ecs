package loc.magazine.repository;

import loc.magazine.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartsRepository extends JpaRepository<Carts, Integer> {
    @Query(value = "SELECT * FROM ecs_carts WHERE user_id= :uid", nativeQuery = true)
    Carts getCartByUid(@Param("uid") int uid);

    @Query(value = "DELETE FROM ecs_carts WHERE user_id= :uid", nativeQuery = true)
    void delete(@Param("uid") int uid);
}
