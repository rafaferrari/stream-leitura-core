
package com.stream_processor_core;

/**
 * @author rafael.ferrari
 */
public class CommandLineProcessor {
   
    public static void main(final String... arguments) {
        if (arguments.length == 0) {
            throw new IllegalStateException("Favor informar um valor válido");
        }
        final Processor stream = new Processor(arguments[0]);
        stream.process();
    }
    
}
