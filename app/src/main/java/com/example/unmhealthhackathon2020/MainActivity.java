package com.example.unmhealthhackathon2020;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button elevatorButton;
    TextView userNumber, setUserInput;
    ImageView upArrow, downArrow;

    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elevatorButton = findViewById(R.id.elevatorButton);
        upArrow = findViewById(R.id.upArrow);
        downArrow = findViewById(R.id.downArrow);

        userNumber = findViewById(R.id.userNumber);


        elevatorButton = findViewById(R.id.elevatorButton);

        setUserInput = findViewById(R.id.setUserInput);

        elevatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, elevatorButton.class);

                startActivity(intent);
            }
        });

    }

    public void counterUp(View view) {
        current++;
        userNumber.setText(Integer.toString(current));

    }

    public void counterDown(View view) {
        current--;
        userNumber.setText(Integer.toString(current));

    }

    public void setUserInput(View view) {

        if (current == 1) {
            setUserInput.setText("You're going to " + current + "st floor.");
        }
        else if (current == 2) {
            setUserInput.setText("You're going to " + current + "nd floor.");
        }
        else if (current == 3) {
            setUserInput.setText("You're going to " + current + "rd floor.");
        }
        else {
            setUserInput.setText("You're going to " + current + "th floor.");
        }

    }

}
