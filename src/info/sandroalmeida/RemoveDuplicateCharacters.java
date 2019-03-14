package info.sandroalmeida;

public class RemoveDuplicateCharacters {

    public static String solution(String str){

        char[] chars = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(str.indexOf(c) != i){
                str = str.substring(0,i) + str.substring(i).replace(String.valueOf(c), "");
            }
        }
        return str;
    }

}
