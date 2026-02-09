package com.back.wiseSaying.service;

import com.back.global.AppContext;
import com.back.wiseSaying.dto.PageDto;
import com.back.wiseSaying.entity.WiseSaying;
import com.back.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        //this.wiseSayingRepository = new WiseSayingRepository();
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public WiseSaying write(String saying, String author) {
        WiseSaying wiseSaying = new WiseSaying(saying, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public PageDto findListDesc(String kw, String kwt, int page, int pageSize) {
        //return wiseSayingRepository.findListDesc();
        return switch(kwt){
            case "content" ->wiseSayingRepository.findByContentKeywordOrderdByDesc(kw, page, pageSize);
            case "author" -> wiseSayingRepository.findByauthorKeywordOrderdByDesc(kw, page, pageSize);
            default -> wiseSayingRepository.findListDesc( page, pageSize);
        };

    }
    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findByIdOrNull(id);
    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {

        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }
}