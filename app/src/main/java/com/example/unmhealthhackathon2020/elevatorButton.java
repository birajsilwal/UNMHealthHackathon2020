//package com.example.unmhealthhackathon2020;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothDevice;
//import android.bluetooth.BluetoothSocket;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.IOException;
//import java.util.Set;
//import java.util.UUID;
//
//public class elevatorButton extends AppCompatActivity {
//
//    ImageView backToMain;
//
//    public Button one;
//    public TextView bluetoothNameAddress;
//
//    String address = null;
//    String name = null;
//
//    BluetoothAdapter bluetoothAdapter = null;
//    BluetoothSocket bluetoothSocket = null;
//    Set<BluetoothDevice> pairedDevices;
//    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_elevator_button);
//
//        backToMain = findViewById(R.id.ivBack);
//
//        backToMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(elevatorButton.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        try {
//            userActions();
//        }
//        catch (Exception e) {}
//
//    }
//
//    @SuppressLint("ClickableViewAccessibility")
//    private void userActions() throws IOException {
//        bluetoothConnectDevice();
//        one = findViewById(R.id.one);
//
//        one.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    ledOnOff("f");
//                    Log.i("onebutton", "clicked one");
//                }
//                if (event.getAction() == MotionEvent.ACTION_UP) {ledOnOff("t");}
//                return true;
//            }
//        });
//    }
//
//    private void bluetoothConnectDevice() throws IOException {
//        try {
//            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//            address = bluetoothAdapter.getAddress();
//            pairedDevices = bluetoothAdapter.getBondedDevices();
//
//            if (pairedDevices.size() >= 0) {
//                for (BluetoothDevice bluetoothDevice : pairedDevices) {
//                    address = bluetoothDevice.getAddress().toString();
//                    name = bluetoothDevice.getName().toString();
//                    Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//        catch (Exception exception) {}
//        // get the mobile bluetooth device
//        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        // connect to the device's address and checks if it's available
//        BluetoothDevice dispositivo = bluetoothAdapter.getRemoteDevice(address);
//        // create a RFCOMM (SPP) connection
//        bluetoothSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
//        bluetoothSocket.connect();
//
//        try {
//            bluetoothNameAddress.setText("Name: " + name + "\naddress: " + address);
//        }
//        catch (Exception exception){}
//    }
//
//    private void ledOnOff(String i) {
//        try {
//            if (bluetoothSocket != null) {
//                bluetoothSocket.getOutputStream().write(i.getBytes());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
