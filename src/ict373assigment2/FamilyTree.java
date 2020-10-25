 package ict373assigment2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FamilyTree 
{
    //member variables of FmailyTree

    private TreeView<Object> tree;
    private TreeItem<Object> root;
    private TreeItem<Object> mother;
    private TreeItem<Object>father;
    private TreeItem<Object> spouse;
    private TreeItem<Object> child;
    private TreeItem<Object> selectedItem;
    private TreeItem<Object> RelativeType;
    private TreeItem<Object>HeaderParent;
    private TreeItem<Object>HeaderSpouse;
    private TreeItem<Object>HeaderChildren;

    
    //Constructor 
    
     public FamilyTree()
     {
         tree = new TreeView<>();
     }
 
     public void NewTree()
     {
        tree = new TreeView();
     }
     
     public void setSelectedItem(TreeItem<Object> select)
     {
         selectedItem = select;
     }
     
     public void setSelectedItem(Person p)
     {
         selectedItem = new TreeItem<Object>(p);
     }
     public void setRelativeType(String type)
     {
         RelativeType = new TreeItem<Object>(type);
     }
     
     public TreeItem<Object> getRelativeType()
     {
         return RelativeType;
     }
   
     public void assembleTree()
     {
         Person Root = (Person) root.getValue();
         
         if(Root.getMother()!= null)
         {
              setSelectedItem(root);
              setRelativeType("parent");
              findSelectedItem(Root.getMother());
         }
         
         if(Root.getFather()!= null)
         {             
              setSelectedItem(root);
              setRelativeType("parent");
              findSelectedItem(Root.getFather());
         }
         
         if(Root.getSpouse()!= null)
         {           
              setSelectedItem(root);
              setRelativeType("spouse");
              findSelectedItem(Root.getSpouse());
         }
         
         
         if(Root.getChild()!= null)
         {
            setSelectedItem(root);
            setRelativeType("child");
            ArrayList<Person> children = Root.getChildren();
             
              for(Person str: children)
              {
                findSelectedItem(str);
              }
             
               for(Person str: children)
              {
                 assembleRelativeofChildren(str);                
              }            
              
         }
         
     }
     
     public Boolean isHeaderParentExist(TreeItem<Object> chosen)
     {
        Boolean isExist = false;
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                 if(child.equals(HeaderParent))
                 {
                     isExist = true;
                     break;
                 }
            }
        }
        
        return isExist;
        
     }
  
      public Boolean isHeaderSpouseExist(TreeItem<Object> chosen)
     {
        Boolean isExist = false;
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                 if(child.equals(HeaderSpouse))
                 {
                     isExist = true;
                     break;
                 }
            }
        }
        
        return isExist;
        
     }
   
      public Boolean isHeaderChildExist(TreeItem<Object> chosen)
     {
        Boolean isExist = false;
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                String H = (String) child.getValue();
                 if(H.equalsIgnoreCase("children"))
                 {
                     isExist = true;
                     break;
                 }
            }
        }
        return isExist;
        
     }
      
     public void assembleRelativeofChildren(Person p)
     {
         if(p.getSpouse()!= null)
         {
              setSelectedItem(p);
              setRelativeType("Spouse");
              findSelectedItem(p.getSpouse());
         }
         else 
         {
             //do nothing 
         }
         
         if(p.getChild()!= null)
         {
             setSelectedItem(p);
             setRelativeType("child");
             ArrayList<Person> children = p.getChildren();
             for(Person str: children)
            {
                findSelectedItem(str);
            }
         }
         else 
         {
             //do nothing 
         }
         
     }
     
     public void add(TreeItem<Object> chosen,Person p)
     {
                String type = (String)RelativeType.getValue();
                   
                if(chosen.getValue().getClass() == Person.class)
                {
                   if(type.equalsIgnoreCase("mother")|| type.equalsIgnoreCase("father"))
                   {
                      if(isHeaderParentExist(chosen) == false)
                      {
                          setParent("Parent");
                          addParent(chosen);
                      }
                       if(type.equalsIgnoreCase("mother"))
                       {
                          setMother(p);
                          addMother(chosen);
                       }
                       
                       if(type.equalsIgnoreCase("father"))
                       {
                         setFather(p);
                         addFather(chosen);                       
                       }
                   }
                   
                   if(type.equalsIgnoreCase("spouse"))
                   {
                            
                        if(isHeaderSpouseExist(chosen)== false)
                        {   
                            setSpouseHeader("Spouse");
                            addSpouseHeader(chosen);
                        }
                        
                        setSpouse(p);
                        
                        addSpouse(chosen);
                        
                   }
                   
                   if(type.equalsIgnoreCase("child"))
                   {
                       if(isHeaderChildExist(chosen)== false)
                       {  
                           setHeaderChildren("Children");
                           addHeaderChildren(chosen);
                       }
                       
                       setChild(p);
                       addChild(chosen);
                       
                   }
                } 
         
 
     }
     
  
     
     public void findSelectedItem(Person relative)
     {
 
       Person selected = (Person)selectedItem.getValue();
       
       Person rootPerson = (Person) root.getValue();
              
       if(selected.equals(rootPerson))
       {
           add(root,relative);
       }
       else 
       {

        ObservableList<TreeItem<Object>> selectedItems = root.getChildren();
           
         for(TreeItem<Object> item:selectedItems)
        {
            if(item.getValue().getClass()== Person.class)
            {
               Person p = (Person)item.getValue();
               
               if(selected.equals(p))
               {
                  add(item,relative);
                  break;
               }
               else 
               {
                  if(haveChildren(item)== true)
                  {
                     analyzeChildren(item,selected,relative);  
                  }
                  else 
                  {
                      //do nothing 
                  }
               }
            }
            else 
            {
                analyzeChildren(item,selected,relative);
            }
        }
           
       }
     }
        
    public void analyzeChildren(TreeItem<Object> person,Person selected,Person relative)
   {
        ObservableList<TreeItem<Object>> selectedItems = person.getChildren();
        
        for(TreeItem<Object> item:selectedItems)
        {
            if(item.getValue().getClass()== Person.class)
            {
               Person p = (Person)item.getValue();
               
               if(p.equals(selected))
               {
                  add(item,relative);
                  break;
               }
               else 
               {
                  if(haveChildren(item)== true)
                  {
                     analyzeChildren(item,selected,relative);  
                  }
                  else 
                  {
                      //do nothing 
                  }
               }
            }
            else 
            {
                analyzeChildren(item,selected,relative);               
            }
        }
   }

    public Boolean haveChildren(TreeItem<Object>p)
   {
       if(p.getChildren()== null)
       {
           return false;
       }
       else 
       {
           return true;
       }
   }
    
     public void setTree(TreeView<Object> tree) 
     {
        this.tree = tree;   
     }
     
     public TreeView<Object> getTree()
     {
        return tree;
     }
     
    //Set Method 
     
     public void setRoot(Person p)
     {
        root = new TreeItem<>(p);
        root.setExpanded(true);
     }
     
     public TreeItem<Object> getRoot()
     {
        return root;
     }
     
     public void addRoot()
     {
         tree.setRoot(root);
         tree.setShowRoot(true);
     }
          
     public void setParent(String p)
     {
        HeaderParent = new TreeItem<>(p);
     }
     
     public TreeItem<Object> getParent()
     {
         return HeaderParent;
     }
     
     public void addParent(TreeItem<Object> selected)
     {
         selected.getChildren().add(HeaderParent);
     }
     
     public void setMother(Person p)
     {
         mother = new TreeItem<>(p);
     }
     
     public TreeItem<Object> getMother()
     {
         return mother;
     }
     
     public void addMother(TreeItem<Object>chosen)
     {
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                 if(child.equals(HeaderParent))
                 {
                     child.getChildren().add(mother);
                 }
            }
        }
     }

     public void setFather(Person p)
     {
         father = new TreeItem<>(p);   
     }
     
     public TreeItem<Object> getFather()
     {
         return father;
     }
     
     public void addFather(TreeItem<Object> chosen)
     {
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                 if(child.equals(HeaderParent))
                 {
                     child.getChildren().add(father);
                 }
            }
        }
     }
     
     public void setSpouseHeader(String header)
     {
        HeaderSpouse = new TreeItem<>(header);
     }
     
     public void addSpouseHeader(TreeItem<Object> selected)
     {
        selected.getChildren().add(HeaderSpouse);
     }
     
     public TreeItem<Object> getSpouseHeader()
     {
         return HeaderSpouse;
     }
     
     public void setSpouse(Person p)
     {
         spouse = new TreeItem<>(p);
     }
     
     public TreeItem<Object> getSpouse()
     {
         return spouse;
     }
     
     public void addSpouse(TreeItem<Object> chosen)
     {
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                 if(child.equals(HeaderSpouse))
                 {
                     child.getChildren().add(spouse);
                 }
            }
        }
     }
     
     public void setHeaderChildren(String name)
     {
         HeaderChildren = new TreeItem<>(name);
     }
     
     public void addHeaderChildren(TreeItem<Object> selected)
     {
        selected.getChildren().add(HeaderChildren);
     }
              
     public void addChild(TreeItem<Object> chosen)
     {
        ObservableList<TreeItem<Object>> children = chosen.getChildren();
        
        for(TreeItem<Object> child: children)
        {
            if(child.getValue().getClass() == String.class)
            {
                 String H = (String) child.getValue();
                 if(H.equalsIgnoreCase("children"))
                 {
                     child.getChildren().add(this.child);
                 }
            }
        }
     }

     public void assemblingTree()
    {
        Person person = (Person) root.getValue();
    }
     
     public void setChild(Person p)
     {
         child = new TreeItem<>(p);
     }
     
     public TreeItem<Object> getChild()
     {
         return child;
     }
     

}

