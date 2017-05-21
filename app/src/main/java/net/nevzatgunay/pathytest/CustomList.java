package net.nevzatgunay.pathytest;

/**
 * Created by Nevzat on 5/1/2017.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
    private String[] emails;
    private String[] froms;
    private String[] tos;
    private String[] dates;
    private String[] times;
    private String[] prices;

    private Activity context;

    public CustomList(Activity context, String[] emails, String[] froms, String[] tos,String[] dates,String[] times,String[] prices) {
        super(context, R.layout.list_view_layout, emails);
        this.context = context;
        this.emails = emails;
        this.froms = froms;
        this.tos = tos;
        this.dates = dates;
        this.times = times;
        this.prices = prices;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textViewEMail);
        TextView textViewFrom = (TextView) listViewItem.findViewById(R.id.textViewFrom);
        TextView textViewTo = (TextView) listViewItem.findViewById(R.id.textViewTo);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDate);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.textViewTime);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);

        textViewEmail.setText(emails[position]);
        textViewFrom.setText(froms[position]);
        textViewTo.setText(tos[position]);
        textViewDate.setText(dates[position]);
        textViewTime.setText(times[position]);
        textViewPrice.setText(prices[position]);

        String old=textViewEmail.getText().toString();
        String newone= "E-Mail : "+old;
        textViewEmail.setText(newone);

        old=textViewFrom.getText().toString();
        newone= "From : "+old;
        textViewFrom.setText(newone);

        old=textViewTo.getText().toString();
        newone= "To : "+old;
        textViewTo.setText(newone);

        old=textViewDate.getText().toString();
        newone= "Date : "+old;
        textViewDate.setText(newone);

        old=textViewTime.getText().toString();
        newone= "Time : "+old;
        textViewTime.setText(newone);

        old=textViewPrice.getText().toString();
        newone= "Price : "+old+ "TL";
        textViewPrice.setText(newone);

        return listViewItem;
    }
}