package com.example.automatedhealthtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private Spinner activityLevelSpinner;
    private Button createAccountButton;
    private TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Views
        fullNameEditText = findViewById(R.id.fullNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        ageEditText = findViewById(R.id.ageEditText);
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        activityLevelSpinner = findViewById(R.id.activityLevelSpinner);
        createAccountButton = findViewById(R.id.createAccountButton);
        loginTextView = findViewById(R.id.loginTextView);

        // Setup Spinner using strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_levels_placeholder, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityLevelSpinner.setAdapter(adapter);

        // Set up Create Account Button Click Listener
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // --- TODO: Implement Registration Logic --- 
                String fullName = fullNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString(); // No trim for password
                String ageStr = ageEditText.getText().toString().trim();
                String weightStr = weightEditText.getText().toString().trim();
                String heightStr = heightEditText.getText().toString().trim();
                String activityLevel = activityLevelSpinner.getSelectedItem().toString();
                int age = 0;
                double weight = 0.0;
                int height = 0;

                // 1. Add more robust input validation:
                if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty() || activityLevel.equals("Select level")) {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailEditText.setError("Invalid email format");
                    emailEditText.requestFocus();
                    return;
                }
                // Add password strength validation if required by backend
                // Convert numeric fields safely
                try {
                    age = Integer.parseInt(ageStr);
                    weight = Double.parseDouble(weightStr);
                    height = Integer.parseInt(heightStr);
                    if (age <= 0 || weight <= 0 || height <= 0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    Toast.makeText(SignUpActivity.this, "Please enter valid numbers for age, weight, and height", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 2. Show a loading indicator.

                // 3. Make an API call to your backend server to register the user.
                //    - Send fullName, email, password, age, weight, height, activityLevel.
                //    - Handle success: Maybe automatically log the user in or redirect to login.
                //    - Handle failure: Show appropriate error message (e.g., "Email already exists").

                // 4. On successful registration:
                //    - Hide loading indicator.
                //    - Navigate to LoginActivity (or MainActivity if auto-login).
                //    - Finish SignUpActivity.

                // --- Placeholder Logic (Remove this block when implementing API call) ---
                Toast.makeText(SignUpActivity.this, "Registration successful (Placeholder - Implement API Call)", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); // Clear back stack
                startActivity(intent);
                finish(); // Close SignUpActivity
                // --- End Placeholder Logic ---

                // 5. On failed registration:
                //    - Hide loading indicator.
                //    - Show error Toast or TextView message (e.g., Toast.makeText(SignUpActivity.this, "Registration failed: Email already in use", Toast.LENGTH_LONG).show();)
            }
        });

        // Set up Login Text Click Listener
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to LoginActivity
                finish(); // Simply close this activity to go back to LoginActivity
            }
        });
    }
}

