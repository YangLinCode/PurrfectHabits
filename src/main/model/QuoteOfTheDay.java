package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// represents the quote of the day
// code based off of https://www.youtube.com/watch?v=qzRKa8I36Ww&list=PL-K6CIX0_zzgzI0sfBrvkjgP369jRrE3j&index=1
public class QuoteOfTheDay {
    Quote quoteOfTheDay;
    HttpURLConnection connection;

    public QuoteOfTheDay() {
        quoteOfTheDay = getQuoteFromAPI();
    }

    private Quote getQuoteFromAPI() {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://zenquotes.io/api/random");
            connection = (HttpURLConnection) url.openConnection();

            // Request Setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            // you can print the status out after if you want (a certain number means it was successful)

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return parse(responseContent.toString());
    }

    private Quote parse(String responseBody) {
        JSONArray jsonArray = new JSONArray(responseBody);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String saying = jsonObject.getString("q");
//        saying = saying.substring(0, saying.length() - 1);
        String author = jsonObject.getString("a");
        Quote quote = new Quote(saying, author);
        return quote;
    }

    public Quote getQuoteOfTheDay() {
        return quoteOfTheDay;
    }
}
