package nfa_simulation;

import com.pchealth.nfa.NfaConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mfloresn90
 */
public class NFA_Simulation {

    public static void main(String[] args) {

        NfaConfig nfa = new NfaConfig("nfa.txt");
        Scanner scan = new Scanner(System.in);
        Integer opc = 0;
        String selected = "";
        String rho;
        List<Integer[]> lambdaClosure = nfa.getLambdaClosure(nfa.getCardQ());
        Integer[] conjuntoS;
        boolean result = false;

        do {
            System.out.println("\nAutomata Finito No-Determinista (AFN v1.0)\n");
            System.out.println("cardQ = " + nfa.getCardQ());
            System.out.println("cardF = " + nfa.getCardF());
            System.out.println("F = " + Arrays.toString(nfa.getF()));
            System.out.println("DeltaN = {");
            for (int i = 0; i < nfa.getDeltaN().size(); i += 3) {
                System.out.print("\t");
                System.out.print(Arrays.toString(nfa.getDeltaN().get(i)) + "\t");
                System.out.print(Arrays.toString(nfa.getDeltaN().get(i + 1)) + "\t");
                System.out.println(Arrays.toString(nfa.getDeltaN().get(i + 2)));
            }
            System.out.println("}");
            System.out.println("LambdaCerradura = {");
            for (Integer[] getData : lambdaClosure) {
                System.out.print("\t");
                System.out.println(Arrays.toString(getData));
            }
            System.out.println("}\n");

            System.out.print("1.- Insertar cadena."
                    + "\n2.- Salir."
                    + "\n\n\t¿Que desea hacer? ");
            selected = scan.nextLine();
            opc = Integer.parseInt(selected);

            switch (opc) {

                case 1:
                    result = false;
                    System.out.print("Inserte la cadena (rho): ");
                    rho = scan.nextLine();
                    conjuntoS = lambdaClosure.get(0);
                    System.out.println("\n Estado inicial  (q0) --> Lambda --> " + Arrays.toString(conjuntoS));

                    if (rho.length() >= 0) {
                        for (int x = 0; x < rho.length(); x++) {
                            Integer rhoInt = Character.getNumericValue(rho.charAt(x));
                            Integer[] move = nfa.move(conjuntoS, rhoInt);
                            System.out.print(" --> Siguiente[" + rhoInt + "] --> " + Arrays.toString(move));
                            conjuntoS = nfa.lClosure(move, lambdaClosure);
                            System.out.println(" Lambda --> " + Arrays.toString(conjuntoS));
                        }
                    }

                    System.out.println("");
                    for (Integer s : conjuntoS) {
                        for (int j = 0; j < nfa.getF().length; j++) {
                            if (s == nfa.getF()[j]) {
                                result = true;
                            }
                        }
                    }

                    if (result == true) {
                        System.out.println("\nLa cadena '" + rho + "' es aceptada por el AFN");
                    } else {
                        System.out.println("\nLa cadena '" + rho + "' no es aceptada por el AFN");
                    }
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("Saliendo....");
                    break;

                default:
                    System.out.println("Opción incorrecta...");
                    break;
            }
        } while (opc != 2);
    }

}
