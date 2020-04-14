package com.example.demo.nosql.elasticsearch.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 搜索中的商品信息
 */
@Getter
@Setter
@Document(indexName = "pms", type = "product", shards = 1, replicas = 0)
public class EsProduct implements Serializable {

    private static final long serialVersionUID = 1520873443486626602L;
    @Id
    private Long id;
//    @Field(type = FieldType.Long)
    private Long brandId;
    @Field(type = FieldType.Keyword)
    private String brandName;
    private Long productCategoryId;
    @Field(type = FieldType.Keyword)
    private String productCategoryName;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;
    private String pic;
    private Integer newStatus;
    private Integer recommandStatus;
    private Integer sale;
    private BigDecimal price;
    @Field(type = FieldType.Keyword)
    private String productSn;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String subTitle;
    private Integer stock;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String keywords;
    private Integer promotionType;
    private Integer sort;
    @Field(type = FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;

}
