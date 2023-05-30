import javax.swing.JOptionPane;
//ax^2 + bx + c = 0
public class SecondDegreeEquation {
    public static void main(String[] arg){
        String stra,strb,strc;

        stra = JOptionPane.showInputDialog(null, "The number a is:","Enter Value",JOptionPane.INFORMATION_MESSAGE);
        strb = JOptionPane.showInputDialog(null, "The number b is:","Enter Value",JOptionPane.INFORMATION_MESSAGE);
        strc = JOptionPane.showInputDialog(null, "The number c is:","Enter Value",JOptionPane.INFORMATION_MESSAGE);
        
        double a = Double.parseDouble(stra);
        double b = Double.parseDouble(strb);
        double c = Double.parseDouble(strc);
        double delta = Math.pow(b, 2)-4*a*c;

        if (a==0){
            if (b==0){
                if (c==0){
                    JOptionPane.showMessageDialog(null, "All real numbers are root", "Answer",JOptionPane.INFORMATION_MESSAGE );
                }
                if (c!=0){
                    JOptionPane.showMessageDialog(null, "No real roots", "Answer",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"x="+ -c/b, "Answer",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            if (delta==0){
                JOptionPane.showMessageDialog(null, "x="+-b/(2*a), "Result", JOptionPane.INFORMATION_MESSAGE);

            }
            else if (delta <0){
                JOptionPane.showMessageDialog(null, "No real roots", "Result", JOptionPane.INFORMATION_MESSAGE);

            }
            else{
                double x1=(-b+Math.sqrt(delta))/(2*a);
                double x2=(-b-Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "x1="+x1+"\n"+"x2="+x2, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
