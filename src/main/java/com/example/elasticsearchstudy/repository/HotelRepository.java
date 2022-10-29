package com.example.elasticsearchstudy.repository;

import com.example.elasticsearchstudy.domain.Hotel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

/**
 * @author liwenzhu
 */
@Service
public interface HotelRepository extends ElasticsearchRepository<Hotel,String> {
}
