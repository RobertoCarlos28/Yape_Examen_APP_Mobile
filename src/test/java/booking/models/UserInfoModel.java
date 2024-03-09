package booking.models;

import java.util.HashMap;
import java.util.Map;

import static booking.utils.data.Constants.*;

public class UserInfoModel {

    private static final Map<String, String> infoUser = new HashMap<>();

    private UserInfoModel() {
    }

    public static Map<String, String> userInformation() {
        infoUser.put(NOMBRE, BookingInformation.USUARIO.getFirstName());
        infoUser.put(APELLIDO, BookingInformation.USUARIO.getLastName());

        infoUser.put(EMAIL, UserInformation.USUARIO.getEmail());
        infoUser.put(DIRECCION, UserInformation.USUARIO.getDireccion());
        infoUser.put(CODIGO_POSTAL, UserInformation.USUARIO.getPostalCode());
        infoUser.put(CIUDAD, UserInformation.USUARIO.getCiudad());
        infoUser.put(PAIS, UserInformation.USUARIO.getCountry());
        infoUser.put(TELEFONO, UserInformation.USUARIO.getTelefono());
        return infoUser;
    }
}
