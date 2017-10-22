package models;

public class Rating {
	public long userID;
	public long movieID;
	public long movieRating;
	public long userTimestamp;

	public Rating(long userID, long movieID, long movieRating, long userTimestamp)
	{
		this.setUserID(userID);
		this.setMovieID(movieID);
		this.setMovieRating(movieRating);
		this.setUserTimestamp(userTimestamp);
	}

	public long getUserTimestamp() {
		return userTimestamp;
	}

	public void setUserTimestamp(long userTimestamp) {
		this.userTimestamp = userTimestamp;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getMovieID() {
		return movieID;
	}

	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}

	public long getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(long movieRating) {
		this.movieRating = movieRating;
	}

	public String toString()
	{
		return  Long.toString(userID) + ' ' + Long.toString(movieID)  + ' ' + Long.toString(movieRating) + ' ' + Long.toString(userTimestamp);
	}

}
