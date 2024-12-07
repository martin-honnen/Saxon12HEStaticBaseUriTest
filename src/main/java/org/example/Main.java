package org.example;

import net.sf.saxon.s9api.*;

import java.io.File;


public class Main {
    public static void main(String[] args) throws SaxonApiException {

        String cwd = System.getProperty("user.dir");//new File(".").getAbsolutePath();

        System.out.println(cwd);

        Processor processor = new Processor(false);

        XPathCompiler compiler = processor.newXPathCompiler();

        compiler.setBaseURI(new File(cwd).toURI());

        String result = compiler.evaluateSingle("'Static base URI in XPath is ' || static-base-uri()", null).getStringValue();

        System.out.println(result);

        XQueryCompiler xqueryCompiler = processor.newXQueryCompiler();

        xqueryCompiler.setBaseURI(new File(cwd).toURI());

        XQueryEvaluator xqueryEvaluator = xqueryCompiler.compile("'Static base URI in XQuery is ' || static-base-uri()").load();

        result = xqueryEvaluator.evaluateSingle().getStringValue();

        System.out.println(result);
    }
}