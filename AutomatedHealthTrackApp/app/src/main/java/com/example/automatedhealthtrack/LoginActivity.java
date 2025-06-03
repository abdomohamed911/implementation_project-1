package com.example.automatedhealthtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView signUpTextView;
    private TextView forgotPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        signUpTextView = findViewById(R.id.signUpTextView);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);

        // Set up Login Button Click Listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();

                // --- TODO: Implement Login Logic --- 
                // 1. Add more robust input validation (e.g., email format check).
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                    return; // Stop execution if validation fails
                }

                // 2. Show a loading indicator (e.g., ProgressBar).

                // 3. Make an API call to your backend server to authenticate the user.
                //    - Send email and password.
                //    - Handle success: Receive user data/token, save session/token.
                //    - Handle failure: Show appropriate error message (e.g., "Invalid credentials").

                // 4. On successful authentication:
                //    - Hide loading indicator.
                //    - Navigate to MainActivity.
                //    - Finish LoginActivity.

                // --- Placeholder Logic (Remove this block when implementing API call) ---
                Toast.makeText(LoginActivity.this, "Login successful (Placeholder - Implement API Call)", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                // Optional: Pass user data to MainActivity if needed
                // intent.putExtra("USER_ID", userIdFromApi);
                startActivity(intent);
                finish(); // Close LoginActivity so user can't go back
                // --- End Placeholder Logic ---
                
                // 5. On failed authentication:
                //    - Hide loading indicator.
                //    - Show error Toast or TextView message (e.g., Toast.makeText(LoginActivity.this, "Login failed: Invalid credentials", Toast.LENGTH_LONG).show();)
            }
        });

        // Set up Sign Up Text Click Listener
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SignUpActivity
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        // Set up Forgot Password Click Listener
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // --- TODO: Implement Forgot Password Flow --- 
                // 1. Show a dialog or navigate to a new screen for password reset.
                // 2. Collect user's email.
                // 3. Make an API call to your backend to initiate the password reset process.
                Toast.makeText(LoginActivity.this, "Forgot Password clicked (Not Implemented)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

