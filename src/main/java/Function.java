import javax.script.*;

public class Function {

    static Object calculate(String str, int x) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        str = str.replaceAll("x", Integer.toString(x));
        if (str.contains("("))
            str = CutString(str);
        if (str.contains("^") || str.contains("cos") || str.contains("sin"))
            str = AdditionalSigns(str);
        Object res = engine.eval(str);
        if (res.toString().equals("Infinity"))
            throw new ArithmeticException();
        return res;
    }

    static Object calculate(String str, double x) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        str = str.replaceAll("x", Double.toString(x));
        if (str.contains("("))
            str = CutString(str);
        if (str.contains("^") || str.contains("cos") || str.contains("sin"))
            str = AdditionalSigns(str);
        Object res = engine.eval(str);
        if (res.toString().equals("Infinity"))
            throw new ArithmeticException();
        return res;
    }

    static Object calculate(String str) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        if (str.contains("^") || str.contains("cos") || str.contains("sin"))
            str = CutString(str);
        Object res = engine.eval(str);
        if (res.toString().equals("Infinity"))
            throw new ArithmeticException();
        return res;
    }

    // Переименовать потом
    static String CutString(String str) {
        int begin = str.indexOf('(');
        int end = begin + 1;
        for (; end != str.indexOf(')'); end++) {
            if (str.charAt(end) == '(') {
                str = str.replace(str.substring(end), CutString(str.substring(end)));
            }
        }
        end++;

        try {
            Object n = calculate(str.substring(begin, end));
            String newString = "";
            newString += n;
            str = str.replace(str.substring(begin, end), newString);
        } catch (ScriptException e) {
            System.out.println("Error");
        }
        return str;
    }

    public static String AdditionalSigns(String str) {
        System.out.println(str);
        if (str.contains("("))
            str = CutString(str);
        System.out.println(str);
        if (str.contains("sin"))
            str = sin(str);
        if (str.contains("cos"))
            str = cos(str);
        return str;
    }

    public static String sin(String str) {
            double num;
            int i = str.indexOf('n') + 1;
            String newStr = "";

            while ((Character.isDigit(str.charAt(i)) || str.charAt(i) == '.' || str.charAt(i)=='-') && i < str.length() - 1) {
                newStr += str.charAt(i);
                i++;
            }
            if (i+1 == str.length())
                if (Character.isDigit(str.charAt(i)))
                    newStr += str.charAt(i);
            try {
                num = Double.parseDouble(newStr);
            } catch (NumberFormatException e) {
                num = (Integer.parseInt(newStr)) * 0.1;
            }
            num = Math.sin(num);
            newStr = "" + num;
            return str.replace(str.substring(str.indexOf('s'), i), newStr);
        }

        public static String cos(String str) {
            double num;
            int i = str.indexOf('s') + 1;
            String newStr = "";
            while ((Character.isDigit(str.charAt(i)) || str.charAt(i) == '.') && i < str.length() - 1) {
                newStr += str.charAt(i);
                i++;
            }
            if (i < str.length())
                if (Character.isDigit(str.charAt(i)))
                    newStr += str.charAt(i);

            try {
                num = Double.parseDouble(newStr);
            } catch (NumberFormatException e) {
                num = (Integer.parseInt(newStr)) * 0.1;
            }
            num = Math.cos(num);
            newStr = "" + num;
            return str.replace(str.substring(str.indexOf('c'), i), newStr);
        }
}

