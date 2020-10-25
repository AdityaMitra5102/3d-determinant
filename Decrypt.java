import java.util.*;
class Decrypt
{
    double a[]=new double[9];
    double b[]=new double[9];
    double x[]=new double[9];
    double k[]=new double[9];
    double privateKey;
    static Scanner sc=new Scanner(System.in);
    void read()
    {
        System.out.println("Enter public key 1");
        for(int i=0;i<9;i++)
        {
            a[i]=sc.nextDouble();
        }
        System.out.println("Enter public key 2");
        for(int i=0;i<9;i++)
        {
            b[i]=sc.nextDouble();
        }
        System.out.println("Enter cipher");
        for(int i=0;i<9;i++)
        {
            k[i]=sc.nextDouble();
        }
        System.out.println("Enter private Key");
        privateKey=sc.nextDouble();
        decrypt();
    }

    void decrypt()
    {
        double parityInput=k[0];
         k[0]=1;
        x[0]=privateKey/((-k[0]*(a[4]*b[8]+a[5]*b[7]-a[7]*b[5]-a[8]*b[4]))+(+k[1]*(a[3]*b[8]+a[5]*b[6]-a[6]*b[5]-a[8]*b[3]))+(-k[2]*(a[3]*b[7]+a[4]*b[6]-a[6]*b[4]-a[7]*b[3]))+(+k[3]*(a[1]*b[8]+a[2]*b[7]-a[7]*b[2]-a[8]*b[1]))+(-k[4]*(a[0]*b[8]+a[2]*b[6]-a[6]*b[2]-a[8]*b[0]))+(+k[5]*(a[0]*b[7]+a[1]*b[6]-a[6]*b[1]-a[7]*b[0]))+(-k[6]*(a[1]*b[5]+a[2]*b[4]-a[4]*b[2]-a[5]*b[1]))+(+k[7]*(a[0]*b[5]+a[2]*b[3]-a[3]*b[2]-a[5]*b[0]))+(-k[8]*(a[0]*b[4]+a[1]*b[3]-a[3]*b[1]-a[4]*b[0])));
       
        //System.out.println("Private key"+privateKey);
        
        //k[0]=1;
        for(int i=1;i<9;i++)
        {
            x[i]=k[i]*x[0];
        }
        double parity = Double.longBitsToDouble(Double.doubleToRawLongBits(k[1]) ^ Double.doubleToRawLongBits(k[2])^ Double.doubleToRawLongBits(k[3])^ Double.doubleToRawLongBits(k[4])^ Double.doubleToRawLongBits(k[5])^ Double.doubleToRawLongBits(k[6])^ Double.doubleToRawLongBits(k[7])^ Double.doubleToRawLongBits(k[8]));
        if(parity!=parityInput)
        {
            System.out.println("Parity check failure.");
            return;
        }
        show();
    }

    void show()
    {
        if(privateKey==0)
        {
            System.out.println("\nError! Either public keys are invalid or this cipher cannot be decrypted with these public keys on this algorithm. Try with different public keys.");
            return;
        }
        System.out.println("\nShowing Clear matrix");
        for(int i=0;i<9;i++)
        {
            System.out.print(x[i]+" ");
            if((i+1)%3==0)
            {
                System.out.println();
            }
        }
    }
    
    public static void main(String args[])
    {
        new Decrypt().read();
    }
}