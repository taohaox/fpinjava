package com.fpinjava.functions.exercise02_05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

  public static final Function<Double, Long> triple = x -> ((Double)(x * 3)).longValue();

  public static final Function<Long, Integer> square = x -> Math.toIntExact(x * x);

  @Test
  public void test() {
    assertEquals(Integer.valueOf(36), Function.<Double, Long, Integer>higherCompose().apply(square).apply(triple).apply(2d));
  }
}
