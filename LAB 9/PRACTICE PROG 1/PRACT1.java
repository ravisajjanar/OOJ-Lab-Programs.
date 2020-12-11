class OddThread implements Runnable{
    Thread t;
    OddThread(){
        t = new Thread(this,"odd no cal");
        t.start();
    }
    public void run(){
        try {
            int sum=0;
            for(int i=1;i<=100;i++){
                if(i%2==1){
                    sum+=i;
                }
            }
            System.out.println("Odd numbers Sum = "+sum); 
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class PRACT1{
    public static void main(String[] args){

	System.out.println("Summation from 1 to 100");

        OddThread ob1 = new OddThread();
        try {
            int sum=0;
            for(int i=1;i<=100;i++){
                if(i%2==0){
                    sum+=i;
                }
            }
            System.out.println("Even numbers Sum = "+sum);
            ob1.t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}