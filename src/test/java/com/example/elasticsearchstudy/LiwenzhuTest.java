package com.example.elasticsearchstudy;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.elasticsearchstudy.domain.Hotel;
import com.example.elasticsearchstudy.domain.Phone;
import com.example.elasticsearchstudy.repository.HotelRepository;
import com.example.elasticsearchstudy.service.HotelService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;

import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiwenzhuTest {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 创建文档
     */
    @Test
    public void createDocument() {
        Hotel hotel = new Hotel();
        hotel.setName("京西大酒店");
        hotel.setAddress("xxx路");
        hotel.setPrice(2000);
        hotel.setScore(4.0);
        hotel.setBrand("李文铸牌");
        hotel.setCity("福州");
        hotel.setStarName("四星");
        hotel.setBusiness("福州儿童公园路");
        hotel.setLatitude("30.251433");
        hotel.setLongitude("120.47522");
        hotel.setPic("https://m.tuniucdn.com/filebroker/cdn/res/07/36/073662e1718fccefb7130a9da44ddf5c_w200_h200_c1_t0.jpg");
        hotelRepository.save(hotel);
    }

    /**
     * 删除文档
     */
    @Test
    public void deleteDocument() {
        List<Hotel> hotelList = hotelRepository.findByName("改天我要学做包子");
        hotelRepository.deleteAll(hotelList);
    }

    /**
     * 将数据库的数据备份一份到elasticsearch中
     */
    @Test
    public void dumpDocument(){
        //查出mysql的数据
        List<Hotel> list = hotelService.list();
        //插入一份到elasticsearch中
        hotelRepository.saveAll(list);
    }

    @Test
    public void insertDocument(){
        LambdaQueryWrapper<Hotel> wrapper = new LambdaQueryWrapper<>();
        wrapper.last("limit 1");
        Hotel hotel = hotelService.getOne(wrapper);
        hotel.setId(null);
        hotel.setName("改天我要学做包子");
        hotelService.save(hotel);
        hotelRepository.save(hotel);
    }

    @Test
    public void updateDocument(){
        LambdaQueryWrapper<Hotel> wrapper = new LambdaQueryWrapper<>();
        wrapper.last("limit 1");
        Hotel hotel = hotelService.getOne(wrapper);
        hotel.setName("改天我要开包子铺222");
        hotelRepository.save(hotel);
    }

    /**
     * 高亮显示
     */
    @Test
    public void highLightQuery() {
        List<SearchHit<Hotel>> cityList = hotelRepository.findByCityAndName("上海","7天连锁酒店(上海宝山路地铁站店)");
        System.out.println(cityList);

    }

    /**
     * 模糊查询分页操作
     */
    @Test
    public void likePageQuery() {
        //这个地方正常page和size是参数传进来的,但是因为是Test类,不允许这样的操作,所以在这里备注一下。
        //分页参数
        int page = 1;
        int size = 10;
        List<Hotel> nameList = hotelRepository.findByNameContains("北京",PageRequest.of(page - 1, size));
        System.out.println(nameList);
    }

    /**
     * 全文检索
     */
    @Test
    public void fullTextQuery(){
        List<Hotel> hotelList = hotelRepository.findByAll("北京");
        System.out.println(hotelList);
    }

    /**
     * 排序
     */

    @Test
    public void sortQuery() {
        List<Hotel> hotelList = hotelRepository.findByAllOrderByPriceDesc("北京");
        System.out.println(hotelList);
    }
}
