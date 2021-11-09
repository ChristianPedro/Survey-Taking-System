import java.io.Serializable;

public class TrueAndFalse extends MultipleChoice implements Serializable {
    private static final long serialVersionUID = 1L;
    public int MaximumOptions = 2;

    public TrueAndFalse(){
        super();
    }
    public TrueAndFalse(String prompt){
        super(prompt);
    }


}
