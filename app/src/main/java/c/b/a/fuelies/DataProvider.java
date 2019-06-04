package c.b.a.fuelies;

/**
 * Created by Afri Upholstery on 21 Mar 2017.
 */

public class DataProvider
{

    public String name;
    public String registration;
    public String kilos;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getKilos() {
        return kilos;
    }

    public void setKilos(String kilos)
    {
        this.kilos = kilos;
    }

    // Constructor for this class with id
    public DataProvider(String name, String registration, String kilos)
    {
        this.name = name;
        this.registration = registration;
        this.kilos = kilos;
    }




}
