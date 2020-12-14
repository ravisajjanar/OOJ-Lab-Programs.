import java.util.Random;

class CubeThread implements Runnable{
    Thread t;
    int num;
    CubeThread(int value){
        t = new Thread(this,"cube thread");
        num = value;
        t.start();
    }
    public void run(){
        System.out.println(num*num*num);
    }
}

class SquareThread implements Runnable{
    Thread t;
    int num;
    SquareThread(int value){
        t = new Thread(this,"square thread");
        num = value;
        t.start();
    }

    public void run(){
        System.out.println(num*num);
    }
}

class ControlThread implements Runnable{
    Thread t;
    ControlThread(){
        t = new Thread(this,"control");
        t.start();
    }
    public void run(){
        try {
            for(int i=1;i<=20;i++){
                int val = (int)Math.floor(Math.random()*10);
                if(val%2==0){
                    System.out.print("Square of "+val+": ");
                    SquareThread ob = new SquareThread(val);
                    Thread.sleep(1000);
                    System.out.println();
                }else{
                    System.out.print("Cube of "+val+": ");
                    CubeThread ob = new CubeThread(val);
                    Thread.sleep(1000);
                    System.out.println();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Extr2{
        public static void main(String[] args){
            ControlThread t1 = new ControlThread();
            try{
                t1.t.join();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
}