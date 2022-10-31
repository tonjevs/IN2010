import java.util.*;


public class Actor {
    String id;
    String navn;
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<Edge> edges = new ArrayList<Edge>();

    Actor(String i, String n){
        id = i;
        navn = n;
    }

    void addEdge(Edge e){
        edges.add(e);
    }

    void addMovies(Movie m){
        movies.add(m);
    }

    @Override
    public String toString() {
        return navn;
    }
    
}
