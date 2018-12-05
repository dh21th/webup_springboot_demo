package com.webup.user.es.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(indexName="article", type="content")
//@Document(indexName="projectname",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
//        String indexName();//索引库的名称，个人建议以项目的名称命名
//        String type() default "";//类型，个人建议以实体的名称命名
//        short shards() default 5;//默认分区数
//        short replicas() default 1;//每个分区默认的备份数
//        String refreshInterval() default "1s";//刷新间隔
//        String indexStoreType() default "fs";//索引文件存储类型

public class Content implements Serializable {
    @Id
    @Field(type=FieldType.Long)
    Long id;
    @Field(type=FieldType.Text)
    String author;
    @Field(type=FieldType.Text)
    String title;
    @Field(type=FieldType.Text)
    String content;
    @Field(type=FieldType.Text)
    String price;
    @Field(type=FieldType.Text)
    String view;
    @Field(type=FieldType.Text)
    String tag;
    @Field(type=FieldType.Date)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    Date date;
}
