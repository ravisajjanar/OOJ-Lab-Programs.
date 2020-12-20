import java.util.Scanner;

public class Table {
    public static void main(String args[]) {
        cal c = new cal();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        table obj = new table(n,c,5);
        table obj1 = new table(n,c,100);
        try {
            obj.t.join();
            obj1.t.join();
        }catch(Exception e) {
            System.out.println("exception occured");
        }
        System.out.println("thank you");
    }
}
class table implements Runnable {
    int n,tabl;
    Thread t;
    cal tar;
    table(int n,cal c,int tab){
        tabl =tab;
        tar=c;
        this.n=n;
        t=new Thread(this);t.start();
    }
    public void run() {
        synchronized(tar) {
            tar.cals(n, tabl);
        }
    }
}
class cal{
    void cals(int n,int ta) {
        for(int i=1;i<=n;i++) {
            System.out.println(ta+" x "+i+" = "+(ta*i));
        }
    }
}





/*OUTPUT:

"C:\Program Files\Java\jdk1.8.0_271\bin\java.exe

Enter the number of elements : 
12
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
5 x 11 = 55
5 x 12 = 60
100 x 1 = 100
100 x 2 = 200
100 x 3 = 300
100 x 4 = 400
100 x 5 = 500
100 x 6 = 600
100 x 7 = 700
100 x 8 = 800
100 x 9 = 900
100 x 10 = 1000
100 x 11 = 1100
100 x 12 = 1200
thank you

Process finished with exit code 0
*/

