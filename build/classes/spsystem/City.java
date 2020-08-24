package spsystem;

public class City {

    private int cityid;
    private String cityname;

    
    public City(){}
    
    public City(int Id, String Name){
    
        this.cityid = Id;
        this.cityname = Name;
       
        
       
    }
    
    public int getID(){
      return cityid;
    }
    
    public void setID(int ID){
        this.cityid = ID;
    }
    
    public String getName(){
        return cityname;
    }
    
    public void setName(String Name){
        this.cityname = Name;
    }
    
 
    
   

}
