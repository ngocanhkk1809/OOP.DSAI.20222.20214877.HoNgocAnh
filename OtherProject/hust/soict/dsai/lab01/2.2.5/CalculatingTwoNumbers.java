import javax.swing.JOptionPane;

public class CalculatingTwoNumbers {
    public static void main(String args[]) {
        String strNum1 = JOptionPane.showInputDialog("Enter the first number:");
        double num1 = Double.parseDouble(strNum1);

        String strNum2 = JOptionPane.showInputDialog("Enter the second number:");
        double num2 = Double.parseDouble(strNum2);
        //chuyen doi String sang double

        double sum=num1+num2;
        double dif=num1-num2;
        double pro=num1*num2;
        double quo=1;
        if (num2 !=0){
            quo=num1/num2;
        }
        if (num2!=0){
            JOptionPane.showMessageDialog(null, "The sum is: "+sum+"\n"+"The difference is: "+dif+"\n"+"The product is: "+pro+"\n"+"The quotient is: "+quo,
             "Result", 1);
        }
        else{
            JOptionPane.showMessageDialog(null, "The sum is: "+sum+"\n"+"The difference is: "+dif+"\n"+"The product is: "+pro+"\n"+"The quotient is: Divisor=0",
             "Result", 1);
        }
    }
}