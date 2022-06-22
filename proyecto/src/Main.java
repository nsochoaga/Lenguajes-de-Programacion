import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromFileName("pruebas/prueba4.txt");

        pseIntLexer lexer = new pseIntLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        pseIntParser parser = new pseIntParser(tokens);
        ParseTree tree = parser.start();

        MyVisitor<Object> loader = new MyVisitor<>();
        loader.visit(tree);

    }


}

