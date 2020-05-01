package com.example.resume.ui.contacts;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.resume.MainActivity;
import com.example.resume.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.ref.WeakReference;

public class ContactsFragment extends Fragment {

    public MenuItem itemCall;
    TextInputEditText nameField;
    TextInputEditText messageField;
    private TextInputLayout nameLayout;
    private TextInputLayout messageLayout;
    private static final String EMPTY_STRING = "";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        nameField = root.findViewById(R.id.contact_name);
        messageField = root.findViewById(R.id.contact_message);
        nameLayout = root.findViewById(R.id.contact_name_layout);
        messageLayout = root.findViewById(R.id.contact_message_layout);

        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideError(nameLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        messageField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideError(messageLayout);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        FloatingActionButton fab = root.findViewById(R.id.mail_send);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!shouldShowError(nameField) && !shouldShowError(messageField)) {
                    String[] recepient = {"alla604@mail.ru"};
                    String message = messageField.getText().toString() + "\n\nС уважением, " + nameField.getText().toString();
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                    sendIntent.setData(Uri.parse("mailto:"));
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, recepient);
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Резюме из приложения");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, message);

                    startActivity(Intent.createChooser(sendIntent, "Выберите приложение:"));
                }
                else if (shouldShowError(nameField) && shouldShowError(messageField)) {
                    showError(nameLayout);
                    showError(messageLayout);
                }
                else if (shouldShowError(nameField)) {
                    showError(nameLayout);
                }
                else if (shouldShowError(messageField)) {
                    showError(messageLayout);
                }
            }
        });

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
        itemCall = menu.findItem(R.id.action_call);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_call:
                String phone = "89618057203";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));

                    startActivity(callIntent);

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private boolean shouldShowError(TextInputEditText field) {
        int textLength = field.getText().length();
        return textLength == 0;
    }

    private void showError(TextInputLayout layout) {
        layout.setError(getString(R.string.error));
    }

    private void hideError(TextInputLayout layout) {
        layout.setError(EMPTY_STRING);
    }
}
