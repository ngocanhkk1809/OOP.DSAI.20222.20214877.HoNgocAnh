import javax.swing.JOptionPane;
//a1x1+a2x2=a0;
//b1x1+b2x2=b0

public class FirstDegreeEquationLinearSystem {
    public static void main(String[] args){
        String sa1,sa2,sa0,sb1,sb2,sb0;
        
        sa1=JOptionPane.showInputDialog(null, "Nhap he so a1","Nhap he so a1",JOptionPane.INFORMATION_MESSAGE);
        sa2=JOptionPane.showInputDialog(null, "Nhap he so a2","Nhap he so a2",JOptionPane.INFORMATION_MESSAGE);
        sa0=JOptionPane.showInputDialog(null, "Nhap gia tri a0","Nhap gia tri a0",JOptionPane.INFORMATION_MESSAGE);
        
        double a1=Double.parseDouble(sa1);
        double a2=Double.parseDouble(sa2);
        double a0=Double.parseDouble(sa0);

        sb1=JOptionPane.showInputDialog(null, "Nhap he so b1","Nhap he so b1",JOptionPane.INFORMATION_MESSAGE);
        sb2=JOptionPane.showInputDialog(null, "Nhap he so b2","Nhap he so b2",JOptionPane.INFORMATION_MESSAGE);
        sb0=JOptionPane.showInputDialog(null, "Nhap gia tri b0","Nhap gia tri b0",JOptionPane.INFORMATION_MESSAGE);
        
        double b1=Double.parseDouble(sb1);
        double b2=Double.parseDouble(sb2);
        double b0=Double.parseDouble(sb0);

        double D=(a1*b2-a2*b1);
        double D1x=-(a2*b0-a0*b2);
        double D2x=(a1*b0-a0*b1);
        if (D!=0){
            JOptionPane.showMessageDialog(null, "x="+D1x/D +"\n" +"y="+D2x/D,"Solution",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            double M=b1/a1;
            double N=b0/a0;
            if (M==N){
                JOptionPane.showMessageDialog(null, "Infinite solutions", "Result",JOptionPane.INFORMATION_MESSAGE);
            }
            if (M!=N){
                JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
