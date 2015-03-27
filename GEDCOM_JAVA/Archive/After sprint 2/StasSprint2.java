package cs555_ged;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sgrozny
 */
public class StasSprint2 {
    static String culprit[]= new String[6000];   //6000 instead of 5000 in case file is really messed up 
    static String lineage[] =  new String[6000]; //(e.g. 4000 individulas but 2001 are calls to indviduals that were already created)
    static int counter=1;
    static int lcounter =1;
    static int intital;
    public static int ChildisItsparent(IndividualStruct.individual indArr[], Integer iTotal, FamilyStruct.family famArr[],Integer fCounter){
        Printing.printHeader("Checking if a loop exists on any family members");
        int numerrors =0;
        int i;
        for(int j=0;j<iTotal+1;j++){
          //  System.out.println("------------------------");
          //  System.out.println("For indvidual " + indArr[j].getName()); 
            for(i=0; i<iTotal;i++){
                indArr[i].visited=false;
            }
            int fam;
            //indArr[j].visited=true;
            if (indArr[j].Spouse!=null){
                fam=indArr[j].Spouse;
                intital=j;
                lineage[0]=famArr[fam].getID();;
                culprit[0]=famArr[fam].getID();
                counter=1;
                lcounter=1;
              //  System.out.println("Spouse to family: " +famArr[fam].getID());
                if(famArr[fam].getChild(0)!=-1){
    //                System.out.println("Running DFS on Child: " + indArr[famArr[fam].getChild(0)].getName()+ " of family: " +famArr[fam].getID() );
    //                DFSonChildren(indArr, iTotal, famArr, fCounter,famArr[fam].getChild(0));
    //                System.out.println("Ran upperlevel DFS on Child: " + indArr[famArr[fam].getChild(0)].getName()+ " of family: " +famArr[fam].getID() );
                //    System.out.println("Running DFS on individual: " + indArr[j].getName()+ " of family: " +famArr[fam].getID() );
                    DFSonChildren(indArr, iTotal, famArr, fCounter,j, fam);
                  //  System.out.println("Ran upperlevel DFS on individual: " + indArr[j].getName()+ " of family: " +famArr[fam].getID() );
                  //  System.out.println("i= "+ 0 +"  -   " +culprit[0]);
                    for (i=1; i<counter;i++){
                       // System.out.println("i= "+ i +"  -   " +culprit[i]);
                        if(!culprit[i].equals(culprit[0])) {
                            numerrors++;
                            Printing.print(1,"ERROR # " + "FOUND: There is a loop on individual: " + indArr[j].getName());
                        }
                    }
//                    System.out.println("Lineage start");
//                    for(i=1; i <lcounter; i++){
//                        System.out.println(lineage[i]);
//                    }
                }
//                else {
//                    System.out.println("No children for: "+indArr[j].getName());    
//                }   
           }
//           else {
//                    System.out.println("Not a spouse: "+indArr[j].getName());    
//                } 
        }
        return numerrors;
    }

    private static boolean DFSonChildren(IndividualStruct.individual indArr[], Integer iTotal, FamilyStruct.family famArr[],Integer fCounter, Integer startingInd, int fam){
        
        if(!indArr[startingInd].visited){       //if the indidual hasn't been visited
          //  System.out.println("Check if spouse is null");
            if(indArr[startingInd].Spouse!=null){
           //     System.out.println("spouse isn't null");
            fam=indArr[startingInd].Spouse;
            indArr[startingInd].visited=true;
            int i=0;
               if (famArr[fam].getNumChildren()==0){
                //System.out.println("NO KIDS");
                }
               else{
                 // System.out.println("HAS KIDS");
                  
                for(i=0;i<famArr[fam].getNumChildren();i++){
//                    System.out.println("i=" +i);
//                    System.out.println("numkids=" +famArr[fam].getNumChildren());
////                    for(int k=0; k<famArr[fam].getNumChildren();k++){
////                        System.out.println(famArr[fam].getChild(k));
////                    }
                    lineage[lcounter]=famArr[fam].getID();
                    lcounter++;
                    //System.out.println("Running DFS on Child: " + indArr[famArr[fam].getChild(i)].getName()+ " of family: " +famArr[fam].getID() );
                    DFSonChildren(indArr, iTotal, famArr, fCounter,famArr[fam].getChild(i), fam);
                }  
               }
            }
            else{
              //  System.out.println(" spouse is null");
            }
        }
        else{
           // System.out.println("Visited");
            if(intital==startingInd){
               // System.out.println("Repeated");
                culprit[counter]=famArr[fam].getID();
                counter++;
            }
            return true;
        }
    return false;
    }
    private boolean isRealAlert(){
        boolean isrealAlert=false;
        
        return isrealAlert;
    }
}
    