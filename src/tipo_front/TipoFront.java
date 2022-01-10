package tipo_front;

import controller.AuthController;
import controller.CityController;
import controller.LetterController;

public class TipoFront {
    private AuthController authController = new AuthController();
    private LetterController letterController = new LetterController();
    private CityController cityController = new CityController();

    //Необязательно static
    public static void run() {

    }
}
