import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("==명언 앱 출력")
    void t1(){
        Scanner sc = TestUtil.genScanner("종료"); //여기는 입력부분인데 입력을 자동화 시켰다.

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray(); //출력 통제, 왜?
        new App(sc).run();

        String out = outputStream.toString();

        assertThat(out).contains("===명언 앱===");

    }

    @Test
    @DisplayName("==명언 앱 출력")
    void t2(){
        String out = AppTestRunner.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);
        assertThat(out).contains("===명언 앱===");

    }
}
