package ict373assigment2;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable
{
    private String givenName;
    private String surname;
    private String maidenName;
    private String gender;
    private String biography;
    private Person mother;
    private ArrayList<Person> children;
    private Person father;
    private Person child;
    private Person spouse;
    private Address address;
    
    public Person()
    {
        givenName = "";
        surname   = "";
        maidenName = "";
        gender = "";
        biography ="";
        address = new Address();
        children = new ArrayList<Person>();
    }
    
    public Person(Person p)
    {
        givenName = p.getGivenName();
        surname   = p.getSurname();
        maidenName = p.getMaidenName();
        gender = p.getGender();
        biography = p.getBiography();
        address = p.getAddress();
        children = new ArrayList<Person>();
        
    }
    
    //for testing only 
    public Person(String givenName)
    {
        this.givenName = givenName;
    }
    
    public Person(String givenName,String surname,String maidenName,String gender,String biography,Address address)
    {
        this.givenName = givenName;
        this.surname   = surname;
        this.maidenName = maidenName;
        this.gender = gender;
        this.biography = biography;
        this.address = address;
    }
    
    public Person(String givenName,String surname,String maidenName,String gender,String biography,String streetName,String streetNumber,String postcode,String suburb)
    {
        this.givenName = givenName;
        this.surname   = surname;
        this.maidenName = maidenName;
        this.gender = gender;
        this.biography = biography;
        this.address = new Address(streetNumber,streetName,suburb,postcode);    
        children = new ArrayList<Person>();
    }
    
    public Person(String givenName,String surname,String gender,String streetName,String streetNumber,String suburb, String postcode,String biography)
    {
        this.givenName = givenName;
        this.surname   = surname;
        this.gender = gender;
        this.biography = biography;
        this.address = new Address(streetNumber,streetName,suburb,postcode);    
        children = new ArrayList<Person>();       
    }
   
    public void setGivenName(String name)    
    {
        this.givenName = name;
    }
    
    public String getGivenName()
    {
        return givenName;
    }
    
    public void setSurname(String name)
    {
        this.surname = name;
    }
    
    public String getSurname()
    {
        return this.surname;
    }
    
    public void setMaidenName(String name)
    {
        this.maidenName = name;
    }
    
    public String getMaidenName()
    {
        return this.maidenName;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public void setBiography(String biography)
    {
        this.biography = biography;
    }
    
    public String getBiography()
    {
        return this.biography;
    }
    
    public void setMother(Person p)
    {
       this.mother = p;   
    }
    
    public Person getMother()
    {
        return this.mother;
    }
    
    public void setFather(Person p)
    {
        this.father = p;
    }
    
    public Person getFather()
    {
        return this.father;
    }
    
    public Address getAddress()
    {
        return this.address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    public void setChild(Person p)
    {
        this.child = p;
    }
    
    public Person getChild()
    {
        return this.child;
    }
    
    public Person getSpouse()
    {
        return spouse;
    }
    
    public void setSpouse(Person p)
    {
       this.spouse = p; 
    }
    
    public void setChildren()
    {
       children = new ArrayList<Person>();       
    }
    
    public ArrayList<Person> getChildren()
    {
        return children;
    }
    
    public void addChild(Person p)
    {
        children.add(p);
    }
    
    public void resetChildren()
    {
        children.clear();
    }
    
    public Boolean isMotherExist(Person p)
    {
        if(p.getMother()== null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Boolean isMotherValid(Person p)
    {
        if(p.getGender().equalsIgnoreCase("female"))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public Boolean isFatherExist(Person p)
    {
        if(p.getFather()== null)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    
    public Boolean isSpouseExist(Person p)
    {
        if(p.getSpouse()== null)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    
    public Boolean isSpouseValid(Person person,Person spouse)
    {
        if(person.getGender().equalsIgnoreCase(spouse.getGender()))
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    public Boolean isFatherValid(Person p)
    {
        if(p.getGender().equalsIgnoreCase("MALE"))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
     public void addChildren(Person p)
     {
         children.add(p);
     }
    
    @Override
    public String toString()
    {
        return this.givenName;
    }
}
