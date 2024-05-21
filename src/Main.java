import EssentialsGates.*;
import ProjectPart3.PartA.*;
import ProjectPart3.PartB.*;
import ProjectPart5.*;
import ProjectPart2.*;


public class Main {
    public static void main(String[] args) {
        // Crear una instancia de ControlUnit
        ControlUnit controlUnit = new ControlUnit((byte) 0);

        // Crear una lista de instrucciones
        byte[][] instructions = {
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                // Agrega más instrucciones aquí...
        };

        // Cargar las instrucciones en la ROM de la ControlUnit
        controlUnit.loadInstructions(instructions);


        // Ejecutar las instrucciones
        controlUnit.run();
    }
}