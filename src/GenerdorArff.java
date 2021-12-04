import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerdorArff {
    FileWriter arfFile;
    BufferedWriter writer;

    public GenerdorArff(String fileName) throws IOException {
        arfFile = new FileWriter("./" + fileName, false);
        writer = new BufferedWriter(arfFile);
        base();
    }

    public void base() throws IOException {
        String header = "@relation covid.symbolic\n";
        writer.write(header);
        writer.write("\n");

        String attributes = "" +
                "@attribute temporada {primavera, verano, otoño, invierno}\n" +
                "@attribute temperatura {hot, mild, cold}\n" +
                "@attribute oxigenacion {low, normal}\n" +
                "@attribute dificultad_respirar {true, false}\n" +
                "@attribute contagiado {yes, no}\n";

        writer.write(attributes);
        writer.write("\n");

        writer.write("@data\n");
    }

    public void generar(DataModel[] models) throws IOException {
        for (DataModel model : models) {
            System.out.println(model);
            writer.write(
                String.format(
                    "%s,%s,%s,%s,%s\n",
                    model.getTemporada().getValor(),
                    model.getTemperatura().getValor(),
                    model.getOxigenacion().getValor(),
                    model.getDificultadRespirar(),
                    model.getContagiado()
                )
            );
        }
        writer.close();
    }
}
