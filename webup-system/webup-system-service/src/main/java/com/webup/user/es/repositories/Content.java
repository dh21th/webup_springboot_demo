package com.webup.user.es.repositories;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName="article", type="content")
public class Content {
    Long id;
    String author,title,content,price,view,tag;
    Date date;
}
