package booking.models;


public enum UserInformation {
    USUARIO("rmechanc@gmail.com", "Av Amarantos 208", "111999", "Chiclayo","Peru","942337396");

    private final String email;
    private final String direccion;
    private final String postalCode;
    private final String ciudad;
    private final String pais;
    private final String telefono;


    UserInformation(String email, String direccion,String postalCode, String ciudad, String pais, String telefono) {

        this.email = email;
        this.direccion = direccion;
        this.postalCode = postalCode;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public String getDireccion() {
        return direccion;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCountry() {
        return pais;
    }

    public String getTelefono() {
        return telefono;
    }
}
