import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {
    static PrintStream ORIGINAL_OUT = System.out;
    static PrintStream CURRENT_OUT = System.out;

    public static String run(String input){
        // 입력값
        Scanner sc = new Scanner(input);

        //명언 프로그램 실행

        //출력값

    }


    public static Scanner genScanner(String input){
        return new Scanner(input);
    }

    public static ByteArrayOutputStream setOutByteArray(){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        CURRENT_OUT = printStream;

        return byteArrayOutputStream;
    }

    public static void clearSetOutByteArray(ByteArrayOutputStream outputStream)throws  Exception{
        System.setOut(ORIGINAL_OUT);
        outputStream.close();
        CURRENT_OUT.close();
        // 종료 안하면, 자원 소모가 계속 된다.
    }

}
