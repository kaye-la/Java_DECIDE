package week2.Task4;

public class KelvinConverter implements BaseConverter {
    @Override
    public double convertCelsius(double celsiusValue) {
        return celsiusValue + 273.15;
    }
}
