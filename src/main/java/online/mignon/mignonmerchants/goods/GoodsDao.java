package online.mignon.mignonmerchants.goods;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;


@Component
public abstract class GoodsDao implements JpaRepository<Goods, Long> {


    public Optional<Goods> getGoodById(Long id) {
        return findById(id);
    }
}
