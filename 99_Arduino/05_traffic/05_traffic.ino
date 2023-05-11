void setup()
{
  pinMode(6, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(11, OUTPUT);
}

int count = 0;

void loop()
{
 /* digitalWrite(6, LOW);
  digitalWrite(8, HIGH);
  digitalWrite(11, LOW);
  delay(3000); 
  
  digitalWrite(6, HIGH);
  digitalWrite(8, LOW);

  delay(5000); 
  
  digitalWrite(8, HIGH);

  delay(2000); 
  
  digitalWrite(8, LOW);
  digitalWrite(11, HIGH);
  delay(15000); */
  
  int c = count % 4;
  
  digitalWrite(6, LOW);
  digitalWrite(8, LOW);
  digitalWrite(11, LOW);
  
  int i = 0;
  int d = 0;
  
  switch(c){
    case 0:
      i = 8;
      d = 3000;
    break;
    case 1:
      i = 6;
      d = 5000;
    break;
    case 2:
      i = 8;
      d = 2000;   
    break;
    case 3:
      i = 11;
      d = 15000;
    break;
  }
  
  digitalWrite(i, HIGH);
  delay(d);
  count++;
}
