package pratice.demo;

import java.util.Scanner;

public class equalPratice {
    public static void main(String[] args) {
        System.out.println(args[0]+ args[1] +args[2]);
        if(args[0].equals(args[1])&& args[1].equals(args[2])){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
        Scanner a = new Scanner(System.in);
        double temp = Double.parseDouble(a.nextLine());
        if(temp < 1&& temp>0){
            System.out.println(true);
        }
    }
}
