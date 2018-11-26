package com.webup.user.es.repositories;

import lombok.Data;

import java.util.Date;

@Data
//@Document(indexName="article", type="content")
public class Article {
    String author,title,content,price,view,tag;
    Date date;
}
