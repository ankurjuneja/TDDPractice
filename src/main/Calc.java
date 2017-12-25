import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    private static final String DELIMITERS = ",|\n";

    private static int testForGreaterThanThousand(int num) {
        if (num < 0)            throw new RuntimeException();
        else if (num > 1000)    return  0;
        else                    return num;
    }

    public int add(String text){
        //return 0 with empty string
        if(text.isEmpty()) {
            return 0;
        }
        else if(text.contains(",") || text.contains("\n")){
            String[] tokens = tokenize(text);

            return Arrays.stream(tokens)
                    .mapToInt(this::toInt)
                    .map(Calc::testForGreaterThanThousand)
                    .sum();

        }else
            return toInt(text);
    }

    private String[] tokenize(String text){
        if (usesCustomDelimiter(text)) {
            return splitUsingCutomDelimiter(text);
        } else {
            return splitUsingCommasAndNewLine(text);
        }
    }

    private boolean usesCustomDelimiter(String text) {
        return text.startsWith("//");
    }

    private String[] splitUsingCommasAndNewLine(String text) {
        return text.split(DELIMITERS);
    }

    private String[] splitUsingCutomDelimiter(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);
        return numbers.split(customDelimiter);
    }

    private int toInt(String number){
        return Integer.parseInt(number);
    }
}
