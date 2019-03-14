package info.sandroalmeida;

public class ReverseCStyleString {

    public static String reverse(String str) {

        char[] data = str.toCharArray();
        int i = 0;
        int j = data.length - 1;
        char temp;

        while(i < j){
            temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j--;
        }

        String s = new String(data);
        return s;


    }
}
