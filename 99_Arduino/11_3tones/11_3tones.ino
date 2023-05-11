int dohBtn = 13;
int reBtn = 12;
int miBtn = 8;

void setup()
{
  pinMode(dohBtn, INPUT); 
  pinMode(reBtn, INPUT); 
  pinMode(miBtn, INPUT); 
}

void loop()
{
  int readDoh = digitalRead(dohBtn);
  int readRe = digitalRead(reBtn);
  int readMi = digitalRead(miBtn);
  
  if(readDoh == 1){
    doh();
  } else if (readRe == 1) {
    re();
  } else if (readMi == 1) {
    mi();
  }
  
}

void doh(){
  tone(11, 263, 10); 
}

void re(){
  tone(11, 294, 10); 
}

void mi(){
  tone(11, 330, 10); 
}
