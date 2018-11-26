package com.webup.user.es.service;

import com.webup.user.es.repositories.Content;

import java.util.List;

public interface ContentService {

    Long save(Content content);
    Long modify(Content content);
    Long selectById(Long Id);
    Long deleteById(Long Id);
    List<Content> search(int pageNumber, int pageSize, String searchContent);

}
