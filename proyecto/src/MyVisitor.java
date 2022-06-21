/*
INTEGRANTES:

- Juan Diego Castañeda Oviedo
- Josué David Briceño Urquijo

*/

import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;


public class MyVisitor<T> extends pseIntBaseVisitor<T> {
    private HashMap<String, pseIntParser.SubprocesoContext> functions = new HashMap<>();
    private HashMap<String, String> functionReturns = new HashMap<>();
    private HashMap<String, Object> variables = new HashMap<>();
    private HashMap<String, String> tiposVariables = new HashMap<>();

    private List<String> vertices = new ArrayList<>();

    private Scanner scan = new Scanner(System.in);

    private double x0 = 0.1;
    private double y0 = 0.8;
    private double a0 = 0.0;
    private double step = 0.07;


    double x_error;
    double y_error;

    private final double radius = 0.01;


    private Turtle turtle = new Turtle(x0, y0, a0);
    private Turtle turtleMain = new Turtle(x0, y0, a0);

    @Override public T visitStart(pseIntParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override public T visitTipo(pseIntParser.TipoContext ctx) {
        return (T) ctx.getText().toLowerCase();
    }

    @Override public T visitLogicvalues(pseIntParser.LogicvaluesContext ctx) {
        return ctx.getText().toLowerCase().equals("verdadero") ? (T) (Boolean) true
                                                 : (T) (Boolean) false;
    }

    @Override public T visitNumbervalues(pseIntParser.NumbervaluesContext ctx) {
        return ctx.TOKEN_ENTERO() != null ? (T) (Double) Double.parseDouble(ctx.TOKEN_ENTERO().getText())
                                          : (T) (Double) Double.parseDouble(ctx.TOKEN_REAL().getText());
    }

    @Override public T visitOperrel(pseIntParser.OperrelContext ctx) {
             if (ctx.TOKEN_IGUAL()       != null) return (T) ctx.TOKEN_IGUAL().getText();
        else if (ctx.TOKEN_DIF()         != null) return (T) ctx.TOKEN_DIF().getText();
        else if (ctx.TOKEN_MAYOR()       != null) return (T) ctx.TOKEN_MAYOR().getText();
        else if (ctx.TOKEN_MAYOR_IGUAL() != null) return (T) ctx.TOKEN_MAYOR_IGUAL().getText();
        else if (ctx.TOKEN_MENOR()       != null) return (T) ctx.TOKEN_MENOR().getText();
        else                                      return (T) ctx.TOKEN_MENOR_IGUAL().getText();
    }

    @Override public T visitOpermas(pseIntParser.OpermasContext ctx) {
        return ctx.TOKEN_MAS() != null ? (T) ctx.TOKEN_MAS().getText()
                                       : (T) ctx.TOKEN_MENOS().getText();
    }

    @Override public T visitOpermul(pseIntParser.OpermulContext ctx) {
        return ctx.TOKEN_DIV() != null ? (T) ctx.TOKEN_DIV().getText()
                                       : (T) ctx.TOKEN_MUL().getText();
    }

    @Override public T visitInicioproceso(pseIntParser.InicioprocesoContext ctx) {

        return visitChildren(ctx);
    }

    @Override public T visitFinproceso(pseIntParser.FinprocesoContext ctx) {
        turtleMain.setPenColor(Color.GREEN);
        turtleMain.filledCircle(turtleMain.getX(), turtle.getY(), radius*2);
        turtleMain.text(turtleMain.getX(), turtleMain.getY()+0.03, "FINALIZADO \n CORRECTAMENTE", Color.BLACK);
        return visitChildren(ctx); }

    @Override public T visitIniciosubproceso(pseIntParser.IniciosubprocesoContext ctx) {

        return visitChildren(ctx);
    }

    @Override public T visitFinsubproceso(pseIntParser.FinsubprocesoContext ctx) {
        return visitChildren(ctx); }

    @Override public T visitSubproceso(pseIntParser.SubprocesoContext ctx) {


        if (ctx.iniciosubproceso() != null) {



            int NID = (ctx.TOKEN_ASIG() != null) ? 1 : 0;
            String id = ctx.ID(NID).getText();
            String ret = (ctx.TOKEN_ASIG() != null) ? ctx.ID(0).getText() : null;

            if (functions.get(id) != null) error("La función ya ha sido declarada anteriormente",
                                                 ctx.ID(NID).getSymbol().getLine(),
                                                 ctx.ID(NID).getSymbol().getCharPositionInLine() + 1, x_error, y_error );

            functions.put(id, ctx);
            functionReturns.put(id, ret);

            if (!ctx.subproceso().getText().isBlank()) {
                visitSubproceso(ctx.subproceso());
            }
        }

        return null;
    }

    @Override public T visitSubparametros(pseIntParser.SubparametrosContext ctx) {
        ArrayList<String> parametros = new ArrayList<>();

        if (ctx != null && ctx.TOKEN_PAR_IZQ() != null) {
            int i = 0;
            while (ctx.ID(i) != null) {
                parametros.add(ctx.ID(i).getText());
                i += 1;
            }
        }

        return (T) parametros;
    }

    @Override public T visitProceso(pseIntParser.ProcesoContext ctx) {

        System.out.println("ENTRA A PROCESOOOOOOO");
        turtle.setPenColor(Color.BLACK);
        turtle.filledCircle(turtle.getX(), turtle.getY(), radius);

        System.out.println("x: " + turtle.getX() + "    y: " + turtle.getY());
        turtle.text(x0-0.05, y0-0.05, ctx.ID().getText(), Color.BLACK);
        turtle.goForward(step);
        turtleMain.goForward(step);
        turtle.show();

        return visitChildren(ctx);
    }

    @Override public T visitComandos(pseIntParser.ComandosContext ctx) { return visitChildren(ctx); }

    @Override public T visitComando(pseIntParser.ComandoContext ctx) { return visitChildren(ctx); }

    @Override public T visitDefinir(pseIntParser.DefinirContext ctx) {
        ArrayList<Object> lista = (ArrayList<Object>) visitListaIds(ctx.listaIds());
        String tipo = (String) visitTipo(ctx.tipo());

        for (int i = 0; i < lista.size(); i++) {
            tiposVariables.put((String) lista.get(i), tipo);
            variables.put((String) lista.get(i), null);
        }

        return null;
    }

    @Override public T visitListaGen(pseIntParser.ListaGenContext ctx) {
        ArrayList<Object> parametros = new ArrayList<>();

        if (ctx.valor() != null) {
            int i = 0;
            while (ctx.valor(i) != null) {
                parametros.add(visitValor(ctx.valor(i)));
                i += 1;
            }
        }

        return (T) parametros;
    }

    @Override public T visitValor(pseIntParser.ValorContext ctx) {
        return ctx.arit1() != null ? visitArit1(ctx.arit1())
                                   : visitBool1(ctx.bool1());
    }

    @Override public T visitListaMatrix(pseIntParser.ListaMatrixContext ctx) {
        String id = ctx.ID().getText();

        if (!variables.containsKey(id)) error("La variable no ha sido declarada.",
                                              ctx.ID().getSymbol().getLine(),
                                              ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        ArrayList<Object> dimensiones = (ArrayList<Object>) visitMatrix(ctx.matrix());

        try {

            if (dimensiones.size() == 1) {

                if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {
                    Integer[] arreglo = new Integer[(int) Math.round((Double) dimensiones.get(0))];
                    variables.put(id, arreglo);
                }
                else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {
                    Double[] arreglo = new Double[(int) Math.round((Double) dimensiones.get(0))];
                    variables.put(id, arreglo);
                }
                else if (tiposVariables.get(id).equals("logico")) {
                    Boolean[] arreglo = new Boolean[(int) Math.round((Double) dimensiones.get(0))];
                    variables.put(id, arreglo);
                }
                else {
                    String[] arreglo = new String[(int) Math.round((Double) dimensiones.get(0))];
                    variables.put(id, arreglo);
                }
            }
            else if (dimensiones.size() == 2) {

                if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {
                    Integer[][] arreglo = new Integer[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))];
                    variables.put(id, arreglo);
                }
                else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {
                    Double[][] arreglo = new Double[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))];
                    variables.put(id, arreglo);
                }
                else if (tiposVariables.get(id).equals("logico")) {
                    Boolean[][] arreglo = new Boolean[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))];
                    variables.put(id, arreglo);
                }
                else {
                    String[][] arreglo = new String[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))];
                    variables.put(id, arreglo);
                }
            }
            else if (dimensiones.size() == 3) {

                if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {
                    Integer[][][] arreglo = new Integer[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))][(int) Math.round((Double) dimensiones.get(2))];
                    variables.put(id, arreglo);
                }
                else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {
                    Double[][][] arreglo = new Double[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))][(int) Math.round((Double) dimensiones.get(2))];
                    variables.put(id, arreglo);
                }
                else if (tiposVariables.get(id).equals("logico")) {
                    Boolean[][][] arreglo = new Boolean[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))][(int) Math.round((Double) dimensiones.get(2))];
                    variables.put(id, arreglo);
                }
                else {
                    String[][][] arreglo = new String[(int) Math.round((Double) dimensiones.get(0))][(int) Math.round((Double) dimensiones.get(1))][(int) Math.round((Double) dimensiones.get(2))];
                    variables.put(id, arreglo);
                }
            }
            else {
                error("Las dimensiones definidas están fuera de rango.",
                        ctx.ID().getSymbol().getLine(),
                        ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
            }

        } catch (Exception e) {

            error("Indices del arreglo fuera de limites", ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        }

        return visitChildren(ctx);
    }

    @Override public T visitListaIds(pseIntParser.ListaIdsContext ctx) {
        ArrayList<Object> parametros = new ArrayList<>();

        if(ctx.ids() != null){
            int i = 0;
            while (ctx.ids(i) != null) {
                parametros.add(visitIds(ctx.ids(i)));
                i += 1;
            }
        }

        return (T) parametros;
    }

    @Override public T visitIds(pseIntParser.IdsContext ctx) {

        if (ctx.matrix() == null) {
            return (T) ctx.ID().getText();
        } else {

            String retorno = "";
            ArrayList<Object> indices = (ArrayList<Object>) visitMatrix(ctx.matrix());

            retorno = retorno + ctx.ID().getText();

            for (int i=0; i<indices.size(); i++) {

                retorno = retorno + " ";
                retorno = retorno + ((Integer) (int) Math.round(((Double) indices.get(i)))).toString();

            }

            return (T) retorno;
        }
    }

    @Override public T visitMatrix(pseIntParser.MatrixContext ctx) {

        ArrayList<Object> indices = (ArrayList<Object>) visitListaGen(ctx.listaGen());


        for (int i=0; i<indices.size(); i++) {

            if (indices.get(i).getClass().equals(Integer.class)) {

                indices.set(i, Double.valueOf((Integer) indices.get(i)));

            } else if (!indices.get(i).getClass().equals(Double.class)) {

                error("Indice no numerico", ctx.TOKEN_COR_DER().getSymbol().getLine(), ctx.TOKEN_COR_DER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            }

        }

        return (T) indices;
    }

    @Override public T visitFunc(pseIntParser.FuncContext ctx) {

        Turtle turtle1 = new Turtle(turtle.getX(), turtle.getY(), a0);

        if(!StdDraw.isStart()) {
            while(!StdDraw.isPaso()){
                turtle.pause(100);
            }
            StdDraw.Paso(false);
        }




        turtle.setPenColor(Color.GREEN);
        turtle.turnLeft(270);
        turtle.goForward(step);
        turtle.filledCircle(turtle.getX(), turtle.getY(), radius);
        x_error = turtle.getX();
        y_error = turtle.getY();
        turtle.text(turtle.getX()-0.05, turtle.getY()-0.03, ctx.ID().getText(), Color.BLUE);
        turtle.setPenColor(Color.GREEN);
        turtle.turnLeft(90);
        turtle.goForward(step);
        turtle1.goForward(step);
        turtleMain.setPenColor(Color.BLACK);
        turtleMain.goForward(step);

        ParserRuleContext padres = ctx.getParent();
        while (!padres.getStart().getText().equals("subproceso")  && !padres.getStart().getText().equals("algoritmo") && !padres.getStart().getText().equals("proceso")){
            padres = padres.getParent();
        }

        if (padres.getStart().getText().equals("subproceso")) {
            System.out.println("ID   " + ctx.ID().getText());
            System.out.println(padres.getTokens(80));
        }




        String id = ctx.ID().getText();

        //g.addEdge(id,"vertex0","vertex1");
        if (functions.get(id) == null) error("La función no ha sido declarada.",
                                             ctx.ID().getSymbol().getLine(),
                                             ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        pseIntParser.SubprocesoContext functionCtx = functions.get(id);

        ArrayList<Object> llamarFuncionParametros = ctx.listaGen() != null
                                                  ? (ArrayList<Object>) visitListaGen(ctx.listaGen())
                                                  : new ArrayList<>();

        ArrayList<String> parametros = (ArrayList<String>) visitSubparametros(functionCtx.subparametros());

        if (llamarFuncionParametros.size() < parametros.size()) error("Faltan parámetros en la función.",
                                                                      ctx.ID().getSymbol().getLine(),
                                                                      ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        if (llamarFuncionParametros.size() > parametros.size()) error("Sobran parámetros en la función.",
                                                                      ctx.ID().getSymbol().getLine(),
                                                                      ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        HashMap<String, Object> copia_variables = new HashMap<>();
        HashMap<String, String> copia_tipoVariables = new HashMap<>();

        copia_tipoVariables.clear();
        copia_tipoVariables = copyMap(tiposVariables);
        tiposVariables.clear();

        copia_variables.clear();
        copia_variables = copyMap(variables);
        variables.clear();

        for (int i = 0; i < parametros.size(); i++) {
            variables.put(parametros.get(i), llamarFuncionParametros.get(i));

                 if (parametros.get(i).getClass().equals(Integer.class)) tiposVariables.put(parametros.get(i), "entero");
            else if (parametros.get(i).getClass().equals(Double.class))  tiposVariables.put(parametros.get(i), "real");
            else if (parametros.get(i).getClass().equals(Boolean.class)) tiposVariables.put(parametros.get(i), "logico");
            else if (parametros.get(i).getClass().equals(String.class))  tiposVariables.put(parametros.get(i), "cadena");
        }

        visitComandos(functionCtx.comandos());

        Object valorRetornado = functionReturns.get(id) != null ? variables.get(functionReturns.get(id)) : null;

        variables.clear();
        variables = copyMap(copia_variables);

        tiposVariables.clear();
        tiposVariables = copyMap(copia_tipoVariables);


        double fin =  retornar();
        double pasoFin = fin - turtle1.getX();
        turtle1.setPenColor(Color.GREEN);
        turtle1.goForward(pasoFin);

        return (T) valorRetornado;
    }

    public static <K, V> HashMap<K, V> copyMap(HashMap<K, V> original)
    {
        HashMap<K, V> second_map = new HashMap<>();
        second_map.putAll(original);

        return second_map;
    }

    @Override public T visitAsignar(pseIntParser.AsignarContext ctx) {
        String id = ctx.ID().getText();

        if (!variables.containsKey(id)) error("La variable " + id + " no ha sido declarada.",
                                              ctx.ID().getSymbol().getLine(),
                                              ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        String tipo = tiposVariables.get(id);
        T valor;

        if (ctx.matrix() == null) {
            valor = ctx.arit1() != null ? visitArit1(ctx.arit1()) : visitBool1(ctx.bool1());

            try {
                if (tipo.equals("entero") || tipo.equals("numero")) {
                    if (valor.getClass().equals(Integer.class)) {
                        variables.put(ctx.ID().getText(), valor);
                    }
                    else if (valor.getClass().equals(Double.class)) {
                        variables.put(ctx.ID().getText(), (int) Math.round( (Double) valor));
                    }
                    else {
                        error("Tipos de datos erróneos",
                              ctx.ID().getSymbol().getLine(),
                              ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
                    }
                } else if (tipo.equals("numerico") || tipo.equals("real")) {
                    if (valor.getClass().equals(Double.class)) {
                        variables.put(ctx.ID().getText(), valor);
                    }
                    else if (valor.getClass().equals(Integer.class)) {
                        variables.put(ctx.ID().getText(), (double) (Integer) valor);
                    }
                    else {
                        error("Tipos de datos erróneos",
                              ctx.ID().getSymbol().getLine(),
                              ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
                    }
                }
                else if (tipo.equals("logico")) {
                    variables.put(ctx.ID().getText(), valor);
                }
                else if (tipo.equals("cadena") || tipo.equals("caracter") || tipo.equals("texto")) {
                    variables.put(ctx.ID().getText(), (String) valor);
                }
            } catch (Exception e) {
                error("El valor asignado no corresponde al tipo de la variable",
                      ctx.ID().getSymbol().getLine(),
                      ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
            }
        }
        else {
            ArrayList<Object> indices = (ArrayList<Object>) visitMatrix(ctx.matrix());

            valor = ctx.arit1() != null ? visitArit1(ctx.arit1()) : visitBool1(ctx.bool1());

            try {

                if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {
                    if (indices.size() == 1) {
                        ((Integer[]) variables.get(id))[(int) Math.round((Double) indices.get(0))] = (int) Math.round((Double) valor);
                    } else if (indices.size() == 2) {
                        ((Integer[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))] = (int) Math.round((Double) valor);
                    } else if (indices.size() == 3) {
                        ((Integer[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))] = (int) Math.round((Double) valor);
                    }
                }
                else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {
                    if (indices.size() == 1) {
                        ((Double[]) variables.get(id))[(int) Math.round((Double) indices.get(0))] = (Double) valor;
                    } else if (indices.size() == 2) {
                        ((Double[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))] = (Double) valor;
                    } else if (indices.size() == 3) {
                        ((Double[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))] = (Double) valor;
                    }
                }
                else if (tiposVariables.get(id).equals("logico")) {

                    if (indices.size() == 1) {
                        ((Boolean[]) variables.get(id))[(int) Math.round((Double) indices.get(0))] = (Boolean) valor;
                    } else if (indices.size() == 2) {
                        ((Boolean[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))] = (Boolean) valor;
                    } else if (indices.size() == 3) {
                        ((Boolean[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))] = (Boolean) valor;
                    }

                }
                else {
                    if (indices.size() == 1) {
                        ((String[]) variables.get(id))[(int) Math.round((Double) indices.get(0))] = (String) valor;
                    } else if (indices.size() == 2) {
                        ((String[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))] = (String) valor;
                    } else if (indices.size() == 3) {
                        ((String[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))] = (String) valor;
                    }
                }

            } catch (Exception e) {

                error("Indices del arreglo fuera de limites", ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            }

        }

        return visitChildren(ctx);
    }

    public double retornar() {
        turtle.setPenColor(Color.green);
        turtle.turnLeft(90);
        turtle.goForward(step);
        turtle.turnLeft(270);
        turtle.goForward(step);
        turtleMain.setPenColor(Color.BLACK);
        turtleMain.goForward(step);
        return turtle.getX();
    }

    @Override public T visitBool1(pseIntParser.Bool1Context ctx) {
        return ctx.TOKEN_O() != null ? (T) (Boolean) ((Boolean) visitBool1(ctx.bool1()) || (Boolean) visitBool2(ctx.bool2()))
                                     : (T) (Boolean) visitBool2(ctx.bool2());
    }

    @Override public T visitBool2(pseIntParser.Bool2Context ctx) {

        return ctx.TOKEN_Y() != null ? (T) (Boolean) ((Boolean) visitBool2(ctx.bool2()) && (Boolean) visitBool3(ctx.bool3()))
                                     : (T) (Boolean) visitBool3(ctx.bool3());
    }

    @Override public T visitBool3(pseIntParser.Bool3Context ctx) {
        return ctx.TOKEN_NO() != null ? (T) (Boolean) !(Boolean) visitBool4(ctx.bool4())
                                      : (T) (Boolean) visitBool4(ctx.bool4());
    }

    @Override public T visitBool4(pseIntParser.Bool4Context ctx) {
        Boolean ans = null;

        if (ctx.TOKEN_PAR_IZQ() != null) return visitBool1(ctx.bool1());

        if (ctx.arit1(0) != null) {
            T operrel = visitOperrel(ctx.operrel());

            try {
                T val1 = visitArit1(ctx.arit1(0));
                T val2 = visitArit1(ctx.arit1(1));

                if (val1.getClass().equals(Integer.class)) val1 = (T) Double.valueOf((Integer) val1);
                if (val2.getClass().equals(Integer.class)) val2 = (T) Double.valueOf((Integer) val2);

                     if (operrel.equals("="))  ans = (val1).equals(val2);
                else if (operrel.equals(">=")) ans = (Double) val1 >= (Double) val2;
                else if (operrel.equals("<=")) ans = (Double) val1 <= (Double) val2;
                else if (operrel.equals("<>")) ans = !(val1).equals(val2);
                else if (operrel.equals(">"))  ans = (Double) val1 > (Double) val2;
                else                           ans = (Double) val1 < (Double) val2;

            }
            catch (Exception e) {
                error("Operación lógica ilegal",
                        ctx.ID().getSymbol().getLine(),
                        ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
            }

        }
        else if (ctx.func() != null) {
            if (visitFunc(ctx.func()).getClass().equals(Boolean.class)) return visitFunc(ctx.func());

            error("La función no retorna un valor lógico",
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
        }
        else if (ctx.ID() != null) {

            String id = ctx.ID().getText();

            if (!variables.containsKey(id)) error("La variable no ha sido declarada",
                                                  ctx.ID().getSymbol().getLine(),
                                                  ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            if (ctx.matrix() == null) {
                if (variables.get(id).getClass().equals(Boolean.class))  return (T) variables.get(id);

                error("La matriz no es de valores lógicos",
                        ctx.ID().getSymbol().getLine(),
                        ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
            }
            else {
                ArrayList<Object> indices = (ArrayList<Object>) visitMatrix(ctx.matrix());

                try {

                    if (tiposVariables.get(id).equals("logico")) {
                        if (indices.size() == 1) return (T) ((Boolean[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                        if (indices.size() == 2) return (T) ((Boolean[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                        if (indices.size() == 3) return (T) ((Boolean[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                    }

                    error("La variable no es de valores lógicos",
                            ctx.ID().getSymbol().getLine(),
                            ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                } catch (Exception e) {

                    error("Indices del arreglo fuera de limites", ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                }

            }
        }
        else {
            return visitLogicvalues(ctx.logicvalues());
        }

        return (T) ans;
    }

    @Override public T visitArit1(pseIntParser.Arit1Context ctx) {
        Double ans = null;

        if (ctx.arit1() != null) {
            try {
                T val1 = visitArit1(ctx.arit1());
                T val2 = visitArit2(ctx.arit2());

                if (val1.getClass().equals(Integer.class)) val1 = (T) Double.valueOf((Integer) val1);
                if (val2.getClass().equals(Integer.class)) val2 = (T) Double.valueOf((Integer) val2);

                ans = (Double) val1 % (Double) val2;
            }
            catch (Exception e) {
                error("La variable no es de valores lógicos",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine() + 1, x_error, y_error);
            }
        }
        else {
            return visitArit2(ctx.arit2());
        }

        return (T) ans;
    }

    @Override public T visitArit2(pseIntParser.Arit2Context ctx) {
        Double ans = null;

        if (ctx.arit2() != null) {
            try {

                T val1 = visitArit2(ctx.arit2());
                T val2 = visitArit3(ctx.arit3());

                if (val1.getClass().equals(Integer.class)) val1 = (T) Double.valueOf((Integer) val1);
                if (val2.getClass().equals(Integer.class)) val2 = (T) Double.valueOf((Integer) val2);

                if (visitOpermas(ctx.opermas()).equals("+")) ans = (Double) val1 + (Double) val2;
                else                                         ans = (Double) val1 - (Double) val2;
            }
            catch (Exception e) {
                error("Lo suminstrado no corresponde a valores operables",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine() + 1, x_error, y_error);
            }
        }
        else {
            return visitArit3(ctx.arit3());
        }

        return (T) ans;
    }

    @Override public T visitArit3(pseIntParser.Arit3Context ctx) {
        Double ans = null;

        if (ctx.arit3() != null) {
            try {
                T val1 = visitArit3(ctx.arit3());
                T val2 = visitArit4(ctx.arit4());

                if (val1.getClass().equals(Integer.class)) val1 = (T) Double.valueOf((Integer) val1);
                if (val2.getClass().equals(Integer.class)) val2 = (T) Double.valueOf((Integer) val2);

                if (visitOpermul(ctx.opermul()).equals("/")) ans = (Double) val1 / (Double) val2;
                else                                         ans = (Double) val1 * (Double) val2;

            }
            catch (Exception e) {
                error("Lo suminstrado no corresponde a valores operables",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine() + 1, x_error, y_error);
            }
        }
        else {
            return visitArit4(ctx.arit4());
        }

        return (T) ans;
    }

    @Override public T visitArit4(pseIntParser.Arit4Context ctx) {
        Double ans = null;

        if (ctx.arit4() != null) {
            try {
                T val1 = visitArit4(ctx.arit4());
                T val2 = visitArit5(ctx.arit5());

                if (val1.getClass().equals(Integer.class)) val1 = (T) Double.valueOf((Integer) val1);
                if (val2.getClass().equals(Integer.class)) val2 = (T) Double.valueOf((Integer) val2);

                ans = Math.pow((Double) val1, (Double) val2);

            }
            catch (Exception e) {
                error("Lo suminstrado no corresponde a valores operables",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine() + 1, x_error, y_error);
            }
        } else {
            return visitArit5(ctx.arit5());
        }

        return (T) ans;
    }

    @Override public T visitArit5(pseIntParser.Arit5Context ctx) {
        Double ans = null;

        if (ctx.TOKEN_MENOS() != null) {
            try {
                T val1 = visitArit6(ctx.arit6());

                if (val1.getClass().equals(Integer.class))  val1 = (T) Double.valueOf((Integer) val1);

                ans = -1 * (Double) val1;

            }
            catch (Exception e) {
                error("Lo suminstrado no corresponde a valores operables",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine() + 1, x_error, y_error);
            }
        } else {
            return visitArit6(ctx.arit6());
        }

        return (T) ans;
    }

    @Override public T visitArit6(pseIntParser.Arit6Context ctx) {
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();

            if (!variables.containsKey(id)) error("La variable no ha sido declarada",
                                                   ctx.ID().getSymbol().getLine(),
                                                   ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            if (ctx.matrix() == null) return (T) variables.get(id);

            ArrayList<Object> indices = (ArrayList<Object>) visitMatrix(ctx.matrix());

            try {

                if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {
                    if (indices.size() == 1) return (T) ((Integer[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                    if (indices.size() == 2) return (T) ((Integer[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                    if (indices.size() == 3) return (T) ((Integer[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                }
                if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {
                    if (indices.size() == 1) return (T) ((Double[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                    if (indices.size() == 2) return (T) ((Double[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                    if (indices.size() == 3) return (T) ((Double[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                }
                if (tiposVariables.get(id).equals("logico")) {
                    if (indices.size() == 1) return (T) ((Boolean[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                    if (indices.size() == 2) return (T) ((Boolean[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                    if (indices.size() == 3) return (T) ((Boolean[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                }

                if (indices.size() == 1) return (T) ((String[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                if (indices.size() == 2) return (T) ((String[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                if (indices.size() == 3) return (T) ((String[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];

            } catch (Exception e) {

                error("Indices del arreglo fuera de limites", ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            }


        }
        else if (ctx.numbervalues() != null)  return visitNumbervalues(ctx.numbervalues());
        else if (ctx.TOKEN_PAR_IZQ() != null) return visitArit1(ctx.arit1());
        else if (ctx.TOKEN_CADENA() != null)  return (T)ctx.TOKEN_CADENA().getText();
        else if (ctx.logicvalues() != null)   return visitLogicvalues(ctx.logicvalues());
        else if (ctx.func() != null)          return visitFunc(ctx.func());

        return visitChildren(ctx);
    }

    @Override public T visitLeer(pseIntParser.LeerContext ctx) {

        ArrayList<Object> lista = (ArrayList<Object>) visitListaIds(ctx.listaIds());
        String value = "13";
        String id;
        ArrayList<String> arreglo = new ArrayList<>();

        for (int i=0; i<lista.size(); i++) {

            value = scan.next();
            id = (String) lista.get(i);

            if (id.contains(" ")) {

                arreglo.clear();
                arreglo.addAll(Arrays.asList(id.split(" ")));
                id = arreglo.get(0);
                arreglo.remove(0);

                if (variables.containsKey(id)) {

                    try {

                        if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {

                            try {

                                if (arreglo.size() == 1) {
                                    ((Integer[]) variables.get(id))[Integer.parseInt(arreglo.get(0))] = Integer.parseInt(value);
                                } else if (arreglo.size() == 2) {
                                    ((Integer[][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))] = Integer.parseInt(value);
                                } else if (arreglo.size() == 3) {
                                    ((Integer[][][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))][Integer.parseInt(arreglo.get(2))] = Integer.parseInt(value);
                                }

                            } catch (Exception e) {

                                try {

                                    if (arreglo.size() == 1) {
                                        ((Integer[]) variables.get(id))[Integer.parseInt(arreglo.get(0))] = (int) Math.round(Double.parseDouble(value));
                                    } else if (arreglo.size() == 2) {
                                        ((Integer[][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))] = (int) Math.round(Double.parseDouble(value));
                                    } else if (arreglo.size() == 3) {
                                        ((Integer[][][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))][Integer.parseInt(arreglo.get(2))] = (int) Math.round(Double.parseDouble(value));
                                    }


                                } catch (Exception d) {

                                    error("Indices del arreglo fuera de limites", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                                }

                            }


                        } else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {

                            try {

                                if (arreglo.size() == 1) {
                                    ((Double[]) variables.get(id))[Integer.parseInt(arreglo.get(0))] = Double.parseDouble(value);
                                } else if (arreglo.size() == 2) {
                                    ((Double[][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))] = Double.parseDouble(value);
                                } else if (arreglo.size() == 3) {
                                    ((Double[][][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))][Integer.parseInt(arreglo.get(2))] = Double.parseDouble(value);
                                }

                            } catch (Exception e) {

                                try {

                                    if (arreglo.size() == 1) {
                                        ((Double[]) variables.get(id))[Integer.parseInt(arreglo.get(0))] = Double.valueOf(Integer.parseInt(value));
                                    } else if (arreglo.size() == 2) {
                                        ((Double[][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))] = Double.valueOf(Integer.parseInt(value));
                                    } else if (arreglo.size() == 3) {
                                        ((Double[][][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))][Integer.parseInt(arreglo.get(2))] = Double.valueOf(Integer.parseInt(value));
                                    }

                                } catch (Exception d) {

                                    error("Valor no valido para la variable", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                                }

                            }

                        } else if (tiposVariables.get(id).equals("cadena") || tiposVariables.get(id).equals("caracter") || tiposVariables.get(id).equals("texto")) {


                            if (arreglo.size() == 1) {
                                ((String[]) variables.get(id))[Integer.parseInt(arreglo.get(0))] = '"' + value + '"';
                            } else if (arreglo.size() == 2) {
                                ((String[][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))] = '"' + value + '"';
                            } else if (arreglo.size() == 3) {
                                ((String[][][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))][Integer.parseInt(arreglo.get(2))] = '"' + value + '"';
                            }


                        } else if (tiposVariables.get(id).equals("logico")) {

                            Boolean boolvalue = null;

                            if (value.toLowerCase().equals("verdadero")) {
                                boolvalue = true;
                            } else if (value.toLowerCase().equals("falso")) {
                                boolvalue = false;
                            } else {

                                error("Valor no valido para la variable", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                            }

                            if (arreglo.size() == 1) {
                                ((Boolean[]) variables.get(id))[Integer.parseInt(arreglo.get(0))] = boolvalue;
                            } else if (arreglo.size() == 2) {
                                ((Boolean[][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))] = boolvalue;
                            } else if (arreglo.size() == 3) {
                                ((Boolean[][][]) variables.get(id))[Integer.parseInt(arreglo.get(0))][Integer.parseInt(arreglo.get(1))][Integer.parseInt(arreglo.get(2))] = boolvalue;
                            }

                        }

                    } catch (Exception e) {

                        error("Indice del arreglo fuera de limites", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                    }

                } else {

                    error("La variable no ha sido declarada", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);


                }


            } else {


                if (variables.containsKey(id)) {

                    if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {

                        try {

                            variables.put(id, Integer.parseInt(value));

                        } catch (Exception e) {

                            try {

                                variables.put(id, (int) Math.round(Double.parseDouble(value)));

                            } catch (Exception d) {

                                error("Valor no valido para la variable", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                            }

                        }


                    } else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {

                        try {

                            variables.put(id, Double.parseDouble(value));

                        } catch (Exception e) {

                            try {

                                variables.put(id, Double.valueOf(Integer.parseInt(value)));

                            } catch (Exception d) {

                                error("Valor no valido para la variable", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1,x_error, y_error);

                            }

                        }

                    } else if (tiposVariables.get(id).equals("cadena") || tiposVariables.get(id).equals("caracter") || tiposVariables.get(id).equals("texto")) {

                        variables.put(id, '"' + value + '"');

                    } else if (tiposVariables.get(id).equals("logico")) {

                        if (value.toLowerCase().equals("verdadero")) {
                            variables.put(id, true);
                        } else if (value.toLowerCase().equals("falso")) {
                            variables.put(id, false);
                        } else {

                            error("Valor no valido para la variable", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
                        }

                    }

                } else {

                    error("La variable no ha sido declarada", ctx.LEER().getSymbol().getLine(), ctx.LEER().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                }

            }


        }

        return null;
    }

    @Override public T visitEscribir(pseIntParser.EscribirContext ctx) {
        String impresion = "";

        if (ctx.listaGen() != null) {
            ArrayList<Object> valores_impresion = (ArrayList<Object>)visitListaGen(ctx.listaGen());

            for (int i = 0; i < valores_impresion.size(); i++) {
                     if (valores_impresion.get(i) == null)                         impresion = impresion + " " + "NULO";
                else if (valores_impresion.get(i).equals(true))                    impresion = impresion + " " + "verdadero";
                else if (valores_impresion.get(i).equals(false))                   impresion = impresion + " " + "falso";
                else if (valores_impresion.get(i).getClass().equals(String.class)) impresion = impresion + " " + valores_impresion.get(i).toString().substring(1, valores_impresion.get(i).toString().length()-1);
                else                                                               impresion = impresion + " " + valores_impresion.get(i);
            }

            System.out.println(impresion);
        }

        return null;
    }

    @Override public T visitDimension(pseIntParser.DimensionContext ctx) { return visitChildren(ctx); }

    @Override public T visitSi(pseIntParser.SiContext ctx) {
        if ((Boolean) visitBool1(ctx.bool1())) visitComandos(ctx.comandos());
        else visitSino(ctx.sino());

        return null;
    }

    @Override public T visitSino(pseIntParser.SinoContext ctx) {
        if (ctx.comandos() != null) visitComandos(ctx.comandos());

        return null;
    }

    @Override public T visitPara(pseIntParser.ParaContext ctx) {
        String id = ctx.ID().getText();

        if (!variables.containsKey(id)) error("La variable no ha sido declarada",
                                               ctx.ID().getSymbol().getLine(),
                                               ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        String tipo = tiposVariables.get(id);
        T valor_inicial = visitArit1(ctx.arit1(0));
        T valor_final = visitArit1(ctx.arit1(1));

        if (tipo.equals("entero") || tipo.equals("numero")) {
            Integer paso = 1;
            T pasoResult = visitPaso(ctx.paso());

            if (pasoResult != null) {
                     if (pasoResult.getClass().equals(Integer.class)) paso = (Integer) pasoResult;
                else if (pasoResult.getClass().equals(Double.class))  paso = (int) Math.round( (Double) pasoResult);
                else                                                  error("Tipo de dato erroneo",
                                                                            ctx.ID().getSymbol().getLine(),
                                                                            ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
            }

            if (valor_inicial.getClass().equals(Integer.class))     variables.put(id, (Integer) valor_inicial);
            else if (valor_inicial.getClass().equals(Double.class)) variables.put(id, (int) Math.round( (Double) valor_inicial));
            else                                                    error("Tipo de dato erroneo",
                                                                          ctx.ID().getSymbol().getLine(),
                                                                          ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            if (valor_final.getClass().equals(Integer.class))     valor_final = (T) (Integer) valor_final;
            else if (valor_final.getClass().equals(Double.class)) valor_final = (T) (Integer) (int) Math.round( (Double) valor_final);
            else                                                  error("Tipo de dato erroneo",
                                                                  ctx.ID().getSymbol().getLine(),
                                                                  ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            while ((Integer) variables.get(id) <= (Integer) valor_final) {
                visitComandos(ctx.comandos());
                variables.put(id, (Integer) variables.get(id) + paso);
            }

        }
        else if (tipo.equals("numerico") || tipo.equals("real")) {
            Double paso = 1.0;
            T pasoResult = visitPaso(ctx.paso());

            if (pasoResult != null) {
                if (pasoResult.getClass().equals(Double.class))       paso = (Double) pasoResult;
                else if (pasoResult.getClass().equals(Integer.class)) paso = Double.valueOf((Integer) pasoResult);
                else                                                  error("Tipo de dato erroneo",
                                                                            ctx.ID().getSymbol().getLine(),
                                                                            ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);
            }

            if (valor_inicial.getClass().equals(Double.class)) variables.put(ctx.ID().getText(), (Double) valor_inicial);
            else if (valor_inicial.getClass().equals(Integer.class)) variables.put(ctx.ID().getText(), (double) (Integer) valor_inicial);
            else                                                      error("Tipo de dato erroneo",
                                                                            ctx.ID().getSymbol().getLine(),
                                                                            ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            if (valor_final.getClass().equals(Double.class))       valor_final = (T) (Double) valor_final;
            else if (valor_final.getClass().equals(Integer.class)) valor_final = (T) Double.valueOf((Integer) valor_final);
            else                                                   error("Tipo de dato erroneo",
                                                                         ctx.ID().getSymbol().getLine(),
                                                                         ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            while ((Double) variables.get(id) <= (Double) valor_final) {
                visitComandos(ctx.comandos());
                variables.put(id, (Double) variables.get(id) + paso);
            }
        }
        else error("Tipo de dato no operable aritméticamente",
                    ctx.ID().getSymbol().getLine(),
                    ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

        return null;
    }

    @Override public T visitPaso(pseIntParser.PasoContext ctx) {
        if (ctx.arit1() != null) return visitArit1(ctx.arit1());

        return null;
    }

    @Override public T visitMientras(pseIntParser.MientrasContext ctx) {
        while ((Boolean) visitBool1(ctx.bool1())) visitComandos(ctx.comandos());

        return null;
    }

    @Override public T visitRepetir(pseIntParser.RepetirContext ctx) {
        while (!(Boolean) visitBool1(ctx.bool1())) visitComandos(ctx.comandos());

        return null;
    }

    @Override public T visitSegun(pseIntParser.SegunContext ctx) {
        T value = (T) null;
        T compare = (T) null;

        if (ctx.ID() != null) {
            String id = ctx.ID().getText();

            if (!variables.containsKey(id)) error("La variable no ha sido declarada",
                                                   ctx.ID().getSymbol().getLine(),
                                                   ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

            if (ctx.matrix() == null) value = (T) variables.get(id);
            else {
                ArrayList<Object> indices = (ArrayList<Object>) visitMatrix(ctx.matrix());

                try {

                    if (tiposVariables.get(id).equals("entero") || tiposVariables.get(id).equals("numero")) {
                        if (indices.size() == 1) value = (T) ((Integer[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                        else if (indices.size() == 2) value = (T) ((Integer[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                        else if (indices.size() == 3) value = (T) ((Integer[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];

                    }
                    else if (tiposVariables.get(id).equals("real") || tiposVariables.get(id).equals("numerico")) {
                        if (indices.size() == 1) value = (T) ((Double[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                        else if (indices.size() == 2) value = (T) ((Double[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                        else if (indices.size() == 3) value = (T) ((Double[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                    }
                    else if (tiposVariables.get(id).equals("logico")) {
                        if (indices.size() == 1) value = (T) ((Boolean[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                        else if (indices.size() == 2) value = (T) ((Boolean[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                        else if (indices.size() == 3) value = (T) ((Boolean[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                    }
                    else {
                        if (indices.size() == 1) value = (T) ((String[]) variables.get(id))[(int) Math.round((Double) indices.get(0))];
                        else if (indices.size() == 2) value = (T) ((String[][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))];
                        else if (indices.size() == 3) value = (T) ((String[][][]) variables.get(id))[(int) Math.round((Double) indices.get(0))][(int) Math.round((Double) indices.get(1))][(int) Math.round((Double) indices.get(2))];
                    }

                } catch (Exception e) {

                    error("Indices del arreglo fuera de limites", ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine() + 1, x_error, y_error);

                }
            }

            if (value.getClass().equals(Integer.class)) value = (T) Double.valueOf((Integer) value);

            pseIntParser.CasosContext actualCaso = ctx.casos();

            while (!actualCaso.getText().isBlank()) {
                if (actualCaso.bool1() != null) compare = (T) (Boolean) visitBool1(actualCaso.bool1());
                else if (actualCaso.arit1() != null) {
                    compare = visitArit1(actualCaso.arit1());

                    if (compare.getClass().equals(Integer.class)) compare = (T) Double.valueOf((Integer) compare);
                }

                if (value.equals(compare)) {
                    visitComandos(actualCaso.comandos());
                    return null;
                }

                actualCaso = actualCaso.casos();
            }

            if (!ctx.otro().getText().isBlank()) {
                visitComandos(ctx.otro().comandos());
                return null;
            }
        }

        return null;
    }

    @Override public T visitCasos(pseIntParser.CasosContext ctx) {
        return visitChildren(ctx);
    }

    @Override public T visitOtro(pseIntParser.OtroContext ctx) { return visitChildren(ctx); }

    @Override public T visitEsperar(pseIntParser.EsperarContext ctx) { return visitChildren(ctx); }

    @Override public T visitEvento(pseIntParser.EventoContext ctx) { return visitChildren(ctx); }

    @Override public T visitTiempo(pseIntParser.TiempoContext ctx) { return visitChildren(ctx); }

    @Override public T visitLimpiar(pseIntParser.LimpiarContext ctx) { return visitChildren(ctx); }

    @Override public T visitLimpieza(pseIntParser.LimpiezaContext ctx) { return visitChildren(ctx); }

    private void error(String error, int row, int col, double x, double y) {
        System.out.printf("<%d, %d> Error semántico. %s\n", row, col, error);
        turtle.text(x+0.25, y+0.02, error, Color.red);
        turtle.filledCircle(x, y, radius);
        Turtle err = new Turtle(x,y, a0);
        err.goForward(step*3);

        while (true);
        //System.exit(-1);
    }

}