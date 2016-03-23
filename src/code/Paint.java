package code;

public class Paint {
  String name;
  double cost;
  double coverage;

  public Paint(String name, double cost, double coverage){
    this.name = name;
    this.cost = cost;
    this.coverage = coverage;
  }

  public String toString(){
    return
      "name: " + this.name + "\n" +
      "cost: " + this.cost + "\n" +
      "coverage: " + this.coverage;
  }

  // Getters
  public String getName(){
    return this.name;
  }
  public double getCost(){
    return this.cost;
  }
  public double getCoverage(){
    return this.coverage;
  }

  // Setters
  public void getName(String name){
    this.name = name;
  }
  public void getCost(double cost){
    this.cost = cost;
  }
  public void getCoverage(double coverage){
    this.coverage = coverage;
  }
}
