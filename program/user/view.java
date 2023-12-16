import java.util.List;

public interface view <T>{
    
    String getName();
    String getBirthday();
    <U> void printAll (List <U> list, Class <U> clazz);
    void showMessage (String s);

}