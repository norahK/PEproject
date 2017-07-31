package qrcure.qrcure;

import java.util.Date;

/**
 * ether Artical or Instruction
 */

public class Topic {
    String title;
    String[]subtitles;
    User writer;
    String[] body;
    int views;
    int num_of_likes;
    Date date;
    //Specility as enum

    public Topic(){

    }

    public Topic(String title, String[] subtitles, User writer, String[] body, int views, int num_of_likes, Date date) {
        this.title = title;
        this.subtitles = subtitles;
        this.writer = writer;
        this.body = body;
        this.views = views;
        this.num_of_likes = num_of_likes;
        this.date = date;
    }

    //content with sub title and content for each sub

}
