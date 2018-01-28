package tests;

import static org.junit.Assert.*;
import model.SimpleModel;

import org.junit.Test;

// TODO 3: Run the unit test for our very simple model
public class SimpleModelTest {
  @Test
  public void testIncrement() {
    SimpleModel counter = new SimpleModel();
    assertEquals(0, counter.currentCount());
    counter.increment();
    assertEquals(1, counter.currentCount());

    counter.increment();
    counter.increment();
    assertEquals(3, counter.currentCount());
  }
  
  @Test
  public void testSetCount() {
    SimpleModel counter = new SimpleModel();
    assertEquals(0, counter.currentCount());
    counter.setCount(12);
    assertEquals(12, counter.currentCount());
    counter.increment();
    counter.increment();
    assertEquals(14, counter.currentCount());
  }
}
