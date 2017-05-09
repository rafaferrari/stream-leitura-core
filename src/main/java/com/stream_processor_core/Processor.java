package com.stream_processor_core;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class responsible to process an Stream verifying a result looking for a
 * matcher.
 *
 * @author rafael.ferrari
 */
public class Processor implements Stream {

    private static final String VOWEL_MATCHER = "^A|E|I|O|U$";
    private final String input;
    private int vowelIndex;
    private int index = 0;

    public Processor(final String input) {
        this.input = input;
    }

    public void process() {
        final List<String> chars = getCharsOfInput();
        final Integer consonantIndex = getFirstConsonantIndex(chars);
        this.vowelIndex = getFirstVowelIndex(chars, consonantIndex);        
        System.out.println(String.format("Valor encontrado: %s - Índice: %s", input.charAt(vowelIndex), vowelIndex));
    }

    private List<String> getCharsOfInput() {
        return Arrays.asList(input.split(""))
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private Integer getFirstConsonantIndex(final List<String> chars) {
        final String consoante = chars.stream()
                .filter(s -> !s.matches(VOWEL_MATCHER))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Favor informar um valor válido."));
        return chars.indexOf(consoante);
    }

    private Integer getFirstVowelIndex(final List<String> chars, final Integer consonantIndex) {
        final String vowel = chars.subList(consonantIndex, chars.size())
                .stream()
                .filter(filtraVogalUnica(chars))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Favor informar um valor válido."));
        return chars.indexOf(vowel);
    }

    private Predicate<? super String> filtraVogalUnica(final List<String> chars) {
        return s -> s.matches(VOWEL_MATCHER) && chars.stream().filter(v -> v.equals(s)).count() == 1;
    }

    @Override
    public char getNext() {
        return input.charAt(index++);
    }

    @Override
    public boolean hasNext() {
        return index <= input.length() && vowelIndex == -1 || index <= vowelIndex;
    }

}
