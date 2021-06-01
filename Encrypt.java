import java.util.*;
class Encrypt
{
    double a[]=new double[9];
    double b[]=new double[9];
    double x[]=new double[9];
    double k[]=new double[9];
    double otKey;
    static Scanner sc=new Scanner(System.in);
    void read()
    {
        System.out.println("Enter public key");
        for(int i=0;i<9;i++)
        {
            a[i]=sc.nextDouble();
        }
        System.out.println("Enter private key");
        for(int i=0;i<9;i++)
        {
            b[i]=sc.nextDouble();
        }
        System.out.println("Enter matrix to encrypt");
        for(int i=0;i<9;i++)
        {
            x[i]=sc.nextDouble();
        }
        encrypt();
    }

    void encrypt()
    {
        for(int i=0;i<9;i++)
        {
            k[i]=x[i]/x[0];
        }
        otKey=x[0]*((-k[0]*(a[4]*b[8]+a[5]*b[7]-a[7]*b[5]-a[8]*b[4]))+(+k[1]*(a[3]*b[8]+a[5]*b[6]-a[6]*b[5]-a[8]*b[3]))+(-k[2]*(a[3]*b[7]+a[4]*b[6]-a[6]*b[4]-a[7]*b[3]))+(+k[3]*(a[1]*b[8]+a[2]*b[7]-a[7]*b[2]-a[8]*b[1]))+(-k[4]*(a[0]*b[8]+a[2]*b[6]-a[6]*b[2]-a[8]*b[0]))+(+k[5]*(a[0]*b[7]+a[1]*b[6]-a[6]*b[1]-a[7]*b[0]))+(-k[6]*(a[1]*b[5]+a[2]*b[4]-a[4]*b[2]-a[5]*b[1]))+(+k[7]*(a[0]*b[5]+a[2]*b[3]-a[3]*b[2]-a[5]*b[0]))+(-k[8]*(a[0]*b[4]+a[1]*b[3]-a[3]*b[1]-a[4]*b[0])));
       
        k[0] = Double.longBitsToDouble(Double.doubleToRawLongBits(k[1]) ^ Double.doubleToRawLongBits(k[2])^ Double.doubleToRawLongBits(k[3])^ Double.doubleToRawLongBits(k[4])^ Double.doubleToRawLongBits(k[5])^ Double.doubleToRawLongBits(k[6])^ Double.doubleToRawLongBits(k[7])^ Double.doubleToRawLongBits(k[8]));
        show();
    }

    void show()
    {
        if(otKey==0)
        {
            System.out.println("\nError! Either keys are invalid or this matrix cannot be encrypted with these public keys on this algorithm. Try with different keys.");
            return;
        }
        System.out.println("\nShowing Cipher matrix");
        for(int i=0;i<9;i++)
        {
            System.out.print(k[i]+" ");
            if((i+1)%3==0)
            {
                System.out.println();
            }
        }
        System.out.println("\nShowing one time key: "+otKey);
    }
    
    public static void main(String args[])
    {
        new Encrypt().read();
    }
}