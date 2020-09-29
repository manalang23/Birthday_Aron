package cs301.birthdaycake;

import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
        private CakeView viewCake;
        private CakeModel modelOfCake;

        public CakeController(CakeView viewCake) {
            this.viewCake = viewCake;
            this.modelOfCake = viewCake.getCake();
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            modelOfCake.hasCandles = b;
            viewCake.invalidate();
        }

        @Override
        public void onClick(View view) {
            modelOfCake.candlesLit = false;
            viewCake.invalidate();
        }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if(b) {
                modelOfCake.candleAmount = i;
                viewCake.invalidate();;
            }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Do nothing
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        modelOfCake.xCoord = x;
        modelOfCake.yCoord = y;
        viewCake.invalidate();
            return false;
    }
}
