package online.mignon.mignonmerchants.goods;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GoodService  {

    GoodsDao goodsDao;
    public GoodService(GoodsDao goodsDao){
     this.goodsDao=goodsDao;

    }
    public  List<Goods> getAllGoods(){
        return goodsDao.findAll();
    }

    public Goods getGood(Long goodId){
        return goodsDao.getGoodById(goodId).orElseThrow(()-> new IDNotFoundException("good not found"));
    }

    public  void addGoods(Goods good){
        goodsDao.save(good);
    }



}
