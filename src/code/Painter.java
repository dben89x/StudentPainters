package code;

public class Painter{
  String position = "";
  double wage = 0.0;

  public Painter(String position, double wage){
    this.position = position;
    this.wage = wage;
  }


  public String toString(){
    return
      "position: " + this.position + "\n" +
      "wage: " + this.wage;
  }

  // Getters
  public String getPosition(){
    return position;
  }
  public double getWage(){
    return wage;
  }

  // Setters
  public void setPosition(String position){
    this.position = position;
  }
  public void setWage(double wage){
    this.wage = wage;
  }
}
