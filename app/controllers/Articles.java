package controllers;

import java.util.List;

import models.Article;
import play.*;
import play.mvc.*;

import views.html.*;

public class Articles extends Controller {
	
    public static Result index() {
    	String url = "http://dna.daum.net/lens/";
    	List<Article> items = null;
    	try{
    		items = Article.list(url);
		} catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok(articles.render(items));
    }
  
}
