	package ui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalendar {
	private Date mDate;

    public DateCalendar(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        return sdf.format(mDate);
    }
}
