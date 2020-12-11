class Gen<T,S>{
    private T obj;
    private S obj1;
    Gen(T value,S value2){
        obj = value;
        obj1 = value2;
    }
    T getObj(){
        return obj;
    }
    S getObj1(){
        return obj1;
    }
    void objType(){
        System.out.println("The type of object "+obj.getClass().getName());
    }
    void objType1(){
        System.out.println("The type of object "+obj1.getClass().getName());
    }
}

public class lab7{
    public static void main(String[] args){
        Gen<Integer,Double> ob = new Gen<Integer,Double>(127,127.128);
        ob.objType();
        System.out.println("Object Value "+ob.getObj());
        ob.objType1();
        System.out.println("Object Value "+ob.getObj1());
        Gen<String,Integer> ob2 = new Gen<String,Integer>("Ravi Sajjanar",127);
        ob2.objType();
        System.out.println("Object Value "+ob2.getObj());
        ob2.objType1();
        System.out.println("Object Value "+ob2.getObj1());
    }

}
