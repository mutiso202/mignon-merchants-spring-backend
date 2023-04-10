package online.mignon.mignonmerchants.goods;


import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;



@Repository
public interface GoodsDao extends JpaRepository<Goods, Long> {


    @Query("SELECT g FROM Goods g  WHERE g.id = :id")
      Optional<Goods> getGoodById(@Param("id") Long id);
}
