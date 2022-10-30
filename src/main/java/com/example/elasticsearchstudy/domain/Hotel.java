package com.example.elasticsearchstudy.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @author liwenzhu
 */
@Component
@Data
@Document(indexName = "hotel")
@TableName("tb_hotel")
public class Hotel implements Serializable {

    /** 酒店id*/
    @Id
    private String id;

    /** 酒店名称*/
    @Field(type = FieldType.Keyword)
    private String name;

    /** 酒店地址 */
    @Field(type = FieldType.Keyword)
    private String address;

    /** 酒店价格 */
    @Field(type = FieldType.Double)
    private Integer price;

    /** 酒店评分 */
    @Field(type = FieldType.Double)
    private Double score;

    /** 酒店品牌 */
    @Field(type = FieldType.Keyword)
    private String brand;

    /** 所在城市 */
    @Field(type = FieldType.Keyword)
    private String city;

    /** 酒店星级 酒店星级，1星到5星，1钻到5钻 */
    @Field(type = FieldType.Keyword)
    private String starName;

    /** 商圈 */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String business;

    /** 纬度 */
    @Field(type = FieldType.Keyword)
    private String latitude;

    /** 经度 */
    @Field(type = FieldType.Keyword)
    private String longitude;

    /** 酒店图片 */
    @Field(type = FieldType.Keyword)
    private String pic;
}
