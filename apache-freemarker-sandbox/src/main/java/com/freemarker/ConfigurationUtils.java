package com.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 * Utilities class to create a {@link freemarker.template.Configuration} object.
 */
public class ConfigurationUtils {

    private ConfigurationUtils() {
        /* Avoid instantiation. */
    }

    /**
     * Create a default {@link freemarker.template.Configuration} object.
     * <a href="https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html"> Configuration reference.</a>
     *
     * @return {@link freemarker.template.Configuration} instance.
     */
    public static Configuration getConfiguration() {
        final Configuration config = new Configuration(Configuration.VERSION_2_3_0);
        /* Set "resources/templates" folder as the default directory that will be searched when looking up a template file. */
        config.setClassForTemplateLoading(ConfigurationUtils.class, "/templates");
        /* Sets how errors will appear. */
        /* During web page development TemplateExceptionHandler.HTML_DEBUG_HANDLER is better. */
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        /* Wrap unchecked exceptions thrown during template processing into TemplateException-s. */
        config.setWrapUncheckedExceptions(Boolean.TRUE);
        /* Don't log exceptions inside FreeMarker that it will be thrown at you anyway. */
        config.setLogTemplateExceptions(Boolean.FALSE);
        return config;
    }

}
