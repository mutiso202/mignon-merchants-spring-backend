package online.mignon.mignonmerchants.goods;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Goods {
    String good_name,good_description,good_image_url,good_sku_code;

}
