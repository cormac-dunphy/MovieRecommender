package models;

public class Movie {
	public Long counter = 0l;
	public Long id;
	public String title;
	public String year;
	public String url;

	public Movie(String title, String year, String url)
	{
		this.id = id;
		this.title = title;
		this.year = year;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString()
	{
		return  title + ' ' + year  + ' ' + url;
	}
}
