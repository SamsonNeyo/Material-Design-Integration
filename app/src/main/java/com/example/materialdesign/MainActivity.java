package com.example.materialdesign;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextInputLayout usernameInputLayout;
    private TextInputEditText usernameInput;
    private TextInputLayout emailInputLayout;
    private TextInputEditText emailInput;
    private MaterialButton submitButton;
    private MaterialButton cancelButton;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        usernameInputLayout = findViewById(R.id.username_input_layout);
        usernameInput = findViewById(R.id.username_input);
        emailInputLayout = findViewById(R.id.email_input_layout);
        emailInput = findViewById(R.id.email_input);
        submitButton = findViewById(R.id.submit_button);
        cancelButton = findViewById(R.id.cancel_button);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set up button click listeners
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();

                if (username.isEmpty()) {
                    usernameInputLayout.setError("Username is required");
                } else if (email.isEmpty()) {
                    emailInputLayout.setError("Email is required");
                } else {
                    usernameInputLayout.setError(null);
                    emailInputLayout.setError(null);
                    Toast.makeText(MainActivity.this,
                            "Submitted: " + username + ", " + email,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput.setText("");
                emailInput.setText("");
                usernameInputLayout.setError(null);
                emailInputLayout.setError(null);
                Toast.makeText(MainActivity.this,
                        "Form cleared",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Set up bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_home); // Set default selection
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show();
            // You can add additional home-specific logic here
            return true;
        } else if (itemId == R.id.nav_profile) {
            Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
            // You can add profile-specific logic here
            return true;
        } else if (itemId == R.id.nav_settings) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            // You can add settings-specific logic here
            return true;
        }
        return false;
    }
}