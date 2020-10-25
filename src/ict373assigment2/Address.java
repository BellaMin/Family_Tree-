package ict373assigment2;

import java.io.Serializable;


public class Address implements Serializable
{
    
    //decalaration and initiation 
    private String  streetNumber;
    private String  streetName;
    private String suburb;
    private String postcode;
    
    //Constructors 
    
     public Address()
     {
         streetNumber = "";
         streetName = "";
         suburb = "";
         postcode = "";
     }
     
     public Address(String streetNumber,String streetName,String suburb,String postcode)
     {
         this.streetNumber = streetNumber;
         this.streetName = streetName;
         this.suburb = suburb;
         this.postcode = postcode;
     }
     
     //set methods 
     
     public void setStreetNumber(String streetNumber)
     {
         this.streetNumber = streetNumber;
     }
          
     public void setStreetName(String streetName)
     {
         this.streetName = streetName;
     }
       
    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }
        
    public void setPostCode(String postcode)
    {
        this.postcode = postcode;
    }
    
    //get methods 
    
    public String getPostCode()
    {
        return postcode;
    }
    
     public String getStreetNumber()
     {
         return streetNumber;
     }
    
     public String getSuburb()
     {
        return suburb;
     }
  
      public String getStreetName()
     {
        return streetName;
     }
     
   //validatation methods 
      
    public Boolean validatePostCode(String postcode)
    {
        Boolean valid = false;
        if(postcode.length()== 6)
        {
             if(postcode.matches("[0-9]+"))
             {
                valid = true;  
             }
             else 
             {
                valid = false; 
             }
        }
        else 
        {
           valid = false; 
        }
        return valid;
    }
    
    public Boolean validateStreetNumber(String streetNumber)
    {
        Boolean valid = false;
        if(streetNumber.length()>0)
        {
            if(streetNumber.matches("[0-9]+"))
            {
                valid = true;
            }
            else 
            {
                valid = false;
            }
        }
        else 
        {
            valid = false;
        }
        return valid;
    }
    
    public Boolean validateStreetName(String streetName)
    {
        Boolean valid = false;
        if(streetName.length()>0)
        {
            if(streetName.matches("[a-zA-Z]+"))
            {
                valid = true;
            }
            else 
            {
                valid = false;
            }
        }
        else 
        {
            valid = false;
        }
        return valid;
    }
    
    public Boolean validateSuburb(String suburb)
    {
        Boolean valid = false;
        if(suburb.length()>0)
        {
            if(suburb.matches("[a-zA-Z]+"))
            {
                valid = true;
            }
            else 
            {
                valid = false;
            }
        }
        else 
        {
            valid = false;
        }
        return valid;
    }
}
