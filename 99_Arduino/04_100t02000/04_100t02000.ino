void setup()
{
  pinMode(8, OUTPUT);
}

int x = 100;

void loop()
{
  digitalWrite(8, HIGH);
  delay(x); 
  digitalWrite(8, LOW);
  delay(x); 
  x += 100;
  
  if(x > 2000){
    x = 100;
  }

/*  for(int i = 100; i <= 2000; i+=100){
    digitalWrite(8, HIGH);
    delay(i); 
    digitalWrite(8, LOW);
    delay(i); 
  } */
}
