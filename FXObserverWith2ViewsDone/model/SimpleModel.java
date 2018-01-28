package model;

import java.util.Observable;

// TODO 1: Consider a very simple model
public class SimpleModel extends Observable {
  private int count;

  public SimpleModel() {
    count = 0;
    super.setChanged(); // Easy to forget, but needed with java.util.Observable 
    super.notifyObservers(); // Send an update message to all Observers
  }

  public int currentCount() {
    return count;
  }

  // TODO 2: Show a method that changes the state of the model and 
  // then sends two Observer methods to the superclass Observable. The
  // increment message is sent from the controllers (a.k.a. event handlers).
  // You need this in the next part of the current project.
  //
  public void increment() {
    count++; // Change the state of this model
    
    // Use two superclass Observable methods
    super.setChanged(); // Easy to forget, but needed with java.util.Observable 

    // notifyObservers sends an update(Observable, Object) message to all 
    // Observers that were added before this code executes.
    super.notifyObservers();
  }
  
  public void setCount(int newCount) {
    count = newCount;
    super.setChanged(); // Easy to forget, but needed with java.util.Observable 
    super.notifyObservers();
  }
}