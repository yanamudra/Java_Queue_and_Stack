package exercise;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BHS {
    private Queue<String> conveyorBelt = new ArrayDeque<String>();
    private Stack<String> specialBaggageStorage = new Stack<String>();
    private Stack<String> temporaryStorage = new Stack<String>();

    public void checkInBaggage(String barcode){
        conveyorBelt.add(barcode);
        System.out.println("Bag " + barcode + " is placed on the conveyor belt");
    }
    public void checkInSpecialBaggage(String barcode){
        specialBaggageStorage.push(barcode);
        System.out.println("Bag " + barcode + " is stored in the storage room");
    }
    public void removeBaggage(String barcode) {
        String firstBag = conveyorBelt.poll();
        String newFirstBag = firstBag;
        boolean found = false;
        boolean allBagsAreExamined = false;
        while (!found && !allBagsAreExamined) {
            if (newFirstBag.equals(barcode)) {
                System.out.println("Bag " + barcode + " removed from the conveyor belt");
                found = true;
            } else {
                conveyorBelt.add(newFirstBag);
                System.out.println("Bag " + newFirstBag + " went all around the conveyor belt");
                newFirstBag = conveyorBelt.poll();
                if (newFirstBag.equals(firstBag)) {
                    allBagsAreExamined = true;
                }
            }
        }
        if (!found){
            System.out.println("Bag " + barcode + " is lost" );
        }
    }

    public void removeSpecialBaggage(String barcode) {
        boolean found = false;
        while (!specialBaggageStorage.isEmpty() && !found){
            String firstSpecialBag =  specialBaggageStorage.pop();
           if (firstSpecialBag.equals(barcode)) {
               System.out.println("Bag " + barcode + " removed from the storage room");
               found = true;
           } else {
               temporaryStorage.push(firstSpecialBag);
               System.out.println("Bag " + firstSpecialBag + " stored in the temporary storage room");
           }
        }
        if (!found) {
            System.out.println("Bag " + barcode + " is lost");
        }
        while (!temporaryStorage.isEmpty()) {
            String firstTemporarySpecialBag = temporaryStorage.pop();
            specialBaggageStorage.push(firstTemporarySpecialBag);
            System.out.println("Bag " + firstTemporarySpecialBag + " stored back in the storage room");
        }
    }
}
