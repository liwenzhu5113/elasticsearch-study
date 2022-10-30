package com.example.elasticsearchstudy.repository;

import com.example.elasticsearchstudy.domain.Hotel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liwenzhu
 */
@Service
public interface HotelRepository extends ElasticsearchRepository<Hotel,String> {
    /**
     * 根据名称查找
     * @return
     */
    List<Hotel> findByName(String name);
}
