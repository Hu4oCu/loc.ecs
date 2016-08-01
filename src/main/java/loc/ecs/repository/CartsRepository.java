package loc.ecs.repository;

import loc.ecs.entity.Carts;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Integer> {
    @Query(value = "SELECT * FROM ecs_cart WHERE user_id=:uid", nativeQuery = true)
    List<Carts> getCartByUid(@Param("uid") int uid);

    @Query(value = "DELETE FROM ecs_cart WHERE user_id=:uid", nativeQuery = true)
    void deleteByUid(@Param("uid") int uid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ecs_cart WHERE user_id=:uid AND product_id=:pid", nativeQuery = true)
    void deleteByPid(@Param("uid") int uid, @Param("pid") int pid);
}
