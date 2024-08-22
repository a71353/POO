import java.util.Locale;
import java.util.Objects;

/**
 * @author 71353 Gonçalo Figueiredo
 * @version 1 3/3/2023
 */

public class EncrypterSmith {



    /**
     * @param str string que vai ser alterada
     * @param d valor que a string anda para a esquerda
     * @see <a href="https://www.geeksforgeeks.org/left-rotation-right-rotation-string-2/">...</a>
     * @return retorna a string rodada para a esquerda
     * **/
    static String leftrotate(String str, int d)
    {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    /**
     *
     * @param str string que vai ser alterada
     * @param d valor que a string anda para a direita
     * @return retorna a string rodada para a direita
     */
    static String rightrotate(String str, int d)
    {
        return leftrotate(str, str.length() - d);
    }

    /**
     * @see <a href="https://stackoverflow.com/questions/22574768/increase-a-char-value-by-one">...</a>
     * @param str string que vai ser alterada
     * @param x valor que é somado na tabela ascii
     * @return retorna a string com os valores ascii da string alterados
     */

    public static String asciivalue(String str, int x) {
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (char) (str.charAt(i) + x);
            encrypt.append(c);
        }
        return encrypt.toString();
    }

    /**
     * @param str string que vai ser alterada
     * @param x valor que é subtraido na tabela ascii
     * @return retorna a string com os valores ascii da string alterados
     */
    public static String asciivalue2(String str, int x) {
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (char) (str.charAt(i) - x);
            encrypt.append(c);
        }
        return encrypt.toString();
    }

    /**
     * @param n valor que vai ser usado nas funções de andar para a esquerda ou direita
     * @param p valor que vai ser usado nas funções de alterar valor na tabela ascii
     * @param message mensagem que vai ser encriptada
     * @return retorna a message encriptada
     */
    //Encrypts string message with key passed in n and p
    //returns the encrypted string
    static String encrypt(int n, int p, String message){
        String rotated = null;
        if(n < 0){
            rotated = leftrotate(message, n * -1);
        }
        if(n > 0){
            rotated = rightrotate(message, n);
        }
        return asciivalue(rotated, p);
    }

    /**
     * @param n valor que vai ser usado nas funções de andar para a esquerda ou direita
     * @param p valor que vai ser usado nas funções de alterar valor na tabela ascii
     * @param encriptedMessage mensagem que vai ser desencriptada
     * @return retorna a encripted message desencriptada
     */
    //Tries to decrypt encriptedMessage with key passed in n and p
    //returns the decrypted string
    static String decrypt(int n, int p, String encriptedMessage){
        String rotated = null;
        if(n < 0){
            rotated = rightrotate(encriptedMessage, n * -1);
        }
        else{
            rotated = leftrotate(encriptedMessage, n);
        }
        return asciivalue2(rotated, p);
    }

    //Tests all key combinations of n and p until the first letters
    //in the string became "bug".
    //returns found key in an array with 2 ints: n and p
    //word is the word at the beginning of the string: "bug"

    /**
     * @param encryptedMessage mensagem encriptada
     * @param word == "bug"
     * @return retorna o valor de n e p que vai ser para desencriptar as mensagens
     */
    static int[] findKey(String encryptedMessage, String word){
        String decstr;
        word = "bug";
        for(int n = -9; n < 9; n++){
            for(int p = -4; p < 4; p++){
                decstr = decrypt(n, p, encryptedMessage);
                if(decstr.substring(0,3).toLowerCase().equals(word)){
                    return new int[] {n,p};
                }
            }
        }
        return new int[] {0,0};
    }
}
