package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    CakeView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        temp = findViewById(R.id.cakeview);
        CakeController cakeController = new CakeController(temp);

        Button blowOutButton = findViewById(R.id.button);
        blowOutButton.setOnClickListener(cakeController);

        Switch candleSwitch = findViewById(R.id.Candles);
        candleSwitch.setOnCheckedChangeListener(cakeController);

        SeekBar candleAmount = findViewById((R.id.seekBar3));
        candleAmount.setOnSeekBarChangeListener(cakeController);

        CakeView cakeView = findViewById(R.id.cakeview);
        cakeView.setOnTouchListener(cakeController);
    }

    public void goodbye(View button2) {
        Log.i("button2", "Goodbye");
        finishAffinity();
    }
}
