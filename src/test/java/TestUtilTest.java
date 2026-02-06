import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {

    @Test
    @DisplayName("TestUtill.genScanner()")
    void t1() {
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

    @Test
    @DisplayName("TestUtill.setOutByteArray()")
    void t2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutByteArray();

        System.out.println("안녕하세요.");

        String rst  = byteArrayOutputStream.toString();

        //assertThat(rst).isEqualTo("안녕하세요"); isEqualTo는 정확히 일치해야한다.

        TestUtil.clearSetOutByteArray(byteArrayOutputStream);
        //모니터로 확인하고 싶은 시점
        System.out.println("출력결과 : " + rst);

        assertThat(rst).contains("안녕하세요");
    }


}
