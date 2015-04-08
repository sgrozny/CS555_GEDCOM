/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class FamilyStruct {
    /**
     *
     */
    public static class family{
        String ID;
        Integer husband;
        Integer wife;
        String MarriedDate;
        String DivDate;
        String WhichDate;
        String childIds[] = new String[30];
        Integer children[] = new Integer[30];
        int numChildren;
        String husbS;
        String wifeS;        
        boolean visited;
        int numcIds;
        /**
         *
         */
        public family(){
            numChildren=0;
            numcIds=0;
        }
        private void setNumChildren(){
            int i=0;
            numChildren=0;
            while(children[i]!=null){
                numChildren++;
                i++;
            }
        }
        /**
         *Gets the number of kids in a family
         * @return The number of children for a given family
         */
        public int getNumChildren(){
            setNumChildren();
            return numChildren;
        }
        /**
         *Set the ID for the Family
         * @param pID the ID number of the family
         */
        public void setID(String pID){
            ID=pID;
        }
        /**
         *
         * @return The Id number of the family
         */
        public String getID(){
            return ID;
        }
        /**
         *
         * @param H
         */
        public void setHusb(int H){
            husband= H;
        }
         /**
         *
         * @return
         */
        public Integer getHusb(){
            return husband;
        }
         /**
         *
         * @param W
         */
        public void setWife(int W){
            wife= W;
        }
         /**
         *
         * @return
         */
        public Integer getWife(){
            return wife;
        }
         /**
         *
         * @param DateType
         */
        public void setDate(String DateType){
            WhichDate=DateType;
        }
        /**
         *
         * @return
         */
        public String getDate(){
            return WhichDate;
        }
        /**
         *
         * @param DateofMarriage
         */
        public void setMarriedDate(String DateofMarriage){
            MarriedDate= DateofMarriage;
        }
        /**
         *
         * @return
         */
        public String getMarriedDate(){
            return MarriedDate;
        }
        /**
         *
         * @param DivorceDate
         */
        public void setDivDate(String DivorceDate){
            DivDate = DivorceDate;
        }
        /**
         *
         * @return
         */
        public String getDivDate(){
            return DivDate ;
        }
        /**
         *
         * @param c
         * @param index
         */
        public void addChild(int c, int index){
            children[index]=c;
        }
        /**
         *
         * @param index
         * @return
         */
        public int getChild(int index){
            if(children[index]!=null){
            return children[index];
            }
            else return -1;
        }
        public void addChildId(String childid,int index){
            childIds[index]=childid;
            numcIds++;
        }
                
//        public boolean hasChild(String cID){
//            getNumChildren();
//            boolean childExists= false;
//            for(int i=0;i<numChildren;i++){
//                if()
//            }
//            return childExists;
//        }
    } 
}
