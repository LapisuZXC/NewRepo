import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import javax.swing.RowFilter.Entry;

class CustomMathException extends Exception {
    public CustomMathException(String text) {
        System.out.println(text);
    }
}

public class Chumakov_6 {
    public static void main(String[] args) throws CustomMathException {

        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.","sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println();
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println();
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println();
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45));
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45));
        System.out.println(twoProduct(new int[]{1, 2,-1, 4, 5, 6, 10, 7}, 20));
        System.out.println(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(twoProduct(new int[]{100, 12, 4, 1, 2}, 15));
        System.out.println();
        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(isExact(125));
        System.out.println(isExact(720));
        System.out.println(isExact(1024));
        System.out.println(isExact(40320));
        System.out.println();
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println();
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println();
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)") );
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)") );
        System.out.println();
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba") );
        System.out.println();
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb") );
        

    }
    public static Map<Character, Integer> getLetterSet(String str) {
        Map<Character, Integer> set = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                set.put(c, set.getOrDefault(c, 0) + 1);
            }
        }
        return set;
    }

    public static String onlyLetters(String str) {
        str = str.toLowerCase();
        StringBuilder resBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (97 <= c && c <= 122) {
                resBuilder.append(c);
            }
        }
        return resBuilder.toString();
    }

    public static String hiddenAnagram(String a, String b) {
        a = onlyLetters(a);
        b = onlyLetters(b);
        Map<Character, Integer> setB = getLetterSet(b);
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String substr = a.substring(i, i + b.length());
            Map<Character, Integer> setA = getLetterSet(substr);
            if (setA.equals(setB)) {
                StringBuilder resBuilder = new StringBuilder();
                for (char c : substr.toCharArray()) {
                    if (97 <= c && c <= 122) {
                        resBuilder.append(c);
                    }
                }
                return resBuilder.toString();
            }
        }
        return "noutfond";
    }
    public static List<Object> collect(String str, int n) {
        List<Object> lst = new ArrayList();
        if (str.length() < n) {
            return lst;
        } else {
            lst.add(str.substring(0, n));
            lst.addAll(collect(str.substring(n), n));
            List<Object> list = (List)lst.stream().sorted().collect(Collectors.toList());
            return list;
        }
    }
    public static int[] getCharset(String word) {
        int[] charset = new int[127];
        for (char c : word.toCharArray()) charset[c]++;
        return charset;
    }

    public static String nicoCipher(String message, String key) {
        for (int i = 0; i < (message.length()+key.length()) % key.length(); i++)
            message += ' ';
        int[] set = getCharset(key);
        int[] setCount = set.clone();
        int counter = 1;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) {
                if (set[i] > 1)
                    counter += set[i] - 1;
                set[i] = counter++;
            }
        int[] offsets = new int[key.length()];
        for (int i = 0; i < key.length(); i++)
            offsets[set[key.charAt(i)]-setCount[key.charAt(i)]--] = i;
        String res = "";
        for (int i = 0; i < message.length(); i++) {
            int index = (i / offsets.length) * offsets.length + offsets[i % offsets.length];
            res += message.charAt(index);
        }

        return res;
    }
    public static String twoProduct(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int m : arr) {
            if (n % m == 0 && set.contains(n / m))
                return Arrays.toString(new int[] {n/m, m});
            set.add(m);
        }
        return Arrays.toString(new int[] {});
    }
    public static int[] isExact(int f, int m, int n) {
        if (f < n)
            return isExact(f*(m+1), m+1, n);
        return new int[] {f, m};
    }
    public static String isExact(int n) {
        int[] res = isExact(1, 1, n);
        if (res[0] == n) return Arrays.toString(res);
        return Arrays.toString(new int[] {});
    } 
   public static String fractions(String frac) {
        int startBracket = frac.indexOf('(');
        if (startBracket != -1) {
            String f = frac.substring(startBracket+1, frac.length()-1);
            frac = frac.substring(0, startBracket);
            for (int i = 0; i < 9 - f.length(); i++)
                frac += f;
        }
        double a = Double.parseDouble(frac);
        int div = 2;
        while (Math.ceil(a * div) - a * div > 0.000001) div++;
        return "" + (int)Math.ceil(a * div) + "/" + div;
    }
    public static String pilish_string(String str) {
        String res = "";
        String pi = String.valueOf(Math.PI).replace(".", "");
        int piIndex = 0;
        while (str.length() > 0) {
            int p = pi.charAt(piIndex) - 48;
            int n = Math.min(p, str.length());
            res += str.substring(0, n);
            str = str.substring(n);
            piIndex++;
            if (str.length() > 0) res += ' ';
            else if (p > n)
                for (int i = 0; i < p - n; i++)
                    res += res.charAt(res.length() - 1);
        }
        return res;
    }
    // -8*3/2+3
    public static int generateNonconsecutive(String str) throws CustomMathException {
        String operations = "+-/*";
        str = str.replaceAll("\\(", "( ");
        str = str.replaceAll("\\)", " )");
        String[] strArray = str.split("\\s+");
        // Красивый показ (на защиту)
        //System.out.println(Arrays.toString(strArray));
        boolean lastNum = false;
        String now;
        int bracketCounter = 0;
        int openBrackets = 0;

        // Обработка ислючений
        for (int i = 0; i < strArray.length; i++) {
            now = strArray[i];
            if (operations.contains(now)) {
                if ((i == 0 || i == strArray.length - 1)) {
                    throw new CustomMathException("Неверный формат ввода (начинается или заканичивается операцией))");
                }
                if (!lastNum) {
                    throw new CustomMathException("Неверный формат ввода (две операции подряд или ошибка у скобок)");
                }
                lastNum = false;
            }
            else if (now.equals("(")) {
                openBrackets += 1;
                bracketCounter += 1;
            }
            else if (now.equals(")")) {
                openBrackets -= 1;
                if (openBrackets < 0) {
                    throw new CustomMathException("Неверный формат ввода (неправильный порядок скобок)");
                }
            }
            else if (now.matches("-?\\d+")) {
                if (lastNum) {
                    throw new CustomMathException("Неверный формат ввода (два числа подряд или ошибка у скобок)");
                }
                lastNum = true;
            }
            else {
                throw new CustomMathException("Неверный формат ввода (встречается неизвестная подстрока)");
            }
        }
        if (openBrackets != 0) {
            throw new CustomMathException("Неверный формат ввода (неправильный порядок скобок)");
        }

        // Простой случай операции
        if (strArray.length == 3) {
            switch (strArray[1]) {
                case "+" -> {
                    return Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2]);
                }
                case "-" -> {
                    return Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2]);
                }
                case "*" -> {
                    return Integer.parseInt(strArray[0]) * Integer.parseInt(strArray[2]);
                }
                case "/" -> {
                    try {
                        return Integer.parseInt(strArray[0]) / Integer.parseInt(strArray[2]);
                    }
                    catch (ArithmeticException e) {
                        throw new CustomMathException("Ошибка: В строке происходит деление на ноль");
                    }
                }
            }
        }
        // Разбиение на простые случаи
        else {
            // Учитывание скобок
            if (bracketCounter != 0) {
                int firstBracket = -1;
                int secondBracket = -1;
                // Ищем скобки
                for (int i = 0; i < strArray.length; i++) {
                    now = strArray[i];
                    if (now.equals("(") && firstBracket == -1) firstBracket = i;
                    if (now.equals(")")) secondBracket = i;
                }

                // Создаем новую строку, учитывая скобки
                String newStr = "";
                if (firstBracket != 0) {
                    newStr += String.join(" ", Arrays.copyOfRange(strArray, 0, firstBracket)) + " ";
                }
                newStr += (generateNonconsecutive(
                                String.join(" ",
                                        Arrays.copyOfRange(strArray, firstBracket + 1, secondBracket))
                ));
                if (secondBracket != strArray.length) {
                    newStr += " " +
                            String.join(" ",
                                    Arrays.copyOfRange(strArray, secondBracket + 1, strArray.length));
                }
                return generateNonconsecutive(newStr);
            }
            // Сокращение через базовые операции
            else {
                int operationIndex = -1;
                boolean higher = false;
                for (int i = 0; i < strArray.length; i++) {
                    now = strArray[i];
                    if ("+-".contains(now) && operationIndex == -1) operationIndex = i;
                    if ("*/".contains(now) && !higher) {
                        operationIndex = i;
                        higher = true;
                    }
                }
                // Построение новой строки
                String newStr = "";
                if (operationIndex != 1) {
                    newStr += String.join(" ",
                            Arrays.copyOfRange(strArray, 0, operationIndex - 1)) + " ";
                }
                newStr += (generateNonconsecutive(
                        String.join(" ",
                                Arrays.copyOfRange(strArray, operationIndex - 1, operationIndex + 2))
                ));
                if (openBrackets != strArray.length - 1) {
                    newStr += " " +
                            String.join(" ",
                                    Arrays.copyOfRange(strArray, operationIndex + 2, strArray.length));
                }
                return generateNonconsecutive(newStr);
            }
        }
        // Вывод 0, чтобы компилятор пропустил
        return 0;
    }
    public static String isValid(String str) {
        int[] charCount = new int[26]; // массив для подсчета количества символов

        // подсчитываем количество каждого символа в строке
        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }

        int oddCount = 0; // количество символов с нечетным количеством

        // проверяем количество символов с нечетным количеством
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        // определяем, является ли строка действительной
        return oddCount <= 1 ?  "YES" : "NO";
        
    }

    public static String findLCS(String str1, String str2) {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
                else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        ArrayList<Character> chars = new ArrayList<>();
        int temp_i = str1.length() - 1;
        int temp_j = str2.length() - 1;
        while (temp_i >= 0 && temp_j >= 0) {
            if (str1.charAt(temp_i) == str2.charAt(temp_j)) {
                chars.add(str1.charAt(temp_i));
                temp_i -= 1;
                temp_j -= 1;
            }
            else if (matrix[temp_i][temp_j + 1] >= matrix[temp_i + 1][temp_j]) {
                temp_i -= 1;
            }
            else {
                temp_j -= 1;
            }
        }
        Collections.reverse(chars);
        StringBuilder answer = new StringBuilder();
        for (char c: chars) {
            answer.append(c);
        }
        return answer.toString();
    }
}
