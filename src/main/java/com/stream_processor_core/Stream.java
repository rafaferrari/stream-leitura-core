package com.stream_processor_core;

/**
 * @author rafael.ferrari
 */
public interface Stream {

    /**
     * Get the next element of an Stream.
     * 
     * @return The next element.
     */
    public char getNext();

    /**
     * Verify if has next element to process.
     * 
     * @return true if has element, otherwise false.
     */
    public boolean hasNext();

}
