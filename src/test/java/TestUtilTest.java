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
    void t2() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutByteArray();

        System.out.println("안녕하세요.");

        String rst  = byteArrayOutputStream.toString();

        assertThat(rst).isEqualTo("안녕하세요");
    }


}
