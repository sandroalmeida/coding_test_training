package info.sandroalmeida;

public class IntegerTest {

    public static int countHoles(int number){

        String str = String.valueOf(number);
        char[] chars = str.toCharArray();

        int count = 0;
        for(char c : chars){
            switch (c){
                case '0':
                    count++;
                    break;
                case '4':
                    count++;
                    break;
                case '6':
                    count++;
                    break;
                case '9':
                    count++;
                    break;
                case '8':
                    count += 2;
                    break;
            }
        }
        return count;
    }
}
