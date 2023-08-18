import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
class Codechef 
{ 
 
    static long gcd(long aa, long bb) 
    { 
        if (aa == 0) 
            return bb; 
        return gcd(bb % aa, aa); 
    } 
 
    // Function to find gcd of array of 
    // numbers 
    static long findGCD(List<Integer> arr) 
    { 
        long res = 0; 
        for (long element: arr){ 
            res = gcd(res, element); 
            if(res == 1) 
            { 
               return 1; 
            } 
        } 
        return res; 
    } 
 
  static long Mod(long aa, long bb,long mm){ 
    if(bb==0)   
      return 1; 
    else if(bb%2==0){ 
      long yy=Mod(aa,bb/2,mm); 
      return (yy*yy)%mm; 
    } 
    else 
      return ((aa%mm)*Mod(aa, bb-1, mm))%mm; 
  } 
 
  static long findChefora(long n){ 
    long rev=0,rem; 
    long N=n; 
    int d=-1; 
    while (N!=0){ 
      d++; 
      rem=N%10; 
      rev=rev*10+rem; 
      N/=10; 
    } 
    StringBuilder str=new StringBuilder(String.valueOf(n)); 
    long value=(rev)%(long)Math.pow(10, d); 
    String str1=String.valueOf(value); 
    if(str1.length()!=d){ 
      int len=d-str1.length();   
      for (int i = 0; i <len; i++) { 
        str1="0"+str1; 
      } 
    } 
 
    str.append(value!=0?str1:""); 
    return Long.parseLong(str.toString()); 
  } 
 public static void main (String[] args) throws java.lang.Exception 
 { 
  try{ 
      Scanner scanner=new Scanner(System.in); 
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
      long[] cheforasNum=new long[100001]; 
      long[] pre=new long[100001]; 
      long sum=0; 
      cheforasNum[0]=0; 
      for (int i = 1; i <=100000; i++) { 
        cheforasNum[i]=findChefora(i); 
        sum+=cheforasNum[i]; 
        pre[i]=sum; 
      } 
      int T=scanner.nextInt(); 
      long ans=1; 
      long mm=1000000007; 
      for (int I = 0; I < T; I++) { 
        int Left=scanner.nextInt(); 
        int Right=scanner.nextInt(); 
        for (int i = 1; i <=1000; i++) { 
          cheforasNum[i]=findChefora(i); 
          sum+=cheforasNum[i]; 
          pre[i]=sum; 
        } 
        long aa=cheforasNum[Left]; 
        long bb=pre[Right]-pre[Left]; 
        ans=Mod(aa, bb, mm); 
        System.out.println(ans); 
      } 
      reader.close(); 
      scanner.close(); 
    } 
    catch(Exception e){ 
      System.out.println(e.getMessage()); 
      return; 
    } 
 } 
}