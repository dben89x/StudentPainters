package code;

public class Section{
  String name;
  double squareFeet;
  Paint paint;
  double paintGallons;
  double cost;

  /*
  Section()
    is the constructor   */
  public Section(String name, double sqft, Paint paint, double paintGallons, double cost){
    this.name = name;
    this.squareFeet = sqft;
    this.paint = paint;
    this.paintGallons = paintGallons;
    this.cost = cost;
  }

  public String toString(){
    return
      "name:" + (this.name) + "\n" +
      "squareFeet:" + (this.squareFeet) + "\n" +
      "paint:" + (this.paint) + "\n" +
      "paintGallons:" + (this.paintGallons) + "\n" +
      "cost:" + (this.cost);
  }

  // Getters
  public String getName(){
    return name;
  }
  public double getSquareFeet(){
    return squareFeet;
  }
  public Paint getPaint(){
    return paint;
  }
  public double getPaintGallons(){
    return paintGallons;
  }
  public double getCost(){
    return cost;
  }

  // Setters
  public void setName(String name){
    this.name = name;
  }
  public void setSquareFeet(double squareFeet){
    this.squareFeet = squareFeet;
  }
  public void setPaint(Paint paint){
    this.paint = paint;
  }
  public void setPaintGallons(double paintGallons){
    this.paintGallons = paintGallons;
  }
  public void setCost(double cost){
    this.cost = cost;
  }

}
