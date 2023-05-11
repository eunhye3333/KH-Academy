boolean readValue = false;
boolean last = false;
boolean led = false;

void setup()
{
  Serial.begin(9600);
  pinMode(7, INPUT); 
  pinMode(8, OUTPUT);
}

int count = 0;

void loop()
{
  readValue = digitalRead(7);
  
  if(last == false && readValue == 1){
    led = !led;
  }
  
  digitalWrite(8, led);
  last = readValue;
}
