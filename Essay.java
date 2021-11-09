import java.io.Serializable;

public class Essay extends Question implements Serializable {
    private static final long serialVersionUID = 1L;

    public Essay(){
        super();
    }
    public Essay(String prompt){
        super(prompt);
    }


}

