package com.zhc.exercise.spectator;

import javax.inject.Inject;

import com.netflix.spectator.api.Counter;
import com.netflix.spectator.api.Registry;

public class Foo {

  public final Counter counter;

  @Inject
  public Foo(Registry registry) {
    counter = registry.counter("foo");
  }

  public void doSomething() {
    counter.increment();
  }
}
