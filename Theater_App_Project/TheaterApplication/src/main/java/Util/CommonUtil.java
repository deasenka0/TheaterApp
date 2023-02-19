package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	
	public static String getTimeFromDate(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");  // create a new SimpleDateFormat object with the desired time format
        String timeString = sdf.format(now);  // format the Date object as a string
        return timeString;
	}
	
	public static Date StringToDate(String dateString) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
}
