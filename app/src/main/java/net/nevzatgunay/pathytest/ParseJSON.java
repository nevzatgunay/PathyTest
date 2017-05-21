package net.nevzatgunay.pathytest;

/**
 * Created by Nevzat on 5/1/2017.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] emails;
    public static String[] froms;
    public static String[] tos;
    public static String[] dates;
    public static String[] times;
    public static String[] prices;


    public static final String JSON_ARRAY = "result";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_FROM = "from";
    public static final String KEY_TO = "to";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";
    public static final String KEY_PRICE = "price";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            emails = new String[users.length()];
            froms = new String[users.length()];
            tos = new String[users.length()];
            dates = new String[users.length()];
            times = new String[users.length()];
            prices = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                emails[i] = jo.getString(KEY_MAIL);
                froms[i] = jo.getString(KEY_FROM);
                tos[i] = jo.getString(KEY_TO);
                dates[i] = jo.getString(KEY_DATE);
                times[i] = jo.getString(KEY_TIME);
                prices[i] = jo.getString(KEY_PRICE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
