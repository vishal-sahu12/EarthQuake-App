package com.example.earthquakecopy;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListAdapter extends ArrayAdapter<list> {
    public ListAdapter(@NonNull Activity context, ArrayList<list> earthuake_info) {
        super(context,0, earthuake_info);
    }
    
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if(currentView==null)
        {
            currentView= LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list,parent,false);

        }
        list currentWordPosition =getItem(position);
        //magintude obect

        Double magintudess = currentWordPosition.getmMagnitude();
        String formatted_Magnitude = formatMagnitude(magintudess);

        TextView magnitude = (TextView) currentView.findViewById(R.id.text_magnitude);
        magnitude.setText(formatted_Magnitude);

        // Magnitude Background Color

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(currentWordPosition.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        // Location and Offset  object
        String locationsss = currentWordPosition.getmLocation();
        String locatinOffset,mainLocation;
        final String LOCATION_SEPARATOR ="of";

        if(locationsss.contains(LOCATION_SEPARATOR))
        {
            String[] splitting_location = locationsss.split(LOCATION_SEPARATOR);
            locatinOffset = splitting_location[0] + LOCATION_SEPARATOR;
            mainLocation = splitting_location[1];
        }
        else {
            locatinOffset = "Near the";
            mainLocation = locationsss;
        }

        TextView offset_location = (TextView) currentView.findViewById(R.id.location_offset);
        offset_location.setText(locatinOffset);
        TextView originalLocation = (TextView) currentView.findViewById(R.id.primary_location);
        originalLocation.setText(mainLocation);


        // date Object
        TextView dates = (TextView) currentView.findViewById(R.id.date);

        Date dateObject = new Date(currentWordPosition.getMtimesInMilisecond());
        String formattedDate = formatDate(dateObject);
        dates.setText(formattedDate);

        //Time Object
        TextView timeView= (TextView) currentView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return currentView;
    }


    int getMagnitudeColor(double color)
    {
        int magnitudeColorResourceId,magnitudeFloor;
        magnitudeFloor = (int) Math.floor(color);
        switch (magnitudeFloor)
    {
        case 0:
        case 1:
            magnitudeColorResourceId = R.color.magnitude1;
            break;
        case 2:
            magnitudeColorResourceId = R.color.magnitude2;
            break;
        case 3:
            magnitudeColorResourceId = R.color.magnitude3;
            break;
        case 4:
            magnitudeColorResourceId = R.color.magnitude4;
            break;
        case 5:
            magnitudeColorResourceId = R.color.magnitude5;
            break;
        case 6:
            magnitudeColorResourceId = R.color.magnitude6;
            break;
        case 7:
            magnitudeColorResourceId = R.color.magnitude7;
            break;
        case 8:
            magnitudeColorResourceId = R.color.magnitude8;
            break;
        case 9:
            magnitudeColorResourceId = R.color.magnitude9;
            break;
        default:
            magnitudeColorResourceId = R.color.magnitude10plus;
            break;
    }
    return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }
    String  formatMagnitude(Double magnitude){
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String  f_magnitude = decimalFormat.format(magnitude);
        return f_magnitude;
    }

    String formatTime(Date timeToFormat){
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh,mm a");
        return (timeFormat.format(timeToFormat));

    }

    String formatDate(Date dateToFormat){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD,YYYY");
        String formattedDate = dateFormat.format(dateToFormat);
        return formattedDate;
    }

}
