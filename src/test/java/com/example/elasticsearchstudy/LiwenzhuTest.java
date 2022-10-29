package com.example.elasticsearchstudy;

import com.example.elasticsearchstudy.domain.Hotel;
import com.example.elasticsearchstudy.repository.HotelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiwenzhuTest {
    @Resource
    private HotelRepository repository;

    @Test
    public void testCreateDoc() {
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
        repository.save(hotel);
    }
}
