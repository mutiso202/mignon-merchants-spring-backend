package online.mignon.mignonmerchants.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap1/v1/goods")
public class GoodController {

    private final  GoodService service;

    @Autowired
    public GoodController(GoodService service) {
        this.service = service;
    }
    @Autowired

    @GetMapping("/")
    public ResponseEntity<List<Goods>> getAllGoods(){
        return ResponseEntity.ok(service.getAllGoods());
    }


}
