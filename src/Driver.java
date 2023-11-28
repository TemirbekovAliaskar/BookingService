import java.util.Objects;

public class Driver {

    private String drivername;
    private String driverSurname;

    public Driver(String drivername, String driverSurname) {
        this.drivername = drivername;
        this.driverSurname = driverSurname;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }

    @Override
    public String toString() {

        return "║   Driver Name   : " + drivername + "    Driver Surname: " + driverSurname + "\n";

    }
}
