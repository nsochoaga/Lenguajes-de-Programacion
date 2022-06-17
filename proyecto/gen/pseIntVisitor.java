// Generated from C:/Users/juand/OneDrive/Documentos/Interprete/AnalizadorSemantico/grammar\pseInt.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pseIntParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pseIntVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pseIntParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(pseIntParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(pseIntParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#logicvalues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicvalues(pseIntParser.LogicvaluesContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#numbervalues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbervalues(pseIntParser.NumbervaluesContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#operrel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperrel(pseIntParser.OperrelContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#opermas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpermas(pseIntParser.OpermasContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#opermul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpermul(pseIntParser.OpermulContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#inicioproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicioproceso(pseIntParser.InicioprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#finproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinproceso(pseIntParser.FinprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#iniciosubproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniciosubproceso(pseIntParser.IniciosubprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#finsubproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinsubproceso(pseIntParser.FinsubprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#subproceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubproceso(pseIntParser.SubprocesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#subparametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubparametros(pseIntParser.SubparametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#proceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProceso(pseIntParser.ProcesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(pseIntParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(pseIntParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#definir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinir(pseIntParser.DefinirContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#listaGen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaGen(pseIntParser.ListaGenContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(pseIntParser.ValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#listaMatrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaMatrix(pseIntParser.ListaMatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#listaIds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaIds(pseIntParser.ListaIdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#ids}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIds(pseIntParser.IdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(pseIntParser.MatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(pseIntParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#asignar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignar(pseIntParser.AsignarContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#bool1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool1(pseIntParser.Bool1Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#bool2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool2(pseIntParser.Bool2Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#bool3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool3(pseIntParser.Bool3Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#bool4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool4(pseIntParser.Bool4Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#arit1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArit1(pseIntParser.Arit1Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#arit2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArit2(pseIntParser.Arit2Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#arit3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArit3(pseIntParser.Arit3Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#arit4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArit4(pseIntParser.Arit4Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#arit5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArit5(pseIntParser.Arit5Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#arit6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArit6(pseIntParser.Arit6Context ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#leer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeer(pseIntParser.LeerContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#escribir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscribir(pseIntParser.EscribirContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(pseIntParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#si}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSi(pseIntParser.SiContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#sino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSino(pseIntParser.SinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(pseIntParser.ParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#paso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPaso(pseIntParser.PasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#mientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMientras(pseIntParser.MientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#repetir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetir(pseIntParser.RepetirContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#segun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegun(pseIntParser.SegunContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#casos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasos(pseIntParser.CasosContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#otro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtro(pseIntParser.OtroContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#esperar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEsperar(pseIntParser.EsperarContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#evento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvento(pseIntParser.EventoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#tiempo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTiempo(pseIntParser.TiempoContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#limpiar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimpiar(pseIntParser.LimpiarContext ctx);
	/**
	 * Visit a parse tree produced by {@link pseIntParser#limpieza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimpieza(pseIntParser.LimpiezaContext ctx);
}