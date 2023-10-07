package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static String getForwardedVariables(String configFile) {
        return Arrays.stream(configFile.split("\n"))
                .filter(line -> line.contains("environment="))
                .map(line -> {
                    var kvpStart = line.indexOf("environment=\"") + 13;
                    var kvpEnd = line.indexOf("\"", kvpStart);
                    return line.substring(kvpStart, kvpEnd);
                })
                .flatMap(line -> Arrays.stream(line.split(",")))
                .filter(kvp -> kvp.startsWith("X_FORWARDED_"))
                .map(kvp -> kvp.replaceFirst("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        String configFileContent = "[program:prepare]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "autorestart=false\n" +
                "environment=\"X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"\n" +
                "\n" +
                "[program:http_server]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'\n" +
                "environment=\"key5=value5,X_FORWARDED_var3=value,key6=value6\"";

        System.out.println(getForwardedVariables(configFileContent));
    }
}
//END
