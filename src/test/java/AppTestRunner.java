import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input){
        Scanner sc = TestUtil.genScanner(input); //여기는 입력부분인데 입력을 자동화 시켰다.

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray(); //출력 통제, 왜?
        new App(sc).run();

        return outputStream.toString();
    }
}
