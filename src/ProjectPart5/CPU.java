package ProjectPart5;

import ProjectPart2.ALU;
import ProjectPart3.PartA.*;
import ProjectPart3.PartB.*;
import EssentialsGates.*;

public class CPU {
    private byte[] inM;
    private byte[] instruction;
    private byte reset;

    private byte[] outM = Utilities.toBinaryArray((byte) 0);
    private byte writeM;
    private byte[] addressM;
    private byte[] pc;
    private byte[] outALU = Utilities.toBinaryArray((byte) 0);

    // Registros
    private Register registerA;
    private Register registerD;
    private PC programCounter;

    public CPU(byte[] inM, byte[] instruction, byte reset) {
        this.inM = inM;
        this.instruction = instruction;
        this.reset = reset;

        // Inicialización de los registros
        this.registerA = new Register();
        this.registerD = new Register();
        this.programCounter = new PC();

        // Lógica para manejar las instrucciones
        executeInstruction();
    }

    private void executeInstruction() {
        // Decodificación de la instrucción
        byte isCInstruction = instruction[0];
        byte isAInstruction = (byte) ~isCInstruction;

        // Determinación de las operaciones a realizar
        and And1 = new and(isCInstruction, instruction[10]);
        byte isCWriteA = And1.getAnd();
        or Or1 = new or(isAInstruction, isCWriteA);
        byte loadA = Or1.getOr();

        System.out.println("Executing Intruction: "+ Utilities.toDecimal(instruction));

        // Selección de la entrada para A
        Mux16 mux1 = new Mux16(instruction, outALU, isCWriteA);
        byte[] inAReg = mux1.getOut();
        registerA.setIn(inAReg, loadA);
        this.addressM = Utilities.SliceArray(registerA.getOut(), 1, 15);
        byte[] outAReg = registerA.getOut();

        // Operaciones con D
        and And2 = new and(isCInstruction, instruction[11]);
        byte loadD = And2.getAnd();
        registerD.setIn(outALU, loadD);
        byte[] outDReg = registerD.getOut();

        // Selección entre A y M
        Mux16 mux2 = new Mux16(registerA.getOut(), inM, instruction[3]);
        byte[] outAorM = mux2.getOut();

        // Operaciones de la ALU
        ALU alu = new ALU(outDReg, outAorM, instruction[4], instruction[5],instruction[6], instruction[7], instruction[8], instruction[9]);
        this.outALU = alu.getOut();
        this.outM = alu.getOut();

        // Control de flujo y actualización de PC
        not Not1 = new not(alu.getNegOut());
        byte IsNonNeg = Not1.getNot();

        not Not2 = new not(alu.getZeroOut());
        byte IsNonZero = Not2.getNot();

        and And3 = new and(IsNonZero,IsNonNeg);
        byte IsPositive = And3.getAnd();

        and And4 = new and(isCInstruction, instruction[12]);
        writeM = And4.getAnd();

        and And5 = new and(IsPositive, instruction[15]);
        byte JGT = And5.getAnd();

        and And6 = new and(alu.getZeroOut(), instruction[14]);
        byte JEQ = And6.getAnd();

        and And7 = new and(alu.getNegOut(), instruction[13]);
        byte JLT = And7.getAnd();

        or Or2 = new or(JEQ, JLT);
        byte JLE = Or2.getOr();

        or Or3 = new or(JLE, JGT);
        byte jumpToA = Or3.getOr();

        and And8 = new and(isCInstruction, jumpToA);
        byte loadPC = And8.getAnd();

        not Not3 = new not(loadPC);
        byte PCInc = Not3.getNot();
        programCounter.setIn(outAReg, PCInc, loadPC, reset);
        this.pc = Utilities.SliceArray(programCounter.getOut(), 1, 15);

        System.out.println("The value in Memory[0] is: " + Utilities.toDecimal(this.inM));
    }

    public void setIn(byte[] inM, byte[] instruction, byte reset) {
        this.inM = inM;
        this.instruction = instruction;
        this.reset = reset;
        executeInstruction();
    }

    public void setIn(byte inM, byte instruction, byte reset) {
        setIn(Utilities.toBinaryArray(inM), Utilities.toBinaryArray(instruction), reset);
    }

    public byte[] getOutM() {
        return outM;
    }

    public byte getWriteM() {
        return writeM;
    }

    public byte[] getAddressM() {
        return addressM;
    }

    public byte[] getPC() {
        return pc;
    }

    public byte[] getOutALU() {
        return outALU;
    }
}