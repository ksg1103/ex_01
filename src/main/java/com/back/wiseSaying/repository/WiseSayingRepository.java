package com.back.wiseSaying.repository;

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
    public List<WiseSaying> findListDesc(int page, int pageSize) {

        return wiseSayings
                .reversed()
                .stream()
                .skip(pageSize*(page-1))
                .limit(pageSize)
                .toList()
                ;
    }
    public List<WiseSaying> findByContentKeywordOrderdByDesc(String kw,int page, int pageSize){
        return wiseSayings
                .reversed()
                .stream()
                .skip(pageSize*(page-1))
                .filter(w->w.getSaying().contains(kw))
                .limit(pageSize)
                .toList();

    }

    public List<WiseSaying> findByauthorKeywordOrderdByDesc(String kw,int page, int pageSize){
        return wiseSayings.reversed()
                .stream()
                .skip(pageSize*(page-1))
                .filter(w->w.getAuthor().contains(kw))
                .limit(pageSize)
                .toList()
                ;
    }
}