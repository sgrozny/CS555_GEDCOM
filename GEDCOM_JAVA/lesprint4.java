/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author zhang_le
 */
public class lesprint4 {
    public static int Userstory20(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
     Printing.printHeader("Checking whether Indvidual is both a spouse and a child to same family");
        int numErrors=0;
    Integer w,h;
    String ID;
  //  Integer c;
    Integer k;
    String wifeid;
    String husbandid;
    String kidid;
    
    for(int i=0;i<Ftotal+1;i++){
        
            ID=famArr[i].getID();
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           
         
           for(int j=0;j<famArr[i].getNumChildren();j++){
            kidid=indArr[famArr[i].getChild(j)].ID;
             
            //System.out.println("id is:"+kidid);
           if(w!=null&&h!=null&&kidid!=null){
            wifeid=indArr[w].getID();
            husbandid=indArr[h].getID();
           
            if(kidid==wifeid){
             System.out.println(" The relationship is wrong, because the wife ID equals child ID!"); 
              System.out.println("The wife'd ID IS:"+wifeid+", the child's ID is:"+kidid +". It is the ID of "+indArr[w].getName());
               
                      numErrors++; 
         
           
            }
            else if(kidid==husbandid){
                 
                 System.out.println(" The relationship is wrong, because the husband ID equals child ID!"); 
              System.out.println("The husband'd ID IS:"+husbandid+", the child's ID is:"+kidid+". It is the ID of "+indArr[h].getName() );
              
                      numErrors++; 
            }
            
           
           }
           }
    }
             System.out.println("the totoal number of errors is:"+numErrors);
           return numErrors;
           }
    public static int Userstory24(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
        Printing.printHeader( "check whether in one family, there is only one husband but no wife " );     
        int numErrors=0;
               Integer w,h;
    
    for(int i=0;i<Ftotal+1;i++){
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           if(w==null){
           if(h==null){
               System.out.println("In the family "+famArr[i].getID()+", there are no wife and husband existing !");
               Printing.PrintFamilyDetails(famArr,i,2,indArr,true,false);
            numErrors++;
           }
          
           else{
            System.out.println("In the family"+famArr[i].getID()+", there are no wife existing !");
               Printing.PrintFamilyDetails(famArr,i,2,indArr,true,false);
            numErrors++;
           }
           }
    }
           

    System.out.println("the total number of errors is:"+numErrors);
    return numErrors;
           }
    }
   
   

