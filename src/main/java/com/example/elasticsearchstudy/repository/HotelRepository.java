package com.example.elasticsearchstudy.repository;

import com.example.elasticsearchstudy.domain.Hotel;

import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

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

    @Highlight(fields = {
            @HighlightField(name = "city"),
            @HighlightField(name = "name")
    })

    List<SearchHit<Hotel>> findByCityAndName(String city,String name);

    List<Hotel> findByNameContains(String name,Pageable pageable);

    /**
     * 全文检索
     * @param descriptiveContent 检索的字段
     * @return
     */
    List<Hotel> findByAll(String descriptiveContent);

    /**
     * 排序
     * @param descriptiveContent 检索的字段
     * @return
     */
    List<Hotel> findByAllOrderByPriceDesc(String descriptiveContent);

    /**
     * 排序
     * @param descriptiveContent 检索的字段
     * @return
     */
    List<Hotel> findByAllOrderByPriceAsc(String descriptiveContent);
}
