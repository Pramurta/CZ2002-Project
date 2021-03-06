package view.admin;

import controller.FileReadWriteController;
import controller.IOController;
import controller.MovieListingController;
import controller.ViewController;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static controller.IOController.*;

public class DeleteMovieView extends ViewController {
   //View to guide the user through the Movie deletion process, provide correct inputs and provide feedback.
     /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

     /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu(){
        printTitle("Delete movie listing");

        Movie movie = new Movie(); //To store the movie to be deleted 
        ArrayList<Movie> movieList = MovieListingController.getAllMovie(); //ArrayList of all the movies
        if(movieList.size() == 0)
            System.out.println("There is no movie yet!");
        else {
            int i = 1;
            System.out.println("List of movies:");
            for (Movie m : movieList) {
                System.out.println(i + ". " + m.getMovieTitle() + "   (" + m.getStringShowingStatus() + ")");
                i++;
            }
        }
        System.out.println("Please enter the index number of the movie you want to delete listing\n" +
                "Enter 0 to go back");
        int choice = getChoice(0, movieList.size());
        if (choice == 0)
            return;
        else
            movie = movieList.get(choice - 1);

        String movieTitle = movie.getMovieTitle();
        MovieListingController.deleteMovie(movieTitle);
        System.out.println("Successfully delete movie!");
        getString("Press ENTER to continue");
    }
}
