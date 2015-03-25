/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class IndividualStruct {
    public static class individual{
       String name;
       String gender;
       String BDay;
       String DDay;
       String ID;
       String WhichDate;
       boolean visited;
       //Following should be arrays
       Integer Spouse;
       Integer Child;
       String FAMC;
       String FAMS;
       Integer[] SpouseA;
       Integer[] ChildA;
       String[] FAMCA;
       String[] FAMSA;
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
      public void setGender(String g){
          gender=g;
      }
      public String getGender(){
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
      public void setDate(String DateType){
          WhichDate=DateType;
      }
      public String getDate(){
          return WhichDate;
      }
      public void setSpouse(int spouse){
          Spouse=spouse;
      }
      public void setChild(int child){
          Child= child;
      }
      public Integer getChild(){
          return Child;
      }
      
      
    }  
}
