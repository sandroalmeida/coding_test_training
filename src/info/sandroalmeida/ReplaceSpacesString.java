package info.sandroalmeida;


public class ReplaceSpacesString {

    public static String ReplaceFun(char c, String str) {

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' '){
                chars[i] = c;
            }
        }
        return String.valueOf(chars);
    }
}
