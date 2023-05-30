import java.util.Scanner;
public class TriangleStar {
    public static void main(String[] arg){
        Scanner keyboard =new Scanner(System.in);
        System.out.println("Nhap x:");
        int x = keyboard.nextInt();
        for (int i = 0 ; i < x ; i++){
            for (int j = 0; j < x-i ; j++){
                System.out.print(" ");}
            for (int j = 0 ; j < 2*i + 1; j++){
                System.out.print("*");
            }
            for (int j = 0 ; j < x-i ; j++){
                System.out.print(" ");
            }
        System.out.println();    
        }
        keyboard.close();
    }   
}
