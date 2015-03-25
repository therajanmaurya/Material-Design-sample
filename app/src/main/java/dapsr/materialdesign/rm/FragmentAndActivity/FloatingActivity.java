package dapsr.materialdesign.rm.FragmentAndActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import dapsr.materialdesign.rm.R;

/**
 * Created by rajanmaurya on 25/3/15.
 */
public class FloatingActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floatingactivity);

        final FloatingActionButton first = (FloatingActionButton) findViewById(R.id.pink_icon);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(FloatingActivity.this, "Pink Floating button", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
