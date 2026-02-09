package com.back.wiseSaying.dto;

import com.back.wiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@AllArgsConstructor
public class PageDto {
    private int page;
    private  int pageSize;
    private  int totalCount;
    private List<WiseSaying> content;

    public int getPageCount(){
        return (int)Math.ceil((double) totalCount /pageSize);
        //return totalCount%pageSize == 0 ? totalCount/pageSize :totalCount/pageSize +1;
    }


}
