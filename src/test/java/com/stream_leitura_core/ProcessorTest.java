package com.stream_leitura_core;

import com.stream_processor_core.Processor;
import junit.framework.Assert;
import org.junit.Test;

public class ProcessorTest {

    @Test(expected = IllegalStateException.class)
    public void test_deve_retornar_erro_quando_nao_informar_consoante() {
        // GIVEN
        final String input = "AaEeIiOoUu";

        // WHEN
        final Processor stream = new Processor(input);
        stream.process();

        // THEN
        // Catch the IllegalStateException
    }

    @Test(expected = IllegalStateException.class)
    public void test_deve_retornar_erro_quando_nao_informar_vogal() {
        // GIVEN
        final String input = "BbCcDdEe";

        // WHEN
        final Processor stream = new Processor(input);
        stream.process();

        // THEN
        // Catch the IllegalStateException
    }

    @Test(expected = IllegalStateException.class)
    public void test_deve_retornar_erro_quando_achar_vogal_seguida_de_consoante_e_ela_se_repetir() {
        // GIVEN
        final String input = "aAbeBABacfe";
        final Processor stream = new Processor(input);
        stream.process();

        // WHEN
        for (int i = 0; i < input.length(); i++) {
            Assert.assertNotNull(stream.getNext());
            if (i == (input.length() - 1)) {
                Assert.assertFalse(stream.hasNext());
            } else {
                Assert.assertTrue(stream.hasNext());
            }
        }
    }

    @Test
    public void test_deve_achar_a_vogal_e_retonar_false_quando_ela_for_o_ultimo_caracter() {
        // GIVEN
        final String input = "aAbBABacfe";
        final Processor stream = new Processor(input);
        stream.process();

        // WHEN
        for (int i = 0; i < input.length(); i++) {
            Assert.assertNotNull(stream.getNext());
            if (i == (input.length() - 1)) {
                Assert.assertFalse(stream.hasNext());
            } else {
                Assert.assertTrue(stream.hasNext());
            }
        }
    }

}
