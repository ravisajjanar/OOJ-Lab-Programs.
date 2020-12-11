import java.util.*;

class ageException extends Exception{
    int detail;
    ageException(int a){
        detail = a;
    }
    public String toString(){
        return "Exception :"+detail+" the enterred age does not match the category";
    }
}
class Father{
    int age;
    Father(int age) throws ageException{
        this.age = age;
        if(this.age<=0){
            throw new ageException(this.age);
        }
    }
    void display(){
        System.out.println("Father's age:"+this.age);
    }
}

class Son extends Father{
    Father f;
    Son(int age,Father f) throws ageException{
        super(age);
        this.f = f;
        if(this.age>=this.f.age){
            throw new ageException(this.age);
        }
    }
    void display(){
        this.f.display();
        System.out.println("Son's age:"+this.age);
    }
}

public class lab8{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the Father's age:");
            Father f = new Father(input.nextInt());
            System.out.print("Enter the Son's age:");
            Son s = new Son(input.nextInt(),f);
            s.display();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}