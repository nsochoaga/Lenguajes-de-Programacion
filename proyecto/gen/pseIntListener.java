// Generated from C:/Users/juand/OneDrive/Documentos/Interprete/AnalizadorSemantico/grammar\pseInt.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pseIntParser}.
 */
public interface pseIntListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pseIntParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(pseIntParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(pseIntParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(pseIntParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(pseIntParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#logicvalues}.
	 * @param ctx the parse tree
	 */
	void enterLogicvalues(pseIntParser.LogicvaluesContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#logicvalues}.
	 * @param ctx the parse tree
	 */
	void exitLogicvalues(pseIntParser.LogicvaluesContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#numbervalues}.
	 * @param ctx the parse tree
	 */
	void enterNumbervalues(pseIntParser.NumbervaluesContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#numbervalues}.
	 * @param ctx the parse tree
	 */
	void exitNumbervalues(pseIntParser.NumbervaluesContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#operrel}.
	 * @param ctx the parse tree
	 */
	void enterOperrel(pseIntParser.OperrelContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#operrel}.
	 * @param ctx the parse tree
	 */
	void exitOperrel(pseIntParser.OperrelContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#opermas}.
	 * @param ctx the parse tree
	 */
	void enterOpermas(pseIntParser.OpermasContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#opermas}.
	 * @param ctx the parse tree
	 */
	void exitOpermas(pseIntParser.OpermasContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#opermul}.
	 * @param ctx the parse tree
	 */
	void enterOpermul(pseIntParser.OpermulContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#opermul}.
	 * @param ctx the parse tree
	 */
	void exitOpermul(pseIntParser.OpermulContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#inicioproceso}.
	 * @param ctx the parse tree
	 */
	void enterInicioproceso(pseIntParser.InicioprocesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#inicioproceso}.
	 * @param ctx the parse tree
	 */
	void exitInicioproceso(pseIntParser.InicioprocesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#finproceso}.
	 * @param ctx the parse tree
	 */
	void enterFinproceso(pseIntParser.FinprocesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#finproceso}.
	 * @param ctx the parse tree
	 */
	void exitFinproceso(pseIntParser.FinprocesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#iniciosubproceso}.
	 * @param ctx the parse tree
	 */
	void enterIniciosubproceso(pseIntParser.IniciosubprocesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#iniciosubproceso}.
	 * @param ctx the parse tree
	 */
	void exitIniciosubproceso(pseIntParser.IniciosubprocesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#finsubproceso}.
	 * @param ctx the parse tree
	 */
	void enterFinsubproceso(pseIntParser.FinsubprocesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#finsubproceso}.
	 * @param ctx the parse tree
	 */
	void exitFinsubproceso(pseIntParser.FinsubprocesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#subproceso}.
	 * @param ctx the parse tree
	 */
	void enterSubproceso(pseIntParser.SubprocesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#subproceso}.
	 * @param ctx the parse tree
	 */
	void exitSubproceso(pseIntParser.SubprocesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#subparametros}.
	 * @param ctx the parse tree
	 */
	void enterSubparametros(pseIntParser.SubparametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#subparametros}.
	 * @param ctx the parse tree
	 */
	void exitSubparametros(pseIntParser.SubparametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#proceso}.
	 * @param ctx the parse tree
	 */
	void enterProceso(pseIntParser.ProcesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#proceso}.
	 * @param ctx the parse tree
	 */
	void exitProceso(pseIntParser.ProcesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(pseIntParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(pseIntParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(pseIntParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(pseIntParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#definir}.
	 * @param ctx the parse tree
	 */
	void enterDefinir(pseIntParser.DefinirContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#definir}.
	 * @param ctx the parse tree
	 */
	void exitDefinir(pseIntParser.DefinirContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#listaGen}.
	 * @param ctx the parse tree
	 */
	void enterListaGen(pseIntParser.ListaGenContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#listaGen}.
	 * @param ctx the parse tree
	 */
	void exitListaGen(pseIntParser.ListaGenContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(pseIntParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(pseIntParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#listaMatrix}.
	 * @param ctx the parse tree
	 */
	void enterListaMatrix(pseIntParser.ListaMatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#listaMatrix}.
	 * @param ctx the parse tree
	 */
	void exitListaMatrix(pseIntParser.ListaMatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void enterListaIds(pseIntParser.ListaIdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void exitListaIds(pseIntParser.ListaIdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(pseIntParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(pseIntParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(pseIntParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(pseIntParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(pseIntParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(pseIntParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#asignar}.
	 * @param ctx the parse tree
	 */
	void enterAsignar(pseIntParser.AsignarContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#asignar}.
	 * @param ctx the parse tree
	 */
	void exitAsignar(pseIntParser.AsignarContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#bool1}.
	 * @param ctx the parse tree
	 */
	void enterBool1(pseIntParser.Bool1Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#bool1}.
	 * @param ctx the parse tree
	 */
	void exitBool1(pseIntParser.Bool1Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#bool2}.
	 * @param ctx the parse tree
	 */
	void enterBool2(pseIntParser.Bool2Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#bool2}.
	 * @param ctx the parse tree
	 */
	void exitBool2(pseIntParser.Bool2Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#bool3}.
	 * @param ctx the parse tree
	 */
	void enterBool3(pseIntParser.Bool3Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#bool3}.
	 * @param ctx the parse tree
	 */
	void exitBool3(pseIntParser.Bool3Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#bool4}.
	 * @param ctx the parse tree
	 */
	void enterBool4(pseIntParser.Bool4Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#bool4}.
	 * @param ctx the parse tree
	 */
	void exitBool4(pseIntParser.Bool4Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#arit1}.
	 * @param ctx the parse tree
	 */
	void enterArit1(pseIntParser.Arit1Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#arit1}.
	 * @param ctx the parse tree
	 */
	void exitArit1(pseIntParser.Arit1Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#arit2}.
	 * @param ctx the parse tree
	 */
	void enterArit2(pseIntParser.Arit2Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#arit2}.
	 * @param ctx the parse tree
	 */
	void exitArit2(pseIntParser.Arit2Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#arit3}.
	 * @param ctx the parse tree
	 */
	void enterArit3(pseIntParser.Arit3Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#arit3}.
	 * @param ctx the parse tree
	 */
	void exitArit3(pseIntParser.Arit3Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#arit4}.
	 * @param ctx the parse tree
	 */
	void enterArit4(pseIntParser.Arit4Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#arit4}.
	 * @param ctx the parse tree
	 */
	void exitArit4(pseIntParser.Arit4Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#arit5}.
	 * @param ctx the parse tree
	 */
	void enterArit5(pseIntParser.Arit5Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#arit5}.
	 * @param ctx the parse tree
	 */
	void exitArit5(pseIntParser.Arit5Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#arit6}.
	 * @param ctx the parse tree
	 */
	void enterArit6(pseIntParser.Arit6Context ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#arit6}.
	 * @param ctx the parse tree
	 */
	void exitArit6(pseIntParser.Arit6Context ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#leer}.
	 * @param ctx the parse tree
	 */
	void enterLeer(pseIntParser.LeerContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#leer}.
	 * @param ctx the parse tree
	 */
	void exitLeer(pseIntParser.LeerContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#escribir}.
	 * @param ctx the parse tree
	 */
	void enterEscribir(pseIntParser.EscribirContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#escribir}.
	 * @param ctx the parse tree
	 */
	void exitEscribir(pseIntParser.EscribirContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(pseIntParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(pseIntParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#si}.
	 * @param ctx the parse tree
	 */
	void enterSi(pseIntParser.SiContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#si}.
	 * @param ctx the parse tree
	 */
	void exitSi(pseIntParser.SiContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#sino}.
	 * @param ctx the parse tree
	 */
	void enterSino(pseIntParser.SinoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#sino}.
	 * @param ctx the parse tree
	 */
	void exitSino(pseIntParser.SinoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(pseIntParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(pseIntParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#paso}.
	 * @param ctx the parse tree
	 */
	void enterPaso(pseIntParser.PasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#paso}.
	 * @param ctx the parse tree
	 */
	void exitPaso(pseIntParser.PasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#mientras}.
	 * @param ctx the parse tree
	 */
	void enterMientras(pseIntParser.MientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#mientras}.
	 * @param ctx the parse tree
	 */
	void exitMientras(pseIntParser.MientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#repetir}.
	 * @param ctx the parse tree
	 */
	void enterRepetir(pseIntParser.RepetirContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#repetir}.
	 * @param ctx the parse tree
	 */
	void exitRepetir(pseIntParser.RepetirContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#segun}.
	 * @param ctx the parse tree
	 */
	void enterSegun(pseIntParser.SegunContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#segun}.
	 * @param ctx the parse tree
	 */
	void exitSegun(pseIntParser.SegunContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#casos}.
	 * @param ctx the parse tree
	 */
	void enterCasos(pseIntParser.CasosContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#casos}.
	 * @param ctx the parse tree
	 */
	void exitCasos(pseIntParser.CasosContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#otro}.
	 * @param ctx the parse tree
	 */
	void enterOtro(pseIntParser.OtroContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#otro}.
	 * @param ctx the parse tree
	 */
	void exitOtro(pseIntParser.OtroContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#esperar}.
	 * @param ctx the parse tree
	 */
	void enterEsperar(pseIntParser.EsperarContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#esperar}.
	 * @param ctx the parse tree
	 */
	void exitEsperar(pseIntParser.EsperarContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#evento}.
	 * @param ctx the parse tree
	 */
	void enterEvento(pseIntParser.EventoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#evento}.
	 * @param ctx the parse tree
	 */
	void exitEvento(pseIntParser.EventoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#tiempo}.
	 * @param ctx the parse tree
	 */
	void enterTiempo(pseIntParser.TiempoContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#tiempo}.
	 * @param ctx the parse tree
	 */
	void exitTiempo(pseIntParser.TiempoContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#limpiar}.
	 * @param ctx the parse tree
	 */
	void enterLimpiar(pseIntParser.LimpiarContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#limpiar}.
	 * @param ctx the parse tree
	 */
	void exitLimpiar(pseIntParser.LimpiarContext ctx);
	/**
	 * Enter a parse tree produced by {@link pseIntParser#limpieza}.
	 * @param ctx the parse tree
	 */
	void enterLimpieza(pseIntParser.LimpiezaContext ctx);
	/**
	 * Exit a parse tree produced by {@link pseIntParser#limpieza}.
	 * @param ctx the parse tree
	 */
	void exitLimpieza(pseIntParser.LimpiezaContext ctx);
}