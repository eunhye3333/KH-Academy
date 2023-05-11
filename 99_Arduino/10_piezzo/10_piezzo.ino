const int melody[] = {263, 294, 330, 349, 392, 440, 494, 523};

void setup()
{
  
}

void loop()
{
  line1();
  line2();
  line2();
  line1();
}

void line1() 
{
  doh(); delay(500);
  doh(); delay(500);
  
  sol(); delay(500);
  sol(); delay(500);
  
  ra(); delay(500);
  ra(); delay(500);
  
  sol(); delay(1000);
  
  fa(); delay(500);
  fa(); delay(500);
  
  mi(); delay(500);
  mi(); delay(500);
    
  re(); delay(500);
  re(); delay(500);
    
  doh(); delay(1000);
}

void line2()
{
  sol(); delay(500);
  sol(); delay(500);
  
  fa(); delay(500);
  fa(); delay(500);
  
  mi(); delay(500);
  mi(); delay(500);
    
  re(); delay(1000);
}

void doh(){
  tone(3, melody[0], 500); 
}

void re(){
  tone(3, melody[1], 500); 
}

void mi(){
  tone(3, melody[2], 500); 
}

void fa(){
  tone(3, melody[3], 500); 
}

void sol(){
  tone(3, melody[4], 500); 
}

void ra(){
  tone(3, melody[5], 500); 
}
