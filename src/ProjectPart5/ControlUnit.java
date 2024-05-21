package ProjectPart5;
import EssentialsGates.Utilities;
import java.util.Timer;
import java.util.TimerTask;


public class ControlUnit {
    private byte reset;
    private ROM32K rom32K;
    private CPU cpu;
    private Memory memory;
    private Timer timer;

    public ControlUnit(byte reset) {
        this.reset = reset;

        // Inicializar las partes
        this.rom32K = new ROM32K(new byte[15]);
        this.cpu = new CPU(new byte[16], new byte[16], reset);
        this.memory = new Memory(new byte[16], (byte) 0, new byte[15]);

        // Ejecutar la lógica de la computadora
        this.timer = new Timer();
        executeLogic();
    }

    private void executeLogic() {
        // Obtener la instrucción de la ROM32K
        byte[] instruction = rom32K.getOut();

        // Configurar la CPU con la instrucción, la salida de la memoria y la señal de reset
        cpu.setIn(memory.getOut(), instruction, reset);

        // Configurar la memoria con la salida de la CPU, la señal de escritura de la CPU y la dirección de la CPU
        memory.setIn(cpu.getOutM(), cpu.getWriteM(), cpu.getAddressM());

        // Configurar la dirección de la ROM32K con el PC de la CPU
        rom32K.setAddress(cpu.getPC());
    }

    public void run() {
        timer.schedule(new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                // Configurar la dirección de la ROM32K con el valor actual de i
                rom32K.read(Utilities.toBinaryArray((byte) 0),Utilities.toBinaryArray((byte) i));

                // Ejecutar la lógica de la computadora
                executeLogic();

                // Comprobar si la instrucción es todo 0s
                byte[] instruction = rom32K.getOut();

                i++;
            }
        }, 0, 500);
    }

    public void loadInstructions(byte[][] instructions) {
        // Recorrer todas las instrucciones
        for (int i = 0; i < instructions.length; i++) {
            // Escribir la instrucción en la dirección correspondiente de la ROM
            rom32K.write(instructions[i], Utilities.toBinaryArray((byte) i));
        }
    }

}
