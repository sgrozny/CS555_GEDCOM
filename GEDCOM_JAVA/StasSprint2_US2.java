/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class StasSprint2_US2 {
    public static int ind_is_SpouseandChild(IndividualStruct.individual indArr[], Integer iTotal){
       Printing.printHeader("Checking if Indvidual is both a spouse and child to same family:");
        int numerrors=0;
        for(int i=0;i<iTotal+1;i++){
            if((indArr[i].FAMC!=null)&&(indArr[i].FAMS)!=null){
                if((indArr[i].FAMC).equals(indArr[i].FAMS)){
                    numerrors++;
                    Printing.print(1,"Error #" + numerrors + " found");
                    Printing.PrintIndividualDetails(indArr, i, 2);
                }
            }
        }
        return numerrors;
    }
    
//    public static void numallkids(FamilyStruct.family famArr[],int fcounter, IndividualStruct.individual indArr[]){
//        for(int i=0;i<fcounter+1; i++){
//            System.out.println(famArr[i].getID() + "  :  "+ famArr[i].getNumChildren());
//            for(int j=0;j<famArr[i].getNumChildren();j++){
//                System.out.println(indArr[famArr[i].getChild(j)].getName());
//            }
// 
//        }
//    }
}
