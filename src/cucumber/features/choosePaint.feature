Scenario: Choosing Paint
when running choosePaint,
  returns a Paint
  String paint accepts JOptionPane string input
  JOptionPane choices should contain every value of paintChoices
  int index accepts index value of String paint in paintChoices
  returns value at index in paints
