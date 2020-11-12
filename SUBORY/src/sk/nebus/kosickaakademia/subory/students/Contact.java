package sk.nebus.kosickaakademia.subory.students;

public class Contact {
    private String mobil;
    private String email;
    private String skype;

    public Contact(){

    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getMobil() {
        return mobil;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }
}
