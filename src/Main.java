import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int numeroRegistros = 500000;

        DataModel[] models = new DataModel[numeroRegistros];

        for (int i = 0; i < models.length; i++) {

            DataModel record = new DataModel();

            int randNum = Utils.getRandomOpt(0, 100);

            boolean tieneCovid = false;
            if (randNum <= record.getProbabilidad()) {
                tieneCovid = true;
            }

            // [0, probalidadPromedio] -> si
            // (probalidadPromedio, 100] -> no

            // [0, 80] -> si
            // (80, 100] -> no

            // randNum = 60 SI
            // randNum = 99 NO

            if (record.getOxigenacion().getValor().equals("low")) {
                tieneCovid = true;
                record.getDificultadRespirar().setValor("true");
                record.getDificultadRespirar().setProbabilidad(100);
            }

            record.setContagiado("no");
            if (tieneCovid) {
                record.setContagiado("yes");
            }

            models[i] = record;

        }

        try {
            GenerdorArff generdorArff = new GenerdorArff("covid.arff");
            generdorArff.generar(models);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
