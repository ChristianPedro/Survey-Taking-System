import java.io.Serializable;

public class ShortAnswer extends Essay implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int MaximumCharactersAllowed = 64;


    public ShortAnswer(){
        super();
    }

    public ShortAnswer(String text){
        super(text);
    }


}
