package code;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Estimator{
  Estimate estimate;
  Paint[] paints;                    // available paint objects to choose from
  String[] paintChoices;             // references available paints by name
  boolean newSectionChoice = true;   // to decide if user wants to estimate another section -- used in doWalkAround()

  public Estimator(Estimate estimate){
    this.estimate = estimate;
    this.paints = createPaints();
    this.paintChoices = createPaintChoices();
  }

  /**
   * Does the walkaround. Section name, square footage, paint used, gallons used, and section cost
   * are all determined here.  Creates a new section upon completion of each iteration.
   */
  public void doWalkAround(){
    while (newSectionChoice == true){
      String sectionName = nameSection();
      double sectionSqFt = Double.parseDouble(JOptionPane.showInputDialog("How many square feet?"));
      Paint paint = choosePaint();
      int sectionGallons = calcSectionGallons(sectionSqFt, paint.coverage);
      double sectionCost = calcSectionCost(paint.cost, sectionGallons);

      estimate.sectionList.add(new Section(sectionName, sectionSqFt, paint, sectionGallons, sectionCost));

      if (estimate.sectionList.size() >= 20) {
        newSectionChoice = false;
      } else {
        int choice = JOptionPane.showConfirmDialog(
            null, "Another section? Maximum 20 sections.", null, JOptionPane.YES_NO_OPTION);
        newSectionChoice = (choice == 0);
      }
    }
    calcTotals();
    printOutput();
  }

  /**
   * Chooses the paint being used for current section
   * @return paint used for section
   */
  public Paint choosePaint(){
    String paint = (String) JOptionPane.showInputDialog(
      null, "What type of paint will you be using?",
      "Paint options", JOptionPane.QUESTION_MESSAGE, null, paintChoices, paintChoices[0]);
    int index = Arrays.asList(paintChoices).indexOf(paint);
    return paints[index];
  }

  /**
   * Gives current section either a name or a number
   * @return name of section
   */
  public String nameSection(){
    int choice = JOptionPane.showConfirmDialog(
      null, "Would you like to name the section?\nNote: If you don't name the section, it will be given a number that shows its order in relation to other sections.",
      "Name Section", JOptionPane.YES_NO_OPTION);
    boolean sectionHasName = (choice == 0);

    String sectionName = "";
    if (sectionHasName){
      sectionName = JOptionPane.showInputDialog("Please enter the section name");
    } else {
      sectionName = Integer.toString(estimate.sectionList.size()+1);
    }
    return sectionName;
  }


////////////////////////////  Paint initializers  //////////////////////////////

  /**
   * Creates an array of paints. This is manually generated for usable data.
   * @return collection of paints
   */
  public Paint[] createPaints(){
    Paint superPaint = new Paint("Super Paint",25,150);
    Paint duration = new Paint("Duration",40,250);
    Paint woodScapes = new Paint("Wood Scapes",25,150);
    Paint deckScapes = new Paint("Deck Scapes",25,100);
    Paint[] paints = {superPaint, duration, woodScapes, deckScapes};
    return paints;
  }

  /**
   * Creates an array of strings derived from each paint's name, for creating readable options.
   * Class instance has access to these names for various UI functionality.
   * @return collection of paint names
   */
  public String[] createPaintChoices(){
    String[] paintChoices = new String[paints.length];
    for(int i=0;i<paints.length;i++){
      paintChoices[i] = (paints[i].name);
    }
    return paintChoices;
  }

//////////////////////////////  Calculation methods //////////////////////////////
  /**
   * calcSectionGallons() calculates gallons needed for the section
   * @return section gallons
   */
  public int calcSectionGallons(double squareFeet, double coverage){
    return new Double(Math.ceil(squareFeet/coverage)).intValue();
  }

  /**
   * calcSectionCost() calculates cost of paint for the section
   * @return section cost
   */
  public double calcSectionCost(double paintCost, double sectionGallons){
    return paintCost * sectionGallons;
  }

  /**
   * calcTotalPaintCost() calculates total square footage and paint cost for entire job
   * and assigns this instance's values
   */
  public void calcTotals(){
    double totalSquareFeet = 0;
    double totalCost = 0;
    int totalGallons = 0;

    for (int i = 0; i < estimate.sectionList.size(); i++){
      Section section = estimate.sectionList.get(i);

      totalSquareFeet += section.squareFeet;
      totalCost += section.cost;
      totalGallons += section.paintGallons;
    }

    estimate.totalSquareFeet = totalSquareFeet;
    estimate.totalPaintCost = totalCost;
    estimate.totalGallons = totalGallons;
  }

//////////////////////////////  Output  //////////////////////////////
  /**
   * Prints totals and section summaries to screen.
   */
  public void printOutput(){
    String output = String.format(
        "This job requires %s gallons to cover %s square feet, and will cost a total of $%.2f",
        estimate.totalGallons, estimate.totalSquareFeet, estimate.totalPaintCost) +
        "\n\nYour sections:\n____________________\n";
    for (int i=0; i < estimate.sectionList.size(); i++){
      Section section = estimate.sectionList.get(i);
      output += String.format(
          "Section %s:\nName: %s\nCost: $%s\nPaint: %s\nGallons: %s\nSquare Feet: %s\n\n",
          (i+1),section.name,section.cost,section.paint.name,section.paintGallons,section.squareFeet);
    }
    System.out.println(output);
  }
}
