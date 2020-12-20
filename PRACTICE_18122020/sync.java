class CarQueue{
    int n;
    boolean value = false;
    synchronized void get(){
        try {
            if(!value){
                // System.out.println("Hello");
                wait();
                // System.out.println("World");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        value = false;
        System.out.println("Car no. "+n+" serviced");
        notify();
    }
    synchronized void put(int n){
        try {
            if(value){
                //System.out.println("Bye");
                wait();
                //System.out.println("Heaven");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        this.n = n;
        value = true;
        System.out.println("Car no. "+n+" has to be serviced");
        notify();
    }
}

class CarOwn implements Runnable{
    CarQueue c;
    Thread t;
    CarOwn(CarQueue c){
        this.c = c;
        t = new Thread(this,"car owner");
        t.start();
    }
    public void run(){
        for(int i=1;i<10;i++){
            c.put(i);
        }
    }
}

class CarMech implements Runnable{
    CarQueue c;
    Thread t;
    CarMech(CarQueue c){
        this.c = c;
        t = new Thread(this,"car owner");
        t.start();
    }
    public void run(){
        for(int i=1;i<10;i++){
            c.get();
        }
    }
}

class Main {
    public static void main(String[] args) {
        CarQueue c = new CarQueue();
        CarMech c2 = new CarMech(c);
        CarOwn c1 = new CarOwn(c);
        try{
            c1.t.join();
            c2.t.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}


/*
"C:\Program Files\Java\jdk1.8.0_271\bin\java.exe

Car no. 1 has to be serviced
Car no. 1 serviced
Car no. 2 has to be serviced
Car no. 2 serviced
Car no. 3 has to be serviced
Car no. 3 serviced
Car no. 4 has to be serviced
Car no. 4 serviced
Car no. 5 has to be serviced
Car no. 5 serviced
Car no. 6 has to be serviced
Car no. 6 serviced
Car no. 7 has to be serviced
Car no. 7 serviced
Car no. 8 has to be serviced
Car no. 8 serviced
Car no. 9 has to be serviced
Car no. 9 serviced

Process finished with exit code 0

*/