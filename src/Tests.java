import GeneralComponents.*;
import Problems.*;

import java.math.BigInteger;

public class Tests {


    public static void main(String[] args) {
        //GeneralComponents.Individual ind = new GeneralComponents.Individual();
        /*int stringLength = 10;
        int popSize = 10;
        MaxOne maxOneProblem =  new MaxOne(stringLength);

        MaxOneIndividual[] initPopulation = maxOneProblem.initPopulation(popSize);

        for(MaxOneIndividual i: initPopulation){


            System.out.print("[ ");
            for(int j = 0; j < i.getRepresentation().length; j++){
                System.out.print(i.getRepresentation()[j] + ", ");
            }
            System.out.println("]\n");

            System.out.print("[ ");
            for(int j = 0; j < i.mapToReal().length; j++){
                System.out.print(i.mapToReal()[j] + ", ");
            }
            System.out.println("]\n");

            System.out.println(i.evaluateFitness());
        }


        System.out.println("GA: ");

        SelectionStrategy tournament = new Tournament(10, 2);

        MutationStrategy ms = new MaxOneMutation();

        Individual waka = initPopulation[0];

        for(int j = 0; j < waka.mapToReal().length; j++){
            System.out.print(waka.mapToReal()[j] + ", ");
        }
        System.out.println("]\n");

        Individual i = ms.mutate(waka);
        for(int j = 0; j < i.mapToReal().length; j++){
            System.out.print(i.mapToReal()[j] + ", ");
        }
        System.out.println("]\n");


        System.out.println(waka.compareTo(i));*/

        double x = 143.8578495948753;

        int intPart = (int) x;
        double floatingPart = x - (double)intPart;

        System.out.println(Double.doubleToLongBits(x));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(x)));

        System.out.println("int: " + intPart + ", float: " + floatingPart);

        Long binaryRep = Double.doubleToLongBits(x);

        System.out.println(binaryRep);

        String binaryRepresentation = Long.toBinaryString(binaryRep);

        int pos = (int) (Math.random() * binaryRepresentation.length());

        System.out.println("pos: " + pos);

        char charat = binaryRepresentation.charAt(pos);

        System.out.println("changed bit " + charat +" --> " + (charat == '1'? '0': '1'));
        String mutatedString = binaryRepresentation.substring(0, pos) + (charat == '1'? '0': '1') + binaryRepresentation.substring(pos+1, binaryRepresentation.length());


        System.out.println("original string" + binaryRepresentation.length());
        System.out.println("mutated string" + mutatedString.length());

        System.out.println(binaryRepresentation);
        System.out.println(mutatedString);

        long longRepre = new BigInteger(binaryRepresentation, 2).longValue();
        long longMutatedRepre = new BigInteger(mutatedString, 2).longValue();


        double original = Double.longBitsToDouble(longRepre);
        double mutated =Double.longBitsToDouble(longMutatedRepre);

        System.out.println("valor de la representacion" + longRepre);
        System.out.println("valor original: " + original);

        System.out.println("valor de la representacion" + longMutatedRepre);
        System.out.println("valor mutado: " + mutated);

        System.out.println("diferencia entre valores: " + Math.abs(original-mutated));




        System.out.println(charat);

        System.out.println(Long.toBinaryString(binaryRep));

        double result  = Double.longBitsToDouble(binaryRep);



        System.out.println(result);

    }
}
