package cie;

public class internals extends Student{
    
public int[] cieMarks = new int[5];
    
public internals(int usn,String name,int sem,int[] cieMarks){
        
super(usn,name,sem);
        
this.cieMarks = cieMarks;
    
}

}