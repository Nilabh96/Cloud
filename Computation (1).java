import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Computation {
    
    ArrayList<String> newcolp  = new ArrayList<>();
    ArrayList<String> newnn    = new ArrayList<>();
    ArrayList<String> newcolp3 = new ArrayList<>();
    
    float  ED1,ED2,ED3,DD1,DD2,DD3,r,t,s,m,n,o,p;
    
    int x;
    String y,q,uti;
    BufferedWriter br2;
    BufferedWriter br3;
    
    public void calculate() throws IOException,FileNotFoundException{
    
        File outpath = new File("C:\\Users\\HP\\Desktop\\final15.csv");
        System.out.println(" Starting Scheduling ");
       
        VM vm1= new VM(101,65,35,30);
        VM vm2 = new VM(102,70,40,8);
        VM vm3 = new VM(103,60,45,40);
        
        Read read=new Read();
        
        try {
            read.ReadCSV();
        }  
            catch (IOException e) {
            e.printStackTrace();
        }
        try 
        {
            br2 = new BufferedWriter(new FileWriter(outpath));
        } 
            catch (IOException e) {
            e.printStackTrace();
        }

        newcolp =read.getColp();
        newnn   =read.getNn();
        newcolp3=read.getColp3();
        
        for(x=0;x<15;x++){
            
            ED1=read.out(x,vm1.getO());
            ED2=read.out(x,vm2.getO());
            ED3=read.out(x,vm3.getO());
            //System.out.println("    ED1:     "+ED1+"    ED2     "+ED2+" ED3:     "+ED3+"\n");
 
            //System.out.println(x);
            
            if((ED1>=ED2)&&(ED1>=ED3))
            {
                DD1=ED1-ED1;
            }
            else if((ED2>=ED3))
            {
                DD1=ED2-ED1;
            }
            else
            {
                DD1=ED3-ED1;
            } 

            
            if((ED1>=ED2)&&(ED1>=ED3))
            {
                DD2=ED1-ED2;
            }
            else if((ED2>=ED3))
            {
                DD2=ED2-ED2;
            }
            else
            {
                DD2=ED3-ED2;
            }

            
            if((ED1>=ED2)&&(ED1>=ED3))
            {
                DD3=ED1-ED3;
            }
            else if((ED2>=ED3))
            {
                DD3=ED2-ED3;
            }
            else 
            {
                DD3=ED3-ED3;
            }
            
            
            //System.out.println("   DD1:       "+DD1+"  DD2       "+DD2+"   DD3:       "+DD3);
            
            float Z[][]  = new float [30][3];

            Z[x][0]=DD1;
            Z[x][1]=DD2;
            Z[x][2]=DD3;
            
           
            r=Z[x][0];
            t=Z[x][1];
            s=Z[x][2];
 
            q=newnn.get(x);
            y=newcolp.get(x);
            uti=newcolp3.get(x);
            
            
            // String r1 = Integer.toString(r);
           
            
            int y1= Integer.parseInt(y);
            
            if((r>t)&&(r>s))
            {
                if(vm1.n>y1){
                    try {
                        System.out.println(" VM ID "+vm1.m+" TASK ID "+q+"\n");       
                        br2.write(vm1.m+","+q+","+uti+"\n");
                        
                        }
                        catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if((t>s))
            {
               if((y1<vm2.n)){
                    try {
                        System.out.println(" VM ID "+vm2.m+" TASK ID "+q+"\n");
                        br2.write(vm2.getM()+","+q+","+uti+"\n");
                        }
                        catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            else 
            {
                int w=vm3.n;
                
              if(y1<w){        
                       {
                        try 
                            {
                            System.out.println(" VM ID "+vm3.m+" TASK ID "+q+"\n");
                            br2.write(vm3.m+","+q+","+uti+"\n");
                            } 
                            catch (IOException ex) {
                            ex.printStackTrace();
                            }
                }
                }
                }
                }
                br2.close();
                br2.close();
                br2.close();
                }
                
}