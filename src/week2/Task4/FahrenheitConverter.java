package week2.Task4;

public class FahrenheitConverter implements BaseConverter {
    @Override
    public double convertCelsius(double celsiusValue) { return 1.8 * celsiusValue + 32;  }
}
