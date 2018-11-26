package com.webup.user.es.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;


@Component
public interface ContentRepository extends ElasticsearchRepository<Content,Long>{

}