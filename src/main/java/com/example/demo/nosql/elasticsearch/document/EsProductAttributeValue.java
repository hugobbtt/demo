package com.example.demo.nosql.elasticsearch.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Getter
@Setter
public class EsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = -6281230072279327406L;
    private Long id;
    private Long productAttributeId;
    //属性值
    @Field(type = FieldType.Keyword)
    private String value;
    // 属性参数： 0->规格；1->参数
    private Integer type;
    //属性名称
    @Field(type = FieldType.Keyword)
    private String name;

}
