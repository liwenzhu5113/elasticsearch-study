package com.example.elasticsearchstudy.domain;

import lombok.Data;

/**
 * @author liwenzhu
 */
@Data
public class Phone {
    /** id */
    private Long id;

    /** 品牌*/
    private String brand;

    /** 电池容量 */
    private String capacity;

    /** 屏幕类型 */
    private Integer screenType;

    /** 手机大小 */
    private Double size;

}
