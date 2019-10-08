package com.zhc.exercise.spectator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netflix.spectator.api.Registry;

public class GuiceFooTest {
  private Registry registry;

  private Foo foo;

  @Before
  public void init() {
    Injector injector = Guice.createInjector(new TestModule());
    registry = injector.getInstance(Registry.class);
    foo = injector.getInstance(Foo.class);
  }

  @Test
  public void doSomething() {
    foo.doSomething();
    Assert.assertEquals(1, registry.counter("foo").count());
  }
}
