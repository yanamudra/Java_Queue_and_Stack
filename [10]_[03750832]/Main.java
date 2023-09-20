package exercise;

public class Main {
    public static void main(String[] args) {

    BHS test = new BHS();
    test.checkInBaggage("001000");
        test.checkInBaggage("001001");
        test.checkInBaggage("001010");
        test.checkInBaggage("001011");
        System.out.println("");
        test.checkInSpecialBaggage("101000");
        test.checkInSpecialBaggage("101001");
        test.checkInSpecialBaggage("101010");
        test.checkInSpecialBaggage("101011");
        System.out.println("");
        test.removeBaggage("001010");
        System.out.println("");
        test.removeBaggage("001111");
        System.out.println("");
        test.removeSpecialBaggage("101010");
        System.out.println("");
        test.removeSpecialBaggage("101111");
    }
}
