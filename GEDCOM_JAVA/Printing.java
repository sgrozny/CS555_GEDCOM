/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class Printing {
    public static void printIT(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
            System.out.println("Individuals:");
       for(int i=0;i<Itotal+1;i++){
            System.out.println("ID: " + indArr[i].getID() + " :  ");
            System.out.println("Name: " + indArr[i].getName());
            System.out.println("Gener: " + indArr[i].gender);
            System.out.println("BirthDay: " + indArr[i].BDay);
            System.out.println("Death Date: " + indArr[i].DDay);
            System.out.println("Spouse of Family: " + indArr[i].FAMS);
            System.out.println("Child of Family:" + indArr[i].FAMC);
//            if(indArr[i].getChild()!=null){
//            System.out.println("Child of Family: "  + famArr[indArr[i].getChild()].getID());
//            }
//            else {
//                System.out.println("Child of Family: null" );
//            }
            System.out.println("==============================================");
 
       }
       System.out.println("------------------------------");
       System.out.println("Families");
       Integer w,h;
       for(int i=0;i<Ftotal+1;i++){
           System.out.println("Family ID:" +famArr[i].getID());
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           if(h!=null){
           System.out.println("Husband: "+ indArr[h].getName());
           }
           else{
               System.out.println("Husband: null");
           }
           if(w!=null){
           System.out.println("Wife: " + indArr[w].getName());
           }
           else{
                System.out.println("Wife: null");
           }
           System.out.println("DivorceDate: " + famArr[i].getDivDate());
           System.out.println("Num of Children: " + famArr[i].getNumChildren());
           System.out.println("~~~~~~~~~~~~~~~~~");
       }
    }
    public static void PrintIndividualDetails(IndividualStruct.individual indArr[], int i, int tabs){
            print(tabs-1, "Individual Record");
            print(tabs,"ID: " + indArr[i].getID());
            print(tabs,"Name: " + indArr[i].getName());
            print(tabs,"Gener: " + indArr[i].gender);
            print(tabs,"BirthDay: " + indArr[i].BDay);
            print(tabs,"Death Date: " + indArr[i].DDay);
            print(tabs,"Spouse to Family: " +indArr[i].FAMS);
            print(tabs,"Child to Family: " +indArr[i].FAMC);
    }
    public static void ListAllIndividuals(IndividualStruct.individual indArr[], int iTotal, int tabs){
        print(tabs-1, "List of all Individual IDS");  
        for(int i=0;i<iTotal+1;i++){
            print(tabs,indArr[i].ID);
        }
    }

    public static void PrintFamilyDetails(FamilyStruct.family famArr[], int f, int tabs, IndividualStruct.individual indArr[], boolean printkids, boolean useraw){
        print(tabs-1, "Family Record");
        print(tabs, "ID: " + famArr[f].ID);
        print(tabs, "Husband: " + famArr[f].husbS);
        print(tabs, "Wife: " + famArr[f].wifeS);
        print(tabs, "Married Date: " + famArr[f].getMarriedDate());
        print(tabs, "Divorce Date: " + famArr[f].getDivDate());
        if(!useraw){
            print(tabs, "Number of Children: " + famArr[f].getNumChildren());
        }
        if (printkids){
            if(useraw){
                print(tabs, "Number of Children: " + famArr[f].numcIds);
                for(int i=0;i<famArr[f].numcIds;i++){
                    print(tabs+1,"ID: " + famArr[f].childIds[i]);
                }
            }
            else{
                for(int i=0;i<famArr[f].getNumChildren();i++){
                    print(tabs+1,"ID: " + indArr[famArr[f].getChild(i)].ID+ "       Name: " +indArr[famArr[f].getChild(i)].name);
                }
            }
                
        }
    }
    public static void PritnAllChildren(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
         for(int i=0;i<Ftotal+1;i++){
             System.out.println("Family ID:" +famArr[i].getID());
                   for(int j=0; j<30;j++){
                       if ((famArr[i].getChild(j))==-1){
                           break;
                       }
                       else{
                       System.out.println("Child " + (j+1) + ": " + indArr[famArr[i].getChild(j)].name);
                       }
                   }
           }
    }
     public static void print(int tab, String txt){
        String tabS="";
        for(int i=0;i<tab;i++){
            tabS= tabS.concat("     ");
        }
        System.out.println(tabS+txt);
    }
     public static void printHeader(String header){
         String x="============";
         System.out.println(x+header+x);
     }
     public static void ListAllFamilies(FamilyStruct.family famArr[], int fT, int tabs){
         print(tabs-1, "List of all family IDS");   
         for(int f=0;f<fT+1;f++){
                print(tabs,famArr[f].ID);
            }
     }
}
