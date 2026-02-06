package com.back;

import com.back.system.controller.SystemController;
import com.back.wiseSaying.controller.WiseSayingController;
import com.back.wiseSaying.repository.WiseSayingRepository;
import com.back.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {

    public static Scanner sc;
    public static SystemController systemController;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingRepository wiseSayingRepository;

    public static void init(Scanner _sc) {
        AppContext.sc = _sc;
        AppContext.wiseSayingRepository = new WiseSayingRepository();
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController(sc);
        //순서 중요 !! 위에 3개 꼬이면 안됨
        AppContext.systemController = new SystemController();
    }

    public static void init() {
        init(new Scanner(System.in));
    }


}