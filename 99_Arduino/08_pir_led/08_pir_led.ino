void setup()
{
  pinMode(7, INPUT);
  pinMode(8, OUTPUT);
}

void loop()
{
  int readValue = digitalRead(7);
  
  if(readValue == 1){
    digitalWrite(8, HIGH);
  } else{
    digitalWrite(8, LOW);
  }
}
