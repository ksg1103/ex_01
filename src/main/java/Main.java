import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main
{
    public static void main(String [] args) {

        PrintStream ORIGINAL_OUT  = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //출력이 byteArrayOutputStream 이곳에 쌓인다.
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream); // 출력의 흐름 통제

        System.out.println("hi");
        System.out.println("hi");

        System.setOut(ORIGINAL_OUT);

        String rst = byteArrayOutputStream.toString();
        System.out.println(rst);
    }
    public static void lamb(){
        Scanner sc =new Scanner("""
                등록
                과거에집착하지마라.
                작자미상
        """); //이렇게 해서 입력을 자동화 하였다.

        String str1 = sc.next();
        String str2= sc.next();
        String str3 = sc.next();


        System.out.print(str2);
    }
    }

