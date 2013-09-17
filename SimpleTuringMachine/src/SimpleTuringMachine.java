
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.Arrays;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;


public class SimpleTuringMachine extends API_List{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        String fileName = "";
        if (args.length > 1) {
            System.out.println("Incorrect input! input example:");
            System.out.println("java SimpleTuringMachine lw_code.lw");
            System.exit(0);
        } else if (args.length == 1) {
            if (!args[0].endsWith(".lw")) {
                System.out.println("Input file must be a .lw file");
                System.exit(0);
            } else {
                fileName = args[0];
            }
        } else {
            fileName = "helloWorld.lw";
        }      
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No such a file: " + fileName);
            System.exit(0);
        }
        
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        File t = new File("javacode");
        if (!t.exists()) {
            t.createNewFile();
        }
        String allcode = "";
        String codeLine = "";
        pw.println("import java.io.File;");
        pw.println("public class TuringMachine extends Run_Model {");
        allcode = allcode + "import java.io.File;\n\r"
                + "public class TuringMachine extends Run_Model {\n\r";
        for (int i = 1;(codeLine = br.readLine()) != null;i ++) {
            if (codeLine.contains("function")) {
                codeLine = codeLine.replace("function", "public");
            }
            if (codeLine.contains("throwExc")) {
                codeLine = codeLine.replace("throwExc", "throws Exception");
            }
            if (codeLine.contains("condition_Loop")) {
                codeLine = codeLine.replace("condition_Loop", "while");
            }
            if (codeLine.contains("for_Loop")) {
                codeLine = codeLine.replace("for_Loop", "for");
            }
            pw.println("    " + codeLine);
            allcode = allcode + "    " + codeLine + "\n\r";
        }
        pw.println("    public static void main(String args[]) throws Exception {");
        pw.println("        System.out.println(\"Load compiler successfully\");");
        pw.println("        TuringMachine tm = new TuringMachine();");
        pw.println("        tm.init();");
        pw.println("    }");
        pw.println("}");
        
        allcode = allcode + "    public static void main(String args[]) throws Exception {\n\r"
                + "        System.out.println(\"Load compiler successfully\");\n\r"
                + "        TuringMachine tm = new TuringMachine();\n\r"
                + "        tm.init();\n\r"
                + "    }\n\r"
                + "}\n\r";
        
        PrintWriter pwtest = new PrintWriter(t);
        pwtest.println(allcode);
        
        JavaFileObject fileObject = new JavaSourceFromString("TuringMachine", sw.toString());
        Iterable<? extends JavaFileObject> cUnits = Arrays.asList(fileObject);
        DiagnosticCollector<JavaFileObject> diagnostics = null;
        diagnostics = new DiagnosticCollector<JavaFileObject>();
        CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, cUnits);
        
        boolean compileSuccess = task.call();
        
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));
        }
        if (compileSuccess) {
            System.out.println("Compile successfully complete");
        }
        if (compileSuccess) {
            try {
                Class.forName("TuringMachine").getDeclaredMethod("main",
			new Class[] { String[].class }).invoke(null,
                        new Object[] { null });
            } catch (ClassNotFoundException e) {
		System.err.println("Class not found: " + e);
            } catch (NoSuchMethodException e) {
		System.err.println("No such method: " + e);
            } catch (IllegalAccessException e) {
                System.err.println("Illegal access: " + e);
            }
        }
    }
    
    static class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

	JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/')
                    + Kind.SOURCE.extension), Kind.SOURCE);
            System.out.println("string:///" + name.replace('.', '/') + Kind.SOURCE.extension);
            this.code = code;
            System.out.println(this.code);
	}
        @Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
	}

    }
}
