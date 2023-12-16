
import java.lang.ModuleLayer.Controller;

import program.Main.Pet;
import program.repository.petRepository;
import program.repository.repository;


public class program {
    public static void main(String[] args) throws Exception {

        repository <Pet> myFarm = new petRepository();
        Controller controller = new Controller(myFarm);
        new menu (controller).start();
    }
}    