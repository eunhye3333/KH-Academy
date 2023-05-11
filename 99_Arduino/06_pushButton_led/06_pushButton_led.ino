void setup()
{
  // 시리얼 모니터를 사용하겠다, 직렬 통신을 사용하겠다는 선언
  // 직렬 통신 초기화 (9600비트로 데이터 전송)
  Serial.begin(9600);
  pinMode(7, INPUT); 
  // 사용자가 신호를 보내는 것을 받아와야 하기 때문에 INPUT 사용
  pinMode(8, OUTPUT);
}

void loop()
{
  int readValue = digitalRead(7);
  // 데이터를 읽어옴
  Serial.println(readValue);
  
  //if(readValue == 1){
  if(readValue == HIGH){
    digitalWrite(8, 1);
  //} else if(readValue == 0){
  } else if(readValue == LOW){
    digitalWrite(8, 0);
  }
}
