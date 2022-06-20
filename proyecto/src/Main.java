/*
INTEGRANTES:

- Juan Diego Castañeda Oviedo
- Josué David Briceño Urquijo

*/

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromFileName("input/entrada.txt");

        pseIntLexer lexer = new pseIntLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        pseIntParser parser = new pseIntParser(tokens);
        ParseTree tree = parser.start();

        MyVisitor<Object> loader = new MyVisitor<>();
        loader.visit(tree);

    }


}

