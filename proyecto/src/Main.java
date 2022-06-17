/*
INTEGRANTES:

- Juan Diego Castañeda Oviedo
- Josué David Briceño Urquijo

*/

import edu.uci.ics.jung.visualization.renderers.EdgeArrowRenderingSupport;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;



public class Main {

    public static void main(String [] args) throws Exception {

        CharStream input = CharStreams.fromFileName("input/entrada.txt");

        pseIntLexer lexer = new pseIntLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        pseIntParser parser = new pseIntParser(tokens);
        ParseTree tree = parser.start();

        MyVisitor<Object> loader = new MyVisitor<>();
        loader.visit(tree);
        DirectedSparseGraph g = loader.grafofinal();
        VisualizationViewer<String, String> vv =
                new VisualizationViewer<String, String>(
                        new CircleLayout<String, String>(g), new Dimension(600,600));
        Transformer<String, String> transformer = new Transformer<String, String>() {
            @Override public String transform(String arg0) { return arg0; }
        };
        vv.getRenderContext().setVertexLabelTransformer(transformer);
        transformer = new Transformer<String, String>() {
            @Override public String transform(String arg0) { return arg0; }
        };
        vv.getRenderContext().setEdgeLabelTransformer(transformer);
        vv.getRenderer().setVertexRenderer(new MyRenderer());


        // The following code adds capability for mouse picking of vertices/edges. Vertices can even be moved!
        final DefaultModalGraphMouse<String,Number> graphMouse = new DefaultModalGraphMouse<String,Number>();
        vv.setGraphMouse(graphMouse);
        graphMouse.setMode(ModalGraphMouse.Mode.PICKING);

        JFrame frame = new JFrame();
        frame.getContentPane().add(vv);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(5000);
        g.addVertex("prueba");
        frame.setVisible(true);
        Thread.sleep(5000);
        g.addEdge("edge","negar","prueba");
        frame.setVisible(true);
    }

    static class MyRenderer implements Renderer.Vertex<String, String> {
        @Override public void paintVertex(RenderContext<String, String> rc,
                                          Layout<String, String> layout, String vertex) {
            GraphicsDecorator graphicsContext = rc.getGraphicsContext();
            Point2D center = layout.transform(vertex);
            Shape shape = null;
            Color color = null;
            shape = new Ellipse2D.Double(center.getX()-20, center.getY()-20, 40, 40);
            color = new Color(0, 127, 127);

            graphicsContext.setPaint(color);
            graphicsContext.fill(shape);
        }

    }


    }
