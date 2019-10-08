package com.zhc.exercise.spectator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.netflix.spectator.api.DefaultRegistry;
import com.netflix.spectator.api.Registry;

public class SimpleFooTest {

  private Registry registry;

  private Foo foo;

  @Before
  public void init() {
    registry = new DefaultRegistry();
    foo = new Foo(registry);
  }

  @Test
  public void doSomething() {
    foo.doSomething();
    Assert.assertEquals(1, registry.counter("foo").count());
    foo.doSomething();
    Assert.assertEquals(2, registry.counter("foo").count());
  }
}
