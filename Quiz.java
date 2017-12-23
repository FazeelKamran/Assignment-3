package hello;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "quiz")                        //name of the table
@Inheritance(strategy=InheritanceType.JOINED)
public class Quiz {                       //class name
                                              //attributes
    private int quizid;
    private String title;
    private String description;
    private int teacherid;
    private Users userid; 
 
	// no-arg Constructor
    public Quiz(){}
    public Quiz(String title,String description,int teacherid,int quizid,Users userid){
    	this.title=title;
        this.description=description;
    	this.teacherid = teacherid;
    	this.quizid=quizid;
    	this.userid=userid;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "quizid" , unique = true)
    public int getQuizid() {                              //getter and setter functions
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }
    @NotNull
    @Column(name = "title")
    public String getTitle() {                                    //getter and setter functions
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "description")                     //getter and setter functions
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    
    public Users getUserid() {
		return userid;
	}
	public void setUserid(Users userid) {
		this.userid = userid;
	}
                                           //teacher id refers to the id of the teacher (used as foreign key here)
    public int getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }
    
   
}
