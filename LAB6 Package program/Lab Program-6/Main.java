import cie.*;

import see.*;

import java.util.*;

class Main{
    
public static void main(String[] args) {
        
Scanner input = new Scanner(System.in);
        externals[] e = new externals[2];
        
internals[] in = new internals[2];
        
for(int i=0;i<2;i++){
  
System.out.println("Enter the USN of std"+(i+1));        
int usn1 = input.nextInt();
  
System.out.println("Enter the Name of std"+(i+1));          
String name1 = input.next();
  
System.out.println("Enter the Sem of std"+(i+1));         
int sem1 = input.nextInt();
 
System.out.println("Enter the CIE marks of 5 subjects.");            
int[][] cie = new int[2][5];
            
int[][] see = new int[2][5];
            
for(int j=0;j<5;j++){
                
cie[i][j] = input.nextInt();
            
}
  
System.out.println("Enter the SEE marks of 5 subjects.");          
for(int j=0;j<5;j++){
                
see[i][j] = input.nextInt();
            
}
 
System.out.println("*************************");       
e[i] = new externals(usn1,name1,sem1,see[i]);
            in[i] = new internals(usn1,name1,sem1,cie[i]);
            int total = 0;
            
System.out.println("Name: "+e[i].name);
            System.out.println("USN: "+e[i].usn);
            System.out.println("sem: "+e[i].sem);
   
int k=1;
System.out.println("Final marks:");
          
for(int j=0;j<5;j++){
                
total = e[i].seeMarks[j]+in[i].cieMarks[j];
  
System.out.print("Sub" +(k++)+ "marks: " +total+ " ");
            
}
            
System.out.println();
       
 }
    
}

}


