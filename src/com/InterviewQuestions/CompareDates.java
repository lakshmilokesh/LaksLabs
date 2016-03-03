package com.InterviewQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  Sample Question given by Antin for ServiceNow interview
 */
public class CompareDates {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date1 = sdf.parse("1985-10-09");
            Date date2 = sdf.parse("1984-12-05");

            System.out.println("Date 1 : " + sdf.format(date1));
            System.out.println("Date 2 : " + sdf.format(date2));

            comparingDate(date1,date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
     * User friendly method to compare two dates.
     */
    public static void comparingDate(Date date1, Date date2) {

            if (date1.after(date2)) {
                System.out.println("Date 1 is after Date 2");
            }
            else if (date1.before(date2)) {
                System.out.println("Date 1 is before Date 2");
            }
            else if (date1.equals(date2)) {
                System.out.println("Dates are equal");
            }
    }

    /*
     * Most widely used method
     */
    public void comparingDates(Date date1, Date date2) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        if (cal1.after(cal2)) {
            System.out.println("Date 1 is after Date 2");
        }
        else if (cal1.before(cal2)) {
            System.out.println("Date 1 is before Date 2");
        }
        else if (cal1.equals(cal2)) {
            System.out.println("Dates are equal");
        }
    }
}
