package model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// downloads an image of a cat from a url to the database
// https://www.youtube.com/watch?v=rd6m-6l2xQQ&list=PL-K6CIX0_zzgzI0sfBrvkjgP369jRrE3j&index=8
public class CatImageDownloader implements Runnable {
    private String link;
    private File out;
    private boolean isCompleted;

    public CatImageDownloader(String link, File out) {
        this.link = link;
        this.out = out;
        this.isCompleted = false;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            double fileSize = (double) http.getContentLengthLong();
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownloaded = 0.00;

            while ((read = in.read(buffer, 0, 1024)) >= 0) {
                bout.write(buffer, 0, read);
                downloaded += read;
                percentDownloaded = (downloaded * 100) / fileSize;
                String percent = String.format("%.4f", percentDownloaded);
                System.out.println("Downloaded " + percent + "% of a file.");
            }

            bout.close();
            in.close();
            System.out.println("Download complete.");
            isCompleted = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getCompletionStatus() {
        return isCompleted;
    }
}

// String link = ""; <---- put some link in the quotes
// File out = new File("C:\\Users\\Zoran Davidovic\\Desktop\\Java The Complete Reference.pdf");
// new Thread(new Download(link, out)).start();

//
// new Thread(new CatImageDownloader("cat.org", "C:Users\Yang\Coding projects\PurrfectHabits\data"));
// JsonReader reader = new JsonReader();
// reader.readAWard("name of award");