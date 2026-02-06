import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {

    @Test
    @DisplayName("TestUtill.genScanner()")
    void t0(){
        Scanner scanner = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                """);
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String author = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
    }
//
//    @Test
//    @DisplayName("등록")
//    void t1(){
//            //클래스.함수로 바로 사용한다?(객체 생성을 안하고 사용한다?) -> static 이구나
//            final String out = TestUtil.run("""
//                등록
//                현재를 사랑하라.
//                작자미상
//                """);
//
//            assertThat(out)
//                    .contains("명언 :")
//                    .contains("작가 :")
//                    .contains("1번 명언이 등록되었습니다.");
//
//    }
}
