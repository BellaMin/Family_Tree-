package ict373assigment2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;


public class GUI extends Application  
{

    //Member variables of class GUI 
    private GridPane root;
    private GridPane top;
    private GridPane button;
    private GridPane body;
    private GridPane bottom;
    private Button load;
    private Button cancel;
    private Button save ;
    private Button create;
    private Button add;
    private Button saveChanges;
    private Button ADDrelative;
    private Button edit;
    private Button cancelEdit;
    private Button submit;
    private Button saveNewRelative;
    private ScrollPane subBodyOne;
    private ScrollPane treeContainer;
    private GridPane subBodyTwo;
    private GridPane personalinfo;
    private GridPane editablepersonalinfo;
    private GridPane rootadded;
    private GridPane relative;
    private ScrollPane personalData;
    private FamilyTree f;
    private Stage stage;
    private File currentFile;
    private Button cancelRelative;
    private Person p;//new person created
    private TextArea forname = null;
    private TextArea forMname = null;
    private TextArea forBio = null;
    private TextArea forGender;
    private ComboBox comboBox;
    private TextArea forstreetName = null;
    private TextArea forPostcode = null;
    private TextArea forsuburb = null;
    private TextArea forsurname = null;
    private TextArea forstreetNumber = null;
    private Person person;// person from selected node

        
    //Constructor
        
    public GUI()
    {
        root = new GridPane();
        top = new GridPane();
        button = new GridPane();
        body = new GridPane();
        bottom = new GridPane();
    }
    
    
    public void start(Stage primaryStage) 
    {
          primaryStage.setTitle("Family Tree");
          
          root = new GridPane();
          
          root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
          
          stage = primaryStage;
          
          f = new FamilyTree();
                              
          //Setting all gridPanes 
          
          //Set top 
          
          top = setTop();
          
          //Set Body 
          
          body = setBody();
          
          //set botton 
          
          button = setButton();
          
          //Add top 
          
          root.add(top, 0, 0);
          
          root.add(button, 0, 1);
          
          root.add(body, 0, 2);
          
          //Scence 
          
          Scene Container = new Scene(root);//container 
           
          primaryStage.setScene(Container);
         
          primaryStage.show();
          
    }
    
    public GridPane setTop()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(650, 20);
        
        Label title = title();
        
        test.add(title, 0, 0);
        
        return test;
    }
    
    
    
    public GridPane setBody()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(650,850);
        
        subBodyOne = getSubBodyOne();
        
        subBodyTwo = getSubBodyTwo();
        
        test.add(subBodyOne, 0, 0);
        
        test.add(subBodyTwo, 1, 0);
        
        return test;
    }
    
    public void accept(String[]args)
    {
        launch(args);
    }
      
    public ScrollPane getSubBodyOne()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(325, 850);
        
        Text txt = nodata();
        
        test.add(txt, 0, 0);

        test.setMargin(txt, new Insets(5));
        
        ScrollPane sp = new ScrollPane(test);
        
        sp.setFitToWidth(false);
        
        sp.setFitToHeight(true);
                
        return sp;
    }
    
    public Text nodata()
    {
        Text data = new Text();
        
        data.setText("-No Data Found");
        
        return data;
    }
    
    public GridPane getSubBodyTwo()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(325, 850);
        
        add = getadd();
        
        test.add(add, 0, 0);

        test.setMargin(add, new Insets(5));
        
        Text txt = note();
        
        test.add(txt, 0, 1);
        
        test.setMargin(txt, new Insets(5));
        
        return test;        
    }
    
    public Text note()
    {
        Text txt = new Text();
        
        txt.setText("Load a tree or add a new root person");
        
        txt.setFont(Font.font(20));
        
        txt.setStyle("-fx-font-weight:bold");
        
        return txt;
    }
    
    public Label title()
    {
        Label title = new Label();
        
        title.setText("Welcome to the Family Tree Application");
        
        title.setFont(Font.font(24));
        
        title.setStyle("-fx-font-weight:bold");
        
        return title;
    }
    
    public Button getadd()
    {
        Button add = new Button("Add another root person");

        add.setStyle("-fx-color:lightblue");
        
        add.setPrefSize(150, 50);
        
        add.setOnAction(evtInfo -> displayPersonalinfo(evtInfo));
        
        return add;        
    }
   
   public void displayPersonalinfo(ActionEvent e)
   {
       //set personalinfo
       personalinfo = getPersonalInfo();
       body.add(personalinfo, 1, 0);
   }
   
   public GridPane getPersonalInfo()
   {
         
     GridPane test = new GridPane();
       
     test.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
       
     test.setPrefSize(325, 850);  
     
     Label name = name();
     
     forname = forname();
     
     forname.setPrefHeight(20);

     Label Mname = Mname();
     
     forMname = forMname();

     forMname.setPrefHeight(20);
     
     Label biography = biography();
     
     forBio = forBio();
     
     Label gender = gender();
          
     forGender = forgender();

     forGender.setPrefHeight(20);
     
     Label streetName = streetName();
     
     forstreetName = forstreetName();

     forstreetName.setPrefHeight(20);
     
     Label postcode = PostCode();
     
     forPostcode = forPostCode();

     forPostcode.setPrefHeight(20);
     
     Label suburb = suburb();
     
     forsuburb = forSuburb();

     forsuburb.setPrefHeight(20);
     
     Label number = StreetNumber();
     
     forstreetNumber = forStreetNumber();

     forstreetNumber.setPrefHeight(20);
     
     Label surname = Surname();
     
     forsurname = forSurname();
     
    cancel = getCancelAddroot();
    
    forsurname.setPrefHeight(20);
     
    submit = getSubmit();
         
    test.add(name, 0, 1);
    
    test.add(forname, 1, 1);
    
    test.add(surname, 0, 2);
    
    test.add(forsurname, 1, 2);
    
    test.add(Mname, 0, 3);
   
    test.add(forMname, 1, 3);
    
    test.add(gender, 0, 4);
    
    test.add(forGender, 1, 4);
    
    test.add(biography, 0, 5);
    
    test.add(forBio, 1, 5);
    
    test.add(streetName, 0, 6);
    
    test.add(forstreetName, 1, 6);
    
    test.add(number, 0, 7);
    
    test.add(forstreetNumber, 1, 7);
    
    test.add(suburb, 0, 8);
    
    test.add(forsuburb, 1, 8);
    
    test.add(postcode, 0, 9);
    
    test.add(forPostcode, 1, 9);
       
    test.add(cancel, 0, 10);
    
    test.add(submit, 1, 10);
    
    return test;

   }
   
    public Button getCancelAddroot()
    {
        Button add = new Button("Cancel");

        add.setStyle("-fx-color:lightblue");
        
        add.setPrefSize(150, 70);
        
               
        add.setOnAction(evtInfo -> cancelRoot(evtInfo));
        
        return add;        
    }
   
    public void cancelRoot(ActionEvent evt)
    {
          body.getChildren().remove(personalinfo);  
          
          subBodyTwo = getSubBodyTwo();
          
          body.add(subBodyTwo, 1, 0);
          
    }   
   
   public GridPane getRelative()
   {
     GridPane relative = new GridPane();
       
     relative.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
       
     relative.setPrefSize(325, 850);  
     
     ObservableList<String> options = FXCollections.observableArrayList(
        "Mother",
        "Father",
        "Child",
        "Spouse"
    );

     comboBox = new ComboBox(options);
     
     Label name = name();
     
     forname = forname();
     
     forname.setPrefHeight(20);

     Label Mname = Mname();
     
     forMname = forMname();

     forMname.setPrefHeight(20);
     
     Label biography = biography();
     
     forBio = forBio();
     
     Label gender = gender();
          
     forGender = forgender();

     forGender.setPrefHeight(20);
     
     Label streetName = streetName();
     
     forstreetName = forstreetName();

     forstreetName.setPrefHeight(20);
     
     Label postcode = PostCode();
     
     forPostcode = forPostCode();

     forPostcode.setPrefHeight(20);
     
     Label suburb = suburb();
     
     forsuburb = forSuburb();

     forsuburb.setPrefHeight(20);
     
     Label number = StreetNumber();
     
     forstreetNumber = forStreetNumber();

     forstreetNumber.setPrefHeight(20);
     
     Label surname = Surname();
     
     forsurname = forSurname();
     
     cancelRelative = getCancelRelative();
    
     forsurname.setPrefHeight(20);
     
    saveNewRelative = getSaveRelative();
     
    relative.add(comboBox, 0, 0);
    
    relative.add(name, 0, 1);
    
    relative.add(forname, 1, 1);
    
    relative.add(surname, 0, 2);
    
    relative.add(forsurname, 1, 2);
    
    relative.add(Mname, 0, 3);
   
    relative.add(forMname, 1, 3);
    
    relative.add(gender, 0, 4);
    
    relative.add(forGender, 1, 4);
    
    relative.add(biography, 0, 5);
    
    relative.add(forBio, 1, 5);
    
    relative.add(streetName, 0, 6);
    
    relative.add(forstreetName, 1, 6);
    
    relative.add(number, 0, 7);
    
    relative.add(forstreetNumber, 1, 7);
    
    relative.add(suburb, 0, 8);
    
    relative.add(forsuburb, 1, 8);
    
    relative.add(postcode, 0, 9);
    
    relative.add(forPostcode, 1, 9);
       
    relative.add(cancelRelative, 0, 10);
    
    relative.add(saveNewRelative, 1, 10);
    
    return relative;
       
   }
 
    public Button getSaveRelative()
    {
        Button add = new Button("Save");

        add.setStyle("-fx-color:lightblue");
        
        add.setPrefSize(150, 50);
        
        add.setOnAction(evtInfo -> SaveAddedRelatives(evtInfo));
        
        return add;        
    }
   
     public Button getCancelRelative()
    {
        Button add = new Button("Cancel");

        add.setStyle("-fx-color:lightblue");
        
        add.setPrefSize(150, 50);
        
        add.setOnAction(evtInfo -> cancellation(evtInfo));
        
        return add;        
    }
   
   public void cancellation(Event evt)
   {
        rootadded = getrootadded();
        if(body.getChildren().contains(personalinfo) == true)
        {
            body.getChildren().remove(personalinfo);           
        }

        if(body.getChildren().contains(subBodyTwo) == true)
        {
            body.getChildren().remove(subBodyTwo);           
        }
        body.add(rootadded, 1, 0);
   }

    public void added()
   {
        
        if(body.getChildren().contains(personalinfo) == true)
        {
            body.getChildren().remove(personalinfo);           
        }

        if(body.getChildren().contains(subBodyTwo) == true)
        {
            body.getChildren().remove(subBodyTwo);           
        }
        
        if(body.getChildren().contains(relative) == true)
        {
           body.getChildren().remove(relative);
        }
        
        body.add(getrelativeadded(), 1, 0);
   }
   
   public void setPersonalData(Person p)
   {
       GridPane test = new GridPane();

       test.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
       
       test.setPrefSize(325, 850);
       
      Label name = name();
     
     forname = forPname(p);
     
     forname.setPrefHeight(20);

     Label Mname = Mname();
     
     forMname = forPMname(p);

     forMname.setPrefHeight(20);
     
     Label biography = biography();
     
     forBio = forPBio(p);
     
     Label gender = gender();
          
     forGender = forPgender(p);

     forGender.setPrefHeight(20);
     
     Label streetName = streetName();
     
     forstreetName = forPstreetName(p);

     forstreetName.setPrefHeight(20);
     
     Label postcode = PostCode();
     
     forPostcode = forPPostCode(p);

     forPostcode.setPrefHeight(20);
     
     Label suburb = suburb();
     
     forsuburb = forPSuburb(p);

     forsuburb.setPrefHeight(20);
     
     Label number = StreetNumber();
     
     forstreetNumber = forPStreetNumber(p);

     forstreetNumber.setPrefHeight(20);
     
     Label surname = Surname();
     
    forsurname = forPSurname(p);
         
    forsurname.setPrefHeight(20);
     
    edit = getedit();
        
    ADDrelative = getADD();
    
    Label Mother = Mother();

    Label Father = Father();

    Label Spouse = Spouse();

    Label Children = Child();

    TextArea forMother = forMother(p);    
    
    forMother.setPrefHeight(20);
    
    TextArea forFather = forFather(p);
    
    forFather.setPrefHeight(20);
    
    TextArea forSpouse = forSpouse(p);
    
    forSpouse.setPrefHeight(20);
    
    TextArea forChildren = forChildren(p);
    
    forChildren.setPrefHeight(20);
    
    test.add(name, 0, 1);
    
    test.add(forname, 1, 1);
    
    test.add(surname, 0, 2);
    
    test.add(forsurname, 1, 2);
    
    test.add(Mname, 0, 3);
   
    test.add(forMname, 1, 3);
    
    test.add(gender, 0, 4);
    
    test.add(forGender, 1, 4);
    
    test.add(biography, 0, 5);
    
    test.add(forBio, 1, 5);
    
    test.add(streetName, 0, 6);
    
    test.add(forstreetName, 1, 6);
    
    test.add(number, 0, 7);
    
    test.add(forstreetNumber, 1, 7);
    
    test.add(suburb, 0, 8);
    
    test.add(forsuburb, 1, 8);
    
    test.add(postcode, 0, 9);
    
    test.add(forPostcode, 1, 9);
    
  test.add(Mother, 0, 10);
        
    test.add(forMother, 1, 10);
    
    test.add(Father, 0, 11);
        
    test.add(forFather, 1, 11);
    
    test.add(Spouse, 0, 12);
        
    test.add(forSpouse, 1, 12);
    
    test.add(Children, 0, 13);
        
    test.add(forChildren, 1, 13);
    
    test.add(edit, 0, 14);
    
    test.add(ADDrelative, 1, 14);
       
    ScrollPane t = new ScrollPane(test);
   
    t.setFitToHeight(false);
   
    personalData = t;
        
   }

    public void setEditPersonalData(Person p)
   {
     GridPane test = new GridPane();

     test.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
       
     test.setPrefSize(325, 850);
       
     Label name = name();
     
     forname = forEditPname(p);
     
     forname.setPrefHeight(20);

     Label Mname = Mname();
     
     forMname = forEditPMname(p);

     forMname.setPrefHeight(20);
     
     Label biography = biography();
     
     forBio = forEditPBio(p);
     
     Label gender = gender();
          
     forGender = forEditPgender(p);

     forGender.setPrefHeight(20);
     
     Label streetName = streetName();
     
     forstreetName = forEditPstreetName(p);

     forstreetName.setPrefHeight(20);
     
     Label postcode = PostCode();
     
     forPostcode = forEditPPostCode(p);

     forPostcode.setPrefHeight(20);
     
     Label suburb = suburb();
     
     forsuburb = forEditPSuburb(p);

     forsuburb.setPrefHeight(20);
     
     Label number = StreetNumber();
     
     forstreetNumber = forEditPStreetNumber(p);

     forstreetNumber.setPrefHeight(20);
     
     Label surname = Surname();
     
    forsurname = forEditPSurname(p);
         
    forsurname.setPrefHeight(20);
     
    saveChanges = getSaveChanges();
        
    cancelEdit = getCancel();
         
    test.add(name, 0, 1);
    
    test.add(forname, 1, 1);
    
    test.add(surname, 0, 2);
    
    test.add(forsurname, 1, 2);
    
    test.add(Mname, 0, 3);
   
    test.add(forMname, 1, 3);
    
    test.add(gender, 0, 4);
    
    test.add(forGender, 1, 4);
    
    test.add(biography, 0, 5);
    
    test.add(forBio, 1, 5);
    
    test.add(streetName, 0, 6);
    
    test.add(forstreetName, 1, 6);
    
    test.add(number, 0, 7);
    
    test.add(forstreetNumber, 1, 7);
    
    test.add(suburb, 0, 8);
    
    test.add(forsuburb, 1, 8);
    
    test.add(postcode, 0, 9);
    
    test.add(forPostcode, 1, 9);
       
    test.add(saveChanges, 0, 10);
    
    test.add(cancelEdit, 1, 10);
       
    editablepersonalinfo = test;
   }
    
    public void canceledit(ActionEvent evt)
    {
          body.getChildren().remove(editablepersonalinfo);  
          
          setPersonalData(person);
          
          body.add(personalData, 1, 0);
          
    }
    
    public Label gender()
   {
       Label gender = new Label();
       
       gender.setText("Gender");
       
       gender.setFont(Font.font(15));
       
       return gender;
   }
 
   public Label Mother()
   {
       Label monther = new Label();
       
       monther.setText("Mother");
       
       monther.setFont(Font.font(15));
       
       return monther;
   }
   
    public Label Father()
   {
       Label Father = new Label();
       
       Father.setText("Father");
       
       Father.setFont(Font.font(15));
       
       return Father;
   }

    public Label Spouse()
   {
       Label Spouse = new Label();
       
       Spouse.setText("Spouse");
       
       Spouse.setFont(Font.font(15));
       
       return Spouse;
   }
 
    public Label Child()
   {
       Label Child = new Label();
       
       Child.setText("Child/Children");
       
       Child.setFont(Font.font(15));
       
       return Child;
   }
    
    public Label biography()
   {
       Label bio = new Label();
       
       bio.setText("Life Description");
       
       bio.setFont(Font.font(15));
       
       return bio;
   }

    public Label streetName()
   {
       Label bio = new Label();
       
       bio.setText("Street Name");
       
       bio.setFont(Font.font(15));
       
       return bio;
   }
     
    public TextArea forgender()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(20);

       ta.setEditable(true);
       
       return ta;
   }
    
    public TextArea forMother(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(20);

       if(p.getMother()!= null)
       {
         ta.setText(p.getMother().getGivenName());
       }
       else 
       {
         ta.setText("Null");          
       }
       
       ta.setEditable(false);
       
       return ta;
   }
    
    public TextArea forFather(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(20);

       if(p.getFather()!= null)     
       {
        ta.setText(p.getFather().getGivenName());
       }
       else 
       {
         ta.setText("Null");        
       }
       ta.setEditable(false);
       
       return ta;
   }
   
    public TextArea forSpouse(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(20);

       if(p.getSpouse()!= null)
       {
          ta.setText(p.getSpouse().getGivenName());
       }
       else 
       {
           ta.setText("Null");  
       }
       ta.setEditable(false);
       
       return ta;
   }
    
    public TextArea forPgender(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);

       ta.setEditable(false);
       
       ta.setText(p.getGender());
       
       return ta;
   }
 
   public TextArea forEditPgender(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);

       ta.setEditable(true);
       
       ta.setText(p.getGender());
       
       return ta;
   }
    
     public Label suburb()
   {
       Label bio = new Label();
       
       bio.setText("Suburb");
       
       bio.setFont(Font.font(15));
       
       return bio;
   }
     
    public TextArea forSuburb()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       return ta;
   }
 
    public TextArea forPSuburb(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(false);
       
       ta.setText(p.getAddress().getSuburb());
       
       return ta;
   }
 
    public TextArea forEditPSuburb(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getAddress().getSuburb());
       
       return ta;
   }
    
   public Label PostCode()
   {
       Label postcode = new Label();
       
       postcode.setText("Postcode");
       
       postcode.setFont(Font.font(15));
       
       return postcode;
   }
     
    public TextArea forPostCode()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       return ta;
   }

   public TextArea forPPostCode(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
                     
       ta.setEditable(false);
       
       ta.setText(p.getAddress().getPostCode());
       
       return ta;
   }
  
    public TextArea forEditPPostCode(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getAddress().getPostCode());
       
       return ta;
   }
   
    public TextArea forstreetName()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       return ta;
   }
 
    public TextArea forPstreetName(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(false);
       
       ta.setText(p.getAddress().getStreetName());
       
       return ta;
   }   
  
    public TextArea forEditPstreetName(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getAddress().getStreetName());
       
       return ta;
   }  
    
    public TextArea forBio()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);

       return ta;
   }

    public TextArea forChildren(Person p)
   {
       TextArea ta = new TextArea();
       if(p.getChild()!= null)
       {
       String ch = "";
       
       ta.setPrefWidth(200);

       ArrayList<Person> children = p.getChildren();
       
       for(Person str :children)
       {
           ch += str.getGivenName() + "\n";
       }
       
       ta.setText(ch);
       }
       else 
       {
           ta.setText("Null");  
       }
       
       ta.setPrefWidth(20);
       
       ta.setEditable(false);
       
       return ta;
   }
    
    public TextArea forPBio(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setPrefHeight(100);
       
       ta.setEditable(false);
       
       ta.setText(p.getBiography());
       
       return ta;
   }
 
    public TextArea forEditPBio(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setPrefHeight(100);
       
       ta.setEditable(true);
       
       ta.setText(p.getBiography());
       
       return ta;
   }
    
   public TextArea forMname()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setPrefHeight(100);
       
       return ta;
   }
   
   public Label Mname()
   {
       Label name = new Label();
       
       name.setText("Maiden Name");
       
       name.setFont(Font.font(15));
       
       return name;
   }
    
   public Label name()
   {
       Label name = new Label();
       
       name.setText("Name");
       
       name.setFont(Font.font(15));
       
       return name;
   }

      public Label Surname()
   {
       Label name = new Label();
       
       name.setText("Surname");
       
       name.setFont(Font.font(15));
       
       return name;
   }
 
    public Label StreetNumber()
   {
       Label name = new Label();
       
       name.setText("Street Number");
       
       name.setFont(Font.font(15));
       
       return name;
   }
      
   public TextArea forname()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       return ta;
   }

    public TextArea forSurname()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       return ta;
   }
 
    public TextArea forStreetNumber()
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       return ta;
   }

   public Text nodetwo()
   {
       Text txt = new Text();
       
       txt.setText("Personal Info");
       
       txt.setFont(Font.font(24));
       
       txt.setStyle("-fx-font-weight:bold");
       
       return txt;       
   }
  
    public Text nodeThree()
   {
       Text txt = new Text();
       
       txt.setText("Address Info");
       
       txt.setFont(Font.font(24));
       
       txt.setStyle("-fx-font-weight:bold");
       
       return txt;       
   }
   
    public GridPane setButton()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(650, 50);
        
        load = getload();
                
        save = getsave();
                
        create = getcreate();
        
        test.add(load, 0, 0);
        
        test.add(save, 1, 0);
        
        test.add(create, 2, 0);
        
        test.setMargin(load, new Insets(5));
        
        test.setMargin(save, new Insets(5));
        
        test.setMargin(create, new Insets(5));
        
        return test;
    }
    
    public Button getload()
    {
        Button load = new Button("Load Tree");
        
        load.setStyle("-fx-color:lightblue");
        
        load.setPrefSize(150, 70);
        
        load.setOnAction(value -> loadTheFile(value));
        
        return load;
    }
     
    public Button getsave()
    {
        Button save = new Button("Save Tree");
        
        save.setStyle("-fx-color:lightblue");
        
        save.setPrefSize(150, 70);
        
        save.setOnAction(value -> saveTheTree(value));
        
        return save;
    }
    
    public Button getcreate()
    {
        Button create = new Button("Create New Tree");
        
        create.setStyle("-fx-color:lightblue");
        
        create.setPrefSize(150, 70);
        
        create.setOnAction(value -> resetANewTree(value));
        
        return create;
    }
 
    public void resetANewTree(ActionEvent evt)
    {
        //to reset the new tree in FamilyTree
        f.NewTree();
        if(body.getChildren().contains(subBodyOne) == true)
        {
           body.getChildren().remove(subBodyOne);
           body.add(subBodyOne, 0, 0);       
        }
        else 
        {
           body.add(subBodyOne, 0, 0);            
        }
        
        if(body.getChildren().contains(subBodyTwo) == true)
        {
            body.getChildren().remove(subBodyTwo);
            body.add(subBodyTwo, 1, 0); 
        }
        else
        {
            body.add(subBodyTwo, 1, 0); 
        }
    }
    
    
     public Button getADD()
    {
        Button create = new Button("Add Relative");
        
        create.setStyle("-fx-color:lightblue");
        
        create.setPrefSize(150, 70);
        
        create.setOnAction(value -> AddRelatives(value));
        
        return create;
    }
  
     public Button getedit()
    {
        Button create = new Button("Edit Details");
        
        create.setStyle("-fx-color:lightblue");
        
        create.setPrefSize(150, 70);
        
        create.setOnAction(value -> editMode(value));
        
        return create;
    }
  

    
     public Button getSubmit()
    {
        Button create = new Button("Submit");
        
        create.setStyle("-fx-color:lightblue");
        
        create.setPrefSize(150, 70);
        
        create.setOnAction(evtInfo -> Submit(evtInfo));
        
        return create;
    }
 
     public Button getSaveChanges()
    {
        Button create = new Button("Save");
        
        create.setStyle("-fx-color:lightblue");
        
        create.setPrefSize(150, 70);
        
        create.setOnAction(evtInfo -> UpdatePersonalInfo(evtInfo));
        
        return create;
    }

     public Button getCancel()
    {
        Button create = new Button("Cancel");
        
        create.setStyle("-fx-color:lightblue");
        
        create.setPrefSize(150, 70);
        
        create.setOnAction(value -> canceledit(value));
        
        return create;
    }
    
     public String getValidatedStreetNumber()
     {
           if(forstreetNumber.getText().length()<1)
           {
               return "NULL";
           }
           else 
           {              
              return forstreetNumber.getText();
           }
     }
     public String getValidatedSuburb()
     {
         if(forsuburb.getText().length()<1)
         {
             return "NULL";
         }
         else 
         {
             return forsuburb.getText();
         }
     }
     
     public String getValidatedPostCode()
     {
          if(forPostcode.getText().length()<1)
          {
              return "NULL";
          }
          else 
          {
              return forPostcode.getText();
          }
     }
     
     public String getValidatedStreetName()
     {
         if(forstreetName.getText().length()<1)
         {
             return "NULL";
         }
         else 
         {
            return forstreetName.getText();
         }
     }
     public String getValidatedBio()
     {
         if(forBio.getText().length()<1)
         {
             return "NULL";
         }
         else 
         {
             return forBio.getText();
         }
     }
     public String getValidatedSurnName()
     {
          if(forsurname.getText().length()<1)
          {
               return "NULL";
          }
          else 
          {
               return forsurname.getText();
          }
     }
     
     public String getValidatedMName()
     {
         if(forMname.getText().length() < 1)
         {
             return "NULL";
         }
         else 
         {
             return forMname.getText();
         }
     }
 
    public GridPane getrootadded()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(325, 850);
        
        Text txt = note3();
        
        test.add(txt, 0, 0);
        
        test.setMargin(txt, new Insets(5));
        
        return test;        
    }
  
      public GridPane getrelativeadded()
    {
        GridPane test = new GridPane();
        
        test.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        test.setPrefSize(325, 850);
        
        Text txt = note4();
        
        test.add(txt, 0, 0);
        
        test.setMargin(txt, new Insets(5));
        
        return test;        
    }
    
    public Text note3()
    {
        Text txt = new Text();
        
        txt.setText("The person is added \n and you may continue \n to add person's relatives");
        
        txt.setFont(Font.font(20));
        
        txt.setStyle("-fx-font-weight:bold");
        
        return txt;
    }
   
      public Text note4()
    {
        Text txt = new Text();
        
        txt.setText("A relative is added\n Please continue");
        
        txt.setFont(Font.font(20));
        
        txt.setStyle("-fx-font-weight:bold");
        
        return txt;
    }
    
     
   public TextArea forPname(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(false);
       
       ta.setText(p.getGivenName());
       
       return ta;
   }

    public TextArea forPSurname(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(false);
       
       ta.setText(p.getSurname());
       
       return ta;
   }
 
    public TextArea forPStreetNumber(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(false);
       
       ta.setText(p.getAddress().getStreetNumber());
       
       return ta;
   }
   
    public TextArea forPMname(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(false);
       
       ta.setText(p.getMaidenName());
       
       return ta;
   }
    
     public TextArea forEditPname(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getGivenName());
       
       return ta;
   }

    public TextArea forEditPSurname(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getSurname());
       
       return ta;
   }
 
    public TextArea forEditPStreetNumber(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getAddress().getStreetNumber());
       
       return ta;
   }
   
    public TextArea forEditPMname(Person p)
   {
       TextArea ta = new TextArea();
       
       ta.setPrefWidth(200);
       
       ta.setEditable(true);
       
       ta.setText(p.getMaidenName());
       
       return ta;
   }
    
     public void editMode(Event e)
    {
            
            if(body.getChildren().contains(editablepersonalinfo) == false)
            {
                body.getChildren().remove(personalData);
                
                setEditPersonalData(person);
                
                body.add(editablepersonalinfo, 1, 0);
                                
            }
            else 
            {
                body.getChildren().remove(editablepersonalinfo);
                
                setEditPersonalData(person);
                
                 body.add(editablepersonalinfo, 1, 0);
                
            }
        
    }
    

    
    public void saveTheTree(ActionEvent evt)
    {
        if(f.getRoot()!= null)   
        {
         
         FileChooser fil_chooser = new FileChooser();
         
         fil_chooser.setInitialFileName("FamilyTree.ft");
                  
         File file = fil_chooser.showSaveDialog(stage); 
  
         if (file != null) 
         { 
            saveToFile(file);
         }

        }
        else 
        {
            //do nothing 
        }
    }
    
      private void saveToFile(File file) 
      {
        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            //set the output streams 
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            //write the object to the file

               Person p = (Person) f.getRoot().getValue();
               if(p != null)
               {
                 out.writeObject(p);
               }
               
            out.close();
            currentFile = file;
        }

        catch (Exception ex) 
        {
            throw new IllegalArgumentException("File could not be saved");
        }
    }
    
    public void loadTheFile(ActionEvent evt)
    {
        FileChooser fil_chooser = new FileChooser();   
        
        File file = fil_chooser.showOpenDialog(stage); 
  
         if (file != null) 
         { 
            loadData(file);
         }
                 
    }
    
    public void loadData(File file)
    {
        // read the object from file
        FileInputStream fis = null;
        ObjectInputStream in = null;

        Person mainPerson = new Person();
        
   try 
       {
            //set the input streams 
            fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            //try to assign the object
            mainPerson = (Person) in.readObject();
            
            in.close();

            f.NewTree();
            
            f.setRoot(mainPerson);
            
            f.addRoot();
            
            f.assembleTree();
            
            UpdateTreeView();
            
            currentFile = file;

        } 
    catch (Exception ex) 
        {
            throw new IllegalArgumentException("File could not be read.");
        } 
    }
    

    
    
    public void UpdatePersonalInfo(Event e)
    {
        
        if(!forsuburb.getText().equalsIgnoreCase(null))
        {
        if(!person.getAddress().getSuburb().equalsIgnoreCase(forsuburb.getText()))
        {
           person.getAddress().setSuburb(forsuburb.getText());
        }
        }
        else 
        {
           person.getAddress().setSuburb("null");         
        }
        
        if(!forPostcode.getText().equalsIgnoreCase(null))
        {
        if(!person.getAddress().getPostCode().equalsIgnoreCase(forPostcode.getText()))
        {
            person.getAddress().setPostCode(forPostcode.getText());
        }
        }
        else 
        {
            person.getAddress().setPostCode("null");           
        }
        
        if(!forstreetNumber.getText().equalsIgnoreCase(null))
        {
        if(!person.getAddress().getStreetNumber().equalsIgnoreCase(forstreetNumber.getText()))
        {
           person.getAddress().setStreetNumber(forstreetNumber.getText());
        }
        }
        else 
        {
           person.getAddress().setStreetNumber("null");
        }
        
        if(!forstreetName.getText().equalsIgnoreCase(null))
        {
        if(!person.getAddress().getStreetName().equalsIgnoreCase(forstreetName.getText()))
        {
             person.getAddress().setStreetName(forstreetName.getText());
        }
        }
        else 
        {
            person.getAddress().setStreetName("null");
        }
        
         if(!forname.getText().equalsIgnoreCase(null))
         {
         if(!person.getGivenName().equalsIgnoreCase(forname.getText()))
         {
             person.setGivenName(forname.getText());
         }
         }
         else 
         {
            person.setGivenName("null");
         }
         
         if(!forsurname.getText().equalsIgnoreCase(null))
         {
         if(!person.getSurname().equalsIgnoreCase(forsurname.getText()))
         {
             person.setSurname(forsurname.getText());
         }
         }
         else 
         {
            person.setSurname("null");
         }
         
         if(forGender.getText().equalsIgnoreCase("female"))
         {
         if(!forMname.getText().equalsIgnoreCase(null))
         {
         if(!person.getMaidenName().equalsIgnoreCase(forMname.getText()))
         {
             person.setMaidenName(forMname.getText());
         }
         }
         else 
         {
             person.setMaidenName("null");
         }
         }
         
         if(!forBio.getText().equalsIgnoreCase(null))
         {
         if(!person.getBiography().equalsIgnoreCase(forBio.getText()))
         {
             person.setBiography(forBio.getText());
         }
         } 
         else 
         {
             person.setBiography("null");
         }
         
         if(!forGender.getText().equalsIgnoreCase(null))
         {
         if(!person.getGender().equalsIgnoreCase(forGender.getText()))
         {
             person.setGender(forGender.getText());
         }
         }
         else 
         {
            person.setGender("null");
         }
         body.getChildren().remove(editablepersonalinfo);
         setPersonalData(person);
         body.add(personalData, 1, 0);
    }
  
    public void AddRelatives(ActionEvent e)
   {
       if(body.getChildren().contains(personalData)== true)
       {
           body.getChildren().remove(personalData);
           relative = getRelative();
           body.add(relative, 1, 0);
       }
       
   }
    
     public void SaveAddedRelatives(ActionEvent e)
     {
        if(comboBox.getValue()!= null)
       {
         
         String maidenName = getValidatedMName() ;
         String surname = getValidatedSurnName();
         String bio = getValidatedBio();
         String choice = comboBox.getValue().toString();
         String streetName = getValidatedStreetName();
         String postcode = getValidatedPostCode();
         String suburb = getValidatedSuburb();
         String streetNumber = getValidatedSuburb();
         
        if(forname.getText().length() > 1 && forGender.getText().length()>1 && choice.length()>1)
        {
               added();
               
               f.setRelativeType(choice);
            
               f.setSelectedItem(person);
            
               if(choice.equalsIgnoreCase("mother"))
               {
                   if(person.isMotherExist(person)== false)
                   {
                       p = new Person(forname.getText(), surname, maidenName,forGender.getText(), streetName, streetNumber, suburb, postcode, bio) ;
                       
                       if(person.isMotherValid(p)== true)
                       {
                           person.setMother(p);
                           p.setChild(person);
                           p.addChildren(person);
                           if(person.getFather()!= null)
                           {
                               p.setSpouse(person.getFather());
                               person.getFather().setSpouse(p);
                               p.setSurname(person.getFather().getSurname());
                           }
                           f.findSelectedItem(p);
                       }
                       else 
                       {
                          //do nothing 
                       }
                   }
                   else 
                   {
                       //do nothing 
                   }
               }
               
                
               if(choice.equalsIgnoreCase("father"))
               {
                   
                   if(person.isFatherExist(person)== false)
                   {
                       p = new Person(forname.getText(), surname,forGender.getText(), streetName, streetNumber, suburb, postcode, bio);
                       if(person.isFatherValid(p)== true)
                       {
                           person.setFather(p);
                           p.setChild(person);
                           p.addChildren(person);
                           if(person.getMother()!= null)
                           {
                               p.setSpouse(person.getMother());
                               person.getMother().setSpouse(p);
                               person.getMother().setSurname(surname);
                           }
                           if(!surname.equalsIgnoreCase(""))
                           {
                               person.setMaidenName(surname);
                           }
                           f.findSelectedItem(p);
                       }
                       else 
                       {
                          //do nothing 
                       }
                   }
                   else 
                   {
                      //do nothing 
                   }
                   
               }
               
               if(choice.equalsIgnoreCase("Spouse"))
               {
                    if(person.isSpouseExist(person)== false)
                    {                        
                        if(forGender.getText().equalsIgnoreCase("female"))
                        {
                           p = new Person(forname.getText(), surname, maidenName,forGender.getText(), streetName, streetNumber, suburb, postcode, bio);
                           if(person.getSurname()!=null)
                           {
                             p.setSurname(person.getSurname());
                           }
                           if(person.getChild()!= null)
                           {
                               ArrayList<Person> children = person.getChildren();
                               for(Person ch:children)
                               {
                                   p.setChild(ch);
                                   ch.setMother(p);
                                   p.addChildren(ch);
                               }
                           }
                        }
                            
                        if(forGender.getText().equalsIgnoreCase("male"))
                        {
                           p = new Person(forname.getText(), surname, forGender.getText(), streetName, streetNumber, suburb, postcode, bio);
                           if(!surname.equals(""))
                           {
                               person.setSurname(surname);
                           }
                           if(person.getChild()!= null)
                           {
                               ArrayList<Person> children = person.getChildren();
                               for(Person ch:children)
                               {
                                   p.setChild(ch);
                                   p.addChildren(ch);
                                   ch.setFather(p);
                                   if(ch.getGender().equalsIgnoreCase("female"))
                                   {
                                       ch.setMaidenName(p.getSurname());
                                   }
                                   else
                                   {
                                       ch.setSurname(p.getSurname());
                                   }
                               }
                           }
                        }
                        
                        if(person.isSpouseValid(person, p) == true)
                        {
                                person.setSpouse(p);
                                p.setSpouse(person);
                                f.findSelectedItem(p);
                        }
                        else 
                        {
                            //do nothing 
                        }
                    }
                    else 
                    {
                        //do nothing 
                    }
                    
               }
              
               if(choice.equalsIgnoreCase("child"))
               {
                    if(forGender.getText().equalsIgnoreCase("female"))
                    {
                        p = new Person(forname.getText(), surname, maidenName,forGender.getText(), streetName, streetNumber, suburb, postcode, bio) ;
                        person.setChild(p);
                        if(person.getGender().equalsIgnoreCase("female"))
                        {
                            p.setMother(person);
                            if(person.getSpouse()!= null)
                            {
                              p.setFather(person.getSpouse());
                              person.getSpouse().setChild(p);
                              person.getSpouse().addChildren(p);
                              p.setMaidenName(person.getSpouse().getSurname());
                            }
                        }
                        
                        if(person.getGender().equalsIgnoreCase("male"))
                        {
                           p.setFather(person);
                           if(person.getSpouse()!=null)
                           {
                           p.setMother(person.getSpouse());
                           person.getSpouse().setChild(p);
                           person.getSpouse().addChildren(p);
                           p.setMaidenName(person.getSurname());
                           }
                        }

                        person.addChildren(p);
                        
                        f.findSelectedItem(p);
                    }
                            
                    if(forGender.getText().equalsIgnoreCase("male"))
                    {
                        p = new Person(forname.getText(), surname, forGender.getText(), streetName, streetNumber, suburb, postcode, bio) ;
                        person.setChild(p);
                        if(person.getGender().equalsIgnoreCase("female"))
                        {
                            p.setMother(person);
                            if(person.getSpouse()!=null)
                            {
                              p.setFather(person.getSpouse());
                              person.getSpouse().setChild(p);
                              person.getSpouse().addChildren(p);
                              p.setSurname(person.getSpouse().getSurname());
                            }
                        }
                        
                        if(person.getGender().equalsIgnoreCase("male"))
                        {
                           p.setFather(person);
                           if(person.getSpouse()!=null)
                           {
                             p.setMother(person.getSpouse());
                             person.getSpouse().setChild(p);
                             person.getSpouse().addChild(p);
                             p.setSurname(person.getSurname());
                           }
                        }
                        
                        person.addChildren(p);
                        
                        f.findSelectedItem(p);         
                    }  
               }
        }
        else
        {
            //do nothing 
        }
     }
     else 
     {
         //do nothing 
     }

     }
     
    public void displayPersonalinfo(Event evt)
    {
        TreeView<Object> tree = (TreeView<Object>)evt.getSource();

        TreeItem<Object> selectedPerson = tree.getSelectionModel().getSelectedItem();

        f.setSelectedItem(selectedPerson);
        
        
      if(selectedPerson != null)
       {
        if(selectedPerson.getValue().getClass() == Person.class)
        {
             person = (Person)selectedPerson.getValue();
                        
            if(body.getChildren().contains(personalData) == false)
            {
                body.getChildren().remove(rootadded);
            
                setPersonalData(person);
                
                body.add(personalData, 1, 0);
            }
            else 
            {
                body.getChildren().remove(personalData);
                
                setPersonalData(person);
                
                body.add(personalData, 1, 0);               
                
            }
        }
        else 
        {
            //do nothing 
        }
    }
        
    }
        
                 
     public void Submit(ActionEvent e) // 99
     {
         String maidenName = getValidatedMName() ;
         String surname = getValidatedSurnName();
         String bio = getValidatedBio();
         String streetName = getValidatedStreetName();
         String postcode = getValidatedPostCode();
         String suburb = getValidatedSuburb();
         String streetNumber = getValidatedSuburb();
             
       if(forname.getText().length() > 1 && forGender.getText().length()>1)
         {
             if(forGender.getText().equalsIgnoreCase("female"))
             {
                 p = new Person(forname.getText(), surname, maidenName,forGender.getText(), streetName, streetNumber, suburb, postcode, bio);
                 f.setRoot(p);
                 f.addRoot();
                 treeContainer = gettreeContainer();
                 rootadded = getrootadded();
                 body.getChildren().remove(personalinfo);
                 body.getChildren().remove(subBodyTwo);
                 body.add(rootadded, 1, 0);
                 body.add(treeContainer, 0, 0);
             }
             else if(forGender.getText().equalsIgnoreCase("male"))
             {
                 p = new Person(forname.getText(), surname,forGender.getText(), streetName, streetNumber, suburb, postcode, bio);
                 f.setRoot(p);
                 f.addRoot();
                 treeContainer = gettreeContainer();
                 rootadded = getrootadded();
                 body.getChildren().remove(personalinfo);
                 body.getChildren().remove(subBodyTwo);
                 body.add(rootadded, 1, 0);
                 body.add(treeContainer, 0, 0);
             }
             else 
             {
                 
             }             
         }
         else 
         {
             //do nothing yet 
         }
     }
     
     public ScrollPane gettreeContainer()
    {        
        TreeView<Object> tree  = f.getTree();
                        
        tree.setPrefSize(300, 850);
        
        tree.setOnMouseClicked(evt -> displayPersonalinfo(evt));
               
        VBox vbox = new VBox(tree);
        
        vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        vbox.setPrefSize(300, 850);
                     
        ScrollPane sp = new ScrollPane(vbox);
        
        sp.setFitToWidth(false);
        
        sp.setFitToHeight(true);
                
        return sp;
    }
   
    public void UpdateTreeView()
    {
        
        if(body.getChildren().contains(personalinfo) == true)
        {
           body.getChildren().remove(personalinfo);    
        }
        
        if(body.getChildren().contains(subBodyTwo)== true)
        {
           body.getChildren().remove(subBodyTwo);   
        }
        
        if(body.getChildren().contains(rootadded)== true)
        {
            body.getChildren().remove(rootadded);
            rootadded = getrootadded();
            body.add(rootadded, 1, 0);
        }
        else 
        {
            rootadded = getrootadded();
            body.add(rootadded, 1, 0);           
        }
        
        if(body.getChildren().contains(treeContainer)== true)
        {
            body.getChildren().remove(treeContainer);
            treeContainer = gettreeContainer();  
            body.add(treeContainer, 0, 0);
            
        }
        else 
        {
            treeContainer = gettreeContainer();  
            body.add(treeContainer, 0, 0);         
        }
    }
    
    
    
}
