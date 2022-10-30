package com.example.elasticsearchstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.elasticsearchstudy.domain.Hotel;
import com.example.elasticsearchstudy.mapper.HotelMapper;
import com.example.elasticsearchstudy.service.HotelService;
import org.springframework.stereotype.Service;

/**
 * @author liwenzhu
 */
@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService {
}
