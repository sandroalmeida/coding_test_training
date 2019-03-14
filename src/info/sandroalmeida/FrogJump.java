package info.sandroalmeida;

public class FrogJump {

    public static int calculate(int X, int Y, int D){

        double precision = (Y-X)/(D*1.0);
        int round = (int) Math.round(precision);
        round = precision > round ? round + 1 : round;
        return round;
    }

}
