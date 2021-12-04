import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class DataModel {
    private ValorAtributo temporada;
    private ValorAtributo oxigenacion;
    private ValorAtributo temperatura;
    private ValorAtributo dificultadRespirar;
    private String contagiado;

    public DataModel() {
        this.temporada = getRandomTemporada();
        this.oxigenacion = getRandomOxigenacion();
        this.temperatura = getRandomTemperatura();
        this.dificultadRespirar = getRandomDificultadRespirar();
    }

    public String getContagiado() {
        return contagiado;
    }

    public void setContagiado(String contagiado) {
        this.contagiado = contagiado;
    }

    public ValorAtributo getTemporada() {
        return temporada;
    }

    public ValorAtributo getOxigenacion() {
        return oxigenacion;
    }

    public ValorAtributo getTemperatura() {
        return temperatura;
    }

    public ValorAtributo getDificultadRespirar() {
        return dificultadRespirar;
    }

    public double getProbabilidad() {
        ValorAtributo[] valoresAtributos = {
                this.temporada,
                this.oxigenacion,
                this.temperatura,
                this.dificultadRespirar,
        };

        double sumProbabilidad = Arrays.stream(valoresAtributos)
                .map(ValorAtributo::getProbabilidad)
                .reduce((acc, valor) -> {
                    return acc += valor;
                })
                .orElse(0.0);

        double probalidadPromedio = sumProbabilidad / valoresAtributos.length;

        return probalidadPromedio;

    }

    private ValorAtributo getRandomDificultadRespirar() {
        String _dificultad = "";
        double probabilidad = 100;
        switch (Utils.getRandomOpt(1, 2)) {
            case 1:
                _dificultad = "true";
                probabilidad = 60;
                break;
            case 2:
                _dificultad = "false";
                probabilidad = 15;
                break;
        }
        return new ValorAtributo(probabilidad, "dificultad_respirar", _dificultad);
    }

    private ValorAtributo getRandomOxigenacion() {
        String _oxigenacion = "";
        double probabilidad = 100;
        switch (Utils.getRandomOpt(1, 2)) {
            case 1:
                _oxigenacion = "normal";
                probabilidad = 50;
                break;
            case 2:
                _oxigenacion = "low";
                probabilidad = 100;
                break;
        }
        return new ValorAtributo(probabilidad, "oxigenacion", _oxigenacion);
    }

    private ValorAtributo getRandomTemperatura() {
        String _temperatura = "";
        double probabilidad = 100;
        switch (Utils.getRandomOpt(1, 3)) {
            case 1:
                _temperatura = "hot";
                probabilidad = 100;
                break;
            case 2:
                _temperatura = "mild";
                probabilidad = 60;
                break;
            case 3:
                _temperatura = "cold";
                probabilidad = 10;
                break;
        }
        return new ValorAtributo(probabilidad, "temperatura", _temperatura);
    }

    private ValorAtributo getRandomTemporada() {
        String _temporada = "";
        double probabilidad = 100;
        switch (Utils.getRandomOpt(1, 4)) {
            case 1:
                _temporada = "primavera";
                probabilidad = 90;
                break;
            case 2:
                _temporada = "verano";
                probabilidad = 50;
                break;
            case 3:
                _temporada = "otoño";
                probabilidad = 50;
                break;
            case 4:
                _temporada = "invierno";
                probabilidad = 100;
                break;
        }
        return new ValorAtributo(probabilidad, "temporada", _temporada);
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "temporada=" + temporada +
                ", oxigenacion=" + oxigenacion +
                ", temperatura=" + temperatura +
                ", dificultadRespirar=" + dificultadRespirar +
                ", probabilidad=" + getProbabilidad() +
                '}';
    }
}