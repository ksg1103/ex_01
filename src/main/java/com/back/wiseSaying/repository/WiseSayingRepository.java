package com.back.wiseSaying.repository;

import com.back.wiseSaying.dto.PageDto;
import com.back.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }



    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public WiseSaying findByIdOrNull(int id) { //여기서 optional로 반환을 한다면?

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public PageDto findListDesc(int page, int pageSize) {
        int totalCount = wiseSayings.size();

        List<WiseSaying> content = wiseSayings
                .reversed()
                .stream()
                .skip(pageSize*(page-1))
                .limit(pageSize)
                .toList()
                ;
        return new PageDto(page,pageSize,totalCount,content);
    }
    public PageDto findByContentKeywordOrderdByDesc(String kw,int page, int pageSize){
        int totalCount = wiseSayings
                .stream()
                .filter( w->w.getAuthor().contains(kw))
                .toList()
                .size();
        List<WiseSaying> content = wiseSayings
                .reversed()
                .stream()
                .skip(pageSize*(page-1))
                .filter(w->w.getSaying().contains(kw))
                .limit(pageSize)
                .toList();
        return new PageDto(page,pageSize,totalCount,content);
    }

    public PageDto findByauthorKeywordOrderdByDesc(String kw, int page, int pageSize){

        int totalCount = wiseSayings
                .stream()
                .filter( w->w.getAuthor().contains(kw))
                .toList()
                .size();
        List<WiseSaying> content = wiseSayings.reversed()
                .stream()
                .skip(pageSize*(page-1))
                .filter(w->w.getAuthor().contains(kw))
                .limit(pageSize)
                .toList()
                ;
        return new PageDto(page,pageSize,totalCount,content);
    }
}