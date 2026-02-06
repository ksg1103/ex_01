import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    int lastid;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    public App(Scanner sc) {
        this.sc  = sc;
        lastid = 0;
    }

    public void run() {


        System.out.println("== 명언 앱 ==");

    while (true){
        System.out.println("명령) ");
        String cmd = sc.nextLine();
        switch (cmd) {
            case "등록" -> {
                System.out.print("명언 : ");
                String saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();


                ++lastid;
                WiseSaying wiseSaying = new WiseSaying(lastid, saying, author);
                wiseSayings.add(wiseSaying);

                System.out.println(lastid + "번 명언이 등록되었습니다.");
            }
            case "종료" -> {
                return;
            }
            case "목록" -> {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                wiseSayings
                        .reversed()
                        .stream()
                        .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                                wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getSaying()));

            }

        }
    }

    }
}