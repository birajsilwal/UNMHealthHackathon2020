// Initializing pin number 
int LED_INPUT = 9; 

//The setup function will only run once, after each powerup.It initializes and sets the initial values
void setup() {
  //Sets the baud for serial data transmission (Bits Per Second)
  Serial.begin(9600);  
 //Specify behaviour of pin to work either as an input or an output 
  pinMode(LED_INPUT,OUTPUT); 
}

// bad logic, make it better
void loop() {
  //Recived data will get stored in this variable
  char data;  
  //Here We're checking whether data is available or not
  if(Serial.available()>0) 
  //Data received
    data=Serial.read(); 
    //LED ON
    if(data=='f') {
      // Write a HIGH or a LOW value to a digital pin
      digitalWrite(LED_INPUT,HIGH);  
    }
    //LED OFF
    if(data=='b') {
      digitalWrite(LED_INPUT,LOW);
    }
  }
}

