package booking.models;


public enum BookingInformation {
    USUARIO("Roberto", "Mechan");

    private final String firstName;
    private final String lastName;


    BookingInformation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
