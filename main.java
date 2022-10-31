import java.util.*;
import java.io.*;
class Oblig2{
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        String N;
        HashMap<String, Movie> movies = new HashMap<String, Movie>();
        HashMap<String, Actor> actors = new HashMap<String, Actor>();
        BufferedReader Mfile = new BufferedReader(new FileReader("movies.tsv"));
        while((N = Mfile.readLine()) != null){
            String[] biter = N.split("\t");
            movies.put(biter[0], new Movie(biter[0], biter[1], Float.parseFloat(biter[2])));
        }
        Mfile.close();

        BufferedReader Afile = new BufferedReader(new FileReader("actors.tsv"));
        while((N = Afile.readLine()) != null){
            String[] biter = N.split("\t");
            ArrayList<Movie> starredIn = new ArrayList<Movie>();

            for (int j = 2; j < biter.length; j++) {
                if (movies.get(biter[j]) != null){
                    starredIn.add(movies.get(biter[j])); 
                }

            }
            actors.put(biter[0], new Actor(biter[0], biter[1], starredIn));


        }
        Afile.close();

        for (String actor : actors.keySet()) {
            Actor a1 = actors.get(actor);
            for (Movie movie : a1.movies) {
                for (String actorCheck : actors.keySet()) {
                    Actor a2 = actors.get(actorCheck);
                    if(a1 != a2){
                        if (a2.movies.contains(movie)){
                            Edge edge = new Edge(movie, a1, a2);
                            System.out.print(".");
                            a1.addEdge(edge);
                            a2.addEdge(edge);
                        }
                    }
                }
            }
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000000 + "ms");

    }
}