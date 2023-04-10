package online.mignon.mignonmerchants.goods;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Builder
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Goods {
    String good_name,good_description,good_image_url,good_sku_code,good_type;

    @Id
    @SequenceGenerator(
            name = "good_sequence",
            sequenceName = "good_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "good_sequence"
    )
    long id;
    int goods_in_stock;

}
