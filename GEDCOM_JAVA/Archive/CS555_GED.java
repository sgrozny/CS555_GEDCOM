/*
 * "I pledge my honor that I have abided by the Stevens Honor System"
 * Stas Grozny
 */
package cs555_ged;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CS555_GED {
    static int iCounter=-1, fCounter=-1;
    static String TAGS[] = new String [16];
    static individual indArr[] = new individual[5000];
    static family famArr[] = new family[1000];
    public static void main(String[] args) {
        //Reads the lines of a ged file
        //Precondition: The GED file is in the specified location with the proper name
        //Postcondition: The output will print all original GED Lines with the addition of the level number and tag
        
        String  Ged_Filename = "TEST.ged";
         initTagArray(); //Loads in valid tags      
        try {
                //Read file
		File file = new File(Ged_Filename);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
                //While there are lines then call the print method.
                
		while ((line = bufferedReader.readLine()) != null) {
                        Print_Ged_Lines(line);
		}
                
		fileReader.close(); //close file reader
		} 
        //catches any errors
                catch (IOException e) {
			e.printStackTrace();
		}
       for(int i=0;i<iCounter+1;i++){
            System.out.print(indArr[i].getID() + " :  ");
            System.out.println(indArr[i].getName());
       }
       System.out.println("------------------------------");
       System.out.println("Families");
       int w,h;
       for(int i=0;i<fCounter+1;i++){
           System.out.println("Family ID:" +famArr[i].getID());
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           System.out.println("Husband: "+ indArr[h].getName());
           System.out.println("Wife: " + indArr[w].getName());
           System.out.println("~~~~~~~~~~~~~~~~~");
       }
    }
    private static void Print_Ged_Lines(String inputline){
        /*Private Method that will print 3 lines 
        * Precondition: Given a line from a Gedcom file
        * Postcondition: Print the orignal line, print level-number, tag
        */
        //System.out.println(inputline);//Print original line
        int index;  //index of first " "
        int i;// used in for loop
        String lvl;
        String tag;//finds tag
        
        String arguement=""; //holds the arguement of the tag
        boolean valid=false;    // checks if tag is valid (default is false)
        index= inputline.indexOf(" ");  // find index of first space
        lvl=inputline.substring(0,index);   //print the level number
        int index2; // index of second " "
        index2= inputline.indexOf(" ", index+1); 
        if (index2==-1) {//if there is no second space just a tag followed by nothing
            tag=inputline.substring(index+1);//then the end of tag is last character
        }
        else{//else the tag is between the 2 spaces
           tag=inputline.substring(index+1,index2);
           arguement= inputline.substring(index2+1);
        } 
        //Compare obtained tag to list of predefined tags
        for (i=0;i<16;i++){      
            if (tag.equals(TAGS[i])){
                valid=true; //if its found then its a valid tag and no need to keep looking
                break;
            }
        }
        if (valid) {//if tag is valid 
            int w;
            if(lvl.equals("0")&& tag.equals("INDI")){
                iCounter=iCounter+1;
                indArr[iCounter]= new individual();
            }
            else if(lvl.equals("0")&& tag.equals("FAM")){
                fCounter++;
                famArr[fCounter]=new family();
            }
            switch (tag){
                case "INDI":
                    indArr[iCounter].setID(arguement);
                break;
                case "NAME":
                
                    indArr[iCounter].setName(formatName(arguement));
                    break;
                case "FAM":
                    famArr[fCounter].setID(arguement);
                    break;
                case "HUSB":
                     w= findID(arguement);
                    if(w>=0){
                        famArr[fCounter].setHusb(w);
                    }
                 break;
                case "WIFE":
                    w= findID(arguement);
                    if(w>=0){
                        famArr[fCounter].setWife(w);
                    }
                 break;
                default:
                    break;
            }
        }
    }
    private static String formatName(String name){
        //Removes the "/" from the lastnames
        return name.replace("/", "");
    }
    private static int findID(String fID){
        int found=-1;
        for(int i=0;i<iCounter+1;i++){
//             System.out.println(indArr[i].getID());
//             System.out.println(fID);
//             System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            if(indArr[i].getID().equals(fID)){
                return i;
            }

    }
        return found;
    }
     public static void initTagArray(){
         //intializes the array of tags
         //Preconditions: None
         //Postconditions; The TAGS array is populated with all the valid tags
         TAGS[0]="NOTE";
         TAGS[1]="INDI";
         TAGS[2]="NAME";
         TAGS[3]="SEX";
         TAGS[4]="BIRT";
         TAGS[5]="DEAT";
         TAGS[6]="FAMC";
         TAGS[7]="FAMS";
         TAGS[8]="FAM";
         TAGS[9]="MARR";
         TAGS[10]="HUSB";
         TAGS[11]="WIFE";
         TAGS[12]="CHIL";
         TAGS[13]="DIV";
         TAGS[14]="DATE";
         TAGS[15]="TRLR";
                 
     }       
public static class individual{
    String name;
    char gender;
    String BDay;
    String DDay;
    String ID;
    public individual(){   
    }
    public individual(individual A){
        
    }
    public void setName(String pName){
        name=pName;
    }
    public String getName(){
        return name;
    }
    public void setID(String pID){
        ID= pID;
    }
    public String getID(){
        return ID;
    }
    public void setGender(char g){
        gender=g;
    }
    public char getGender(){
        return gender;
    }
    public void setBDay(String pbday){
        BDay=pbday;
    }
       public String getBDay(){
        return BDay;
    }
      public void setDDay(String pdday){
        DDay=pdday;
    }
       public String getDDay(){
        return DDay;
    }
            
}
public static class family{
    String ID;
    int husband;
    int wife;
    public family(){
        
    }
    public void setID(String pID){
        ID=pID;
    }
    public String getID(){
        return ID;
    }
    public void setHusb(int H){
        husband= H;
    }
     public int getHusb(){
        return husband;
    }
     public void setWife(int W){
        wife= W;
    }
     public int getWife(){
        return wife;
    }
}
}
