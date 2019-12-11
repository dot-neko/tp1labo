	package ui;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DateTimeItem {
	private Date mDate;

	public DateTimeItem(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd' 'HH:mm");

        return sdf.format(mDate);
    }
}
