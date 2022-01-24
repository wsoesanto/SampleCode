package com.elfin;


import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StripeTest {

    @Test
    public void compressPartOne_sample() {
        String compressed = Stripe.compressPartOne("stripe.com/payments/checkout/customer.maria");

        assertThat(compressed).isEqualTo("s4e.c1m/p6s/c6t/c6r.m3a");
    }

    @Test
    public void compressPartOne_withNoMajorSplit() {
        String compressed = Stripe.compressPartOne("stripe.com");

        assertThat(compressed).isEqualTo("s4e.c1m");
    }

    @Test
    public void compressPartTwo_sample() {
        String compressed = Stripe.compressPartTwo("stripe.com/payments/checkout/customer.maria.doe", 2);

        assertThat(compressed).isEqualTo("s4e.c1m/p6s/c6t/c6r.m6e");
    }


    @Test
    public void compressPartTwo_sample2() {
        String compressed = Stripe.compressPartTwo("www.api.stripe.com/checkout", 3);

        assertThat(compressed).isEqualTo("w1w.a1i.s7m/c6t");
    }

    @Test
    public void compressPartTwo_withNoMajorSplit() {
        String compressed = Stripe.compressPartTwo("www.api.stripe.com", 3);

        assertThat(compressed).isEqualTo("w1w.a1i.s7m");
    }


    @Test
    public void compressPartTwo_withMIsTooBig() {
        String compressed = Stripe.compressPartTwo("www.api.stripe.com", 100);

        assertThat(compressed).isEqualTo("w1w.a1i.s4e.c1m");
    }

    @Test
    public void compressPartTwo_withMIs1() {
        String compressed = Stripe.compressPartTwo("www.api.stripe.com", 1);

        assertThat(compressed).isEqualTo("w13m");
    }
}
