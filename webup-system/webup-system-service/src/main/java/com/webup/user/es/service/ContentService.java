package com.webup.user.es.service;

import com.webup.user.es.repositories.Content;

import java.util.List;

public interface ContentService {

    boolean save(Content content);
    boolean modify(Content content);
    Long selectById(Long Id);
    boolean deleteById(Long Id);
    List<Content> search(int pageNumber, int pageSize, String searchContent);

}
