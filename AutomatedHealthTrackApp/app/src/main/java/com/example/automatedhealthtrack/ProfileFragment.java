package com.example.automatedhealthtrack;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileFragment extends Fragment {

    // Declare UI elements from fragment_profile.xml
    private TextView userNameTextView;
    private TextView userEmailTextView;
    private Button editProfileButton;
    private Button logoutButton;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize UI elements
        userNameTextView = view.findViewById(R.id.userNameTextView);
        userEmailTextView = view.findViewById(R.id.userEmailTextView);
        editProfileButton = view.findViewById(R.id.editProfileButton);
        logoutButton = view.findViewById(R.id.logoutButton);

        // --- TODO: Load Actual User Profile Data --- 
        // 1. Show a loading indicator.
        // 2. Fetch the logged-in user's profile data (Name, Email, maybe other details) 
        //    from your backend API or local storage/session.
        // 3. Handle API/data retrieval success: Update userNameTextView and userEmailTextView.
        // 4. Handle API/data retrieval failure: Show an error message.
        // 5. Hide loading indicator.

        // --- Placeholder Data Loading (Remove when implementing data loading) ---
        loadPlaceholderData();
        // --- End Placeholder Data Loading ---

        // Set up button click listeners
        editProfileButton.setOnClickListener(v -> {
            // --- TODO: Implement Edit Profile Logic --- 
            // 1. Navigate to a new Activity/Fragment where the user can edit their details.
            // 2. Pass the current user data to the edit screen.
            Toast.makeText(getContext(), "Edit Profile clicked (Not Implemented)", Toast.LENGTH_SHORT).show();
        });

        logoutButton.setOnClickListener(v -> {
            // --- TODO: Implement Logout Logic --- 
            // 1. Clear any stored user session/token (SharedPreferences, etc.).
            // 2. Make an API call to the backend to invalidate the session/token if necessary.
            // 3. Navigate back to LoginActivity.
            // 4. Clear the activity stack so the user cannot press back to return to the main app.
            Toast.makeText(getContext(), "Logout successful (Placeholder - Implement Session Clearing & Navigation)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            getActivity().finish(); // Finish MainActivity
        });

        return view;
    }

    private void loadPlaceholderData() {
        // Replace with actual data loading
        // You might get this data passed from MainActivity or fetch it here
        userNameTextView.setText("John Doe (Placeholder)");
        userEmailTextView.setText("john.doe@example.com");
    }
}

