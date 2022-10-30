package com.example.elasticsearchstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.elasticsearchstudy.domain.Hotel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liwenzhu
 */
@Mapper
public interface HotelMapper extends BaseMapper<Hotel> {
}
