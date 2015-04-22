/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class StasSprint4 {
    static Integer[] famhIDS= new Integer[10];
    static Integer[] famwIDS= new Integer[10];
    static int hc=0, wc=0;
    public static int Polygamy(IndividualStruct.individual indArr[], int iTotal, FamilyStruct.family famArr[],  int Ftotal){
        Printing.printHeader("Checking to see if 1 person has multiple spouses");
        int numErrors=0;
        int x;
    String indID;
    
    for(int i=0;i<iTotal+1;i++){
        indID=indArr[i].ID;
        x=isPolygamist(indArr,famArr,Ftotal,i,indID,numErrors);
        if(numErrors!=x){
            numErrors=x;
            System.out.println("-------------------------------------------------------------------------------------------");                            
            } 
        }
    return numErrors;
    }
    public static int isPolygamist(IndividualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal, int i, String ID, int errorCounter){
        
        Integer thishsb,thiswf, checkhsb, checkwf;
        String hID, wID;
        boolean manyfam=false;
        Integer cFam=indArr[i].Spouse;
        if (cFam!=null){
            if(indArr[i].getGender().equals("M")){
                for(int f=0;f<Ftotal+1;f++){
                   hID=famArr[f].husbS;
                   if(cFam!=f){
                        if(hID!=null){
                            if (hID.equals(ID)){
                                if(famArr[f].DivDate==null){                               
                                    if(famArr[f].wife!=null){
                                        if(indArr[famArr[f].wife].DDay==null){
                                            if(!manyfam){
                                                errorCounter++;
                                                //System.out.println("-------------------------------------------------------------------------------------------");
                                                Printing.print(2, "Error #" +errorCounter +": this individual appears as a husband in another family");
                                                Printing.PrintIndividualDetails(indArr, i, 4);
                                                Printing.print(2, "Original family is " +indArr[i].FAMS + ". However he was also found in family " + famArr[f].ID);
                                                System.out.print("Original ");
                                                Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 4, indArr, true, false);
                                                manyfam=true;
                                            }
                                            else{
                                                errorCounter++;
                                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                                Printing.print(2, "Error #" +errorCounter +": Above individual is also found in family " + famArr[f].ID);

                                            }
                                            Printing.PrintFamilyDetails(famArr, f, 4, indArr, false, false);

                                        }
                                    }
                                    else{
                                           if(!manyfam){
                                                errorCounter++;
                                                //System.out.println("-------------------------------------------------------------------------------------------");
                                                Printing.print(2, "Error #" +errorCounter +": this individual appears as a husband in another family");
                                                Printing.PrintIndividualDetails(indArr, i, 4);
                                                Printing.print(2, "Original family is " +indArr[i].FAMS + ". However he was also found in family " + famArr[f].ID);
                                                System.out.print("Original");
                                                Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 4, indArr, true, false);
                                                manyfam=true;
                                            }
                                            else{
                                                errorCounter++;
                                                Printing.print(2, "Error #" +errorCounter +": Above individual is also found in family " + famArr[f].ID);

                                            }
                                            Printing.PrintFamilyDetails(famArr, f, 4, indArr, false, false);                                        
                                    }

                                }                        
                            }
                       }
                    }
                }
            }
            else if(indArr[i].getGender().equals("F")){

                for(int f=0;f<Ftotal+1;f++){
                   if(cFam!=f){
                    wID=famArr[f].wifeS;
                  // Printing.print(0, ""+ID+ "     "+ famArr[f].ID);
                        if(wID!=null){
                            if (wID.equals(ID)){
                                 //Printing.print(1, "IDS MAtch");
                                if(famArr[f].DivDate==null){
                                    // Printing.print(1, "no div date");
                                    if(famArr[f].husband!=null){
                                        //Printing.print(0, "has husb");
                                        if(indArr[famArr[f].husband].DDay==null){
                                            if(!manyfam){
                                                errorCounter++;
                                                //System.out.println("-------------------------------------------------------------------------------------------");
                                                Printing.print(2, "Error #" +errorCounter +": this individual appears as a wife in another family");
                                                Printing.PrintIndividualDetails(indArr, i, 4);
                                                Printing.print(2, "Original family is " +indArr[i].FAMS + ". However she was also found in family " + famArr[f].ID);
                                                System.out.print("Original ");
                                                Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 4, indArr, false, false);
                                                manyfam=true;
                                            }
                                            else{
                                                errorCounter++;
                                                Printing.print(2, "Error #" +errorCounter +": Above individual is also found in family " + famArr[f].ID);

                                            }
                                            Printing.PrintFamilyDetails(famArr, f, 4, indArr, false, false);

                                        }
                                    }
                                    else{
                                           if(!manyfam){
                                                errorCounter++;
                                                //System.out.println("-------------------------------------------------------------------------------------------");
                                                Printing.print(2, "Error #" +errorCounter +": this individual appears as a wife in another family");
                                                Printing.PrintIndividualDetails(indArr, i, 4);
                                                Printing.print(2, "Original family is " +indArr[i].FAMS + ". However she was also found in family " + famArr[f].ID);
                                                System.out.print("Original ");
                                                Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 4, indArr, false, false);
                                                manyfam=true;
                                            }
                                            else{
                                                errorCounter++;
                                                Printing.print(2, "Error #" +errorCounter +": Above individual is also found in family " + famArr[f].ID);

                                            }
                                            Printing.PrintFamilyDetails(famArr, f, 4, indArr, false, false);                                        
                                    }

                                }                        
                            }
                       }
                    }
                }
            }
        }
       return errorCounter; 
    }
}

