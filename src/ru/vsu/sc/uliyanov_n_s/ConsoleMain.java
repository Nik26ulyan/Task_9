package ru.vsu.sc.uliyanov_n_s;

import java.io.PrintStream;
import java.util.List;

import ru.vsu.sc.uliyanov_n_s.utils.ArrayAndListUtils;

public class ConsoleMain {
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length == 0) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile = args[0];
            if (args.length > 1) {
                params.outputFile = args[1];
                return params;
            } else
                params.outputFile = null;
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);
        Solution solution = new Solution();

        if (params.help) {
            printHelpMsg(params);
        } else if (params.window) {
            GuiMain.winMain();
        } else {
            List<Integer> list = ArrayAndListUtils.readListFromFile(params.inputFile);
            if (list == null) {
                System.err.printf("Can't read list from \"%s\"%n", params.inputFile);
                System.exit(2);
            }

            List<Integer> resultList = solution.createRightList(list);

            if (params.outputFile != null) {
                ArrayAndListUtils.writeListToFile(params.outputFile, list);
            } else {
                ArrayAndListUtils.printListToConsole(resultList);
            }
        }
    }

    private static void printHelpMsg(CmdParams params) {
        PrintStream out = params.error ? System.err : System.out;
        out.println("Usage:");
        out.println("  <cmd> args <input-file> (<output-file>)");
        out.println("  <cmd> --help");
        out.println("  <cmd> --window  // show window");
        System.exit(params.error ? 1 : 0);
    }
}
