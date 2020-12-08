package see;


import cie.*;


public class externals extends Student{
    
public int[] seeMarks = new int[5];
    
public externals(int usn,String name,int sem,int[] seeMarks){
        
super(usn,name,sem);
        
this.seeMarks = seeMarks;
    
}

}