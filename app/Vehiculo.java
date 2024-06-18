public class Vehiculo {
    private String placa;
    private String marca;
    private String linea;
    private String modelo;
    private String cilindraje;
    private String color;
    private String servicio;
    private String claseVehiculo;
    private String tipoCarroceria;
    private String numeroMotor;
    private String capacidadVehiculo;
    private String numeroChasis;

    // Constructor vacío necesario para Firebase
    public Vehiculo() {}

    public Vehiculo(String placa, String marca, String linea, String modelo, String cilindraje, String color, String servicio, String claseVehiculo, String tipoCarroceria, String numeroMotor, String capacidadVehiculo, String numeroChasis) {
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.color = color;
        this.servicio = servicio;
        this.claseVehiculo = claseVehiculo;
        this.tipoCarroceria = tipoCarroceria;
        this.numeroMotor = numeroMotor;
        this.capacidadVehiculo = capacidadVehiculo;
        this.numeroChasis = numeroChasis;
    }

    // Getters y Setters
    // ...
}
