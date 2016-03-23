package code;

import java.util.ArrayList;

public class Estimate {
  ArrayList<Section> sectionList;
  double totalSquareFeet;
  double totalPaintCost;
  int totalGallons;

  public Estimate(){
    this.sectionList = new ArrayList<Section>();
  }

  /**
   * Initializes the estimator and does the walkaround for this estimate
   */
  public void createEstimate(){
    Estimator estimator = new Estimator(this);
    estimator.doWalkAround();
  }
  
  // public static void main (String args[]){
  //   Estimate e = new Estimate();
  //   e.createEstimate();
  // }
}
