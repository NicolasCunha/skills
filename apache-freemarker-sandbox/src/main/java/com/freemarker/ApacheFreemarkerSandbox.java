package com.freemarker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Main class to study and learn Apache FreeMarker.
 * As always, <a href="https://freemarker.apache.org/docs/index.html">read the docs!</a>
 */
public class ApacheFreemarkerSandbox {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApacheFreemarkerSandbox.class);

    public static void main(String[] args) throws Exception {
        final ApacheFreemarkerSandbox sandbox = new ApacheFreemarkerSandbox();
        sandbox.boot();
    }

    public void boot() throws Exception {
        /*
         String containing an Apache Freemarker template.
         A template is a text file or character sequence written in FTL (Freemarker Template Language),
         which is a simple and specialized language that allows developers to create
         a template which receives data and create an output.
         https://freemarker.apache.org/docs/dgui_template_overallstructure.html
        */
        final String template = "Hello, ${user}. How are you? This is a template from a String. \n" +
                "You have the following items in your cart: \n" +
                "<#list items as item> " +
                "Item: ${item.name} / Qty: ${item.qty} \n" +
                "</#list> ";
        /*
         Map object that represents a data-model.
         A data model is a structure that contains the data which will be used in the template, normally represented by a JavaBean or any hash-like structure (such as Map).
         The keys are used in the template and will be replaced with the content.
         https://freemarker.apache.org/docs/dgui_quickstart_datamodel.html
        */
        final Map<String, Object> model = new HashMap<>();
        model.put("user", "Nicolas Cunha");
        model.put("items", getSampleItems());
        /*
        Simple test creating an output from a template String.
         */
        final FreemarkerOutputFromString freemarkerString = new FreemarkerOutputFromString();
        final String result = freemarkerString.createOutput(template, model);
        LOGGER.debug("FromString Output result: {}", result);
        /*
        Simple test creating an output from a template File.
         */
        final FreemarkerOutputFromFile freemarketFile = new FreemarkerOutputFromFile();
        final String resultFile = freemarketFile.createOutput("freemarker_sample1.txt", model);
        LOGGER.debug("FromFile Output result: {}", resultFile);
    }

    private List<Map<String, Object>> getSampleItems() {
        final List<Map<String, Object>> list = new LinkedList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("name", "Apple");
        item.put("qty", 10);
        list.add(item);
        item = new HashMap<>();
        item.put("name", "Chocolate");
        item.put("qty", 1);
        list.add(item);
        return list;
    }
}
