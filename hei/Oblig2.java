import java.util.*;
import java.io.*;
class Oblig2{
    public static void main(String[] args) throws IOException {



        //HER STARTER OPPGAVE 1 
        long startTimeTot = System.nanoTime();
        long startTime1 = System.nanoTime();
        System.out.println("Oppgave 1: \n");
        String N;
        HashMap<String, Movie> movies = new HashMap<String, Movie>();
        HashMap<String, Actor> actors = new HashMap<String, Actor>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        BufferedReader Mfile = new BufferedReader(new FileReader("movies.tsv"));
        while((N = Mfile.readLine()) != null){
            String[] biter = N.split("\t");
            movies.put(biter[0], new Movie(biter[0], biter[1], Double.parseDouble(biter[2])));
        }
        Mfile.close();

        BufferedReader Afile = new BufferedReader(new FileReader("actors.tsv"));
        while((N = Afile.readLine()) != null){
            String[] biter = N.split("\t");
            Actor a = new Actor(biter[0], biter[1]);

            for (int j = 2; j < biter.length; j++) {
                if (movies.get(biter[j]) != null){
                    a.addMovies(movies.get(biter[j]));
                    movies.get(biter[j]).addActor(a);

                }

            }
            actors.put(biter[0], a);


        }
        Afile.close();

        for (String m : movies.keySet()) {
            Movie movie = movies.get(m);
            for (int i = 0; i < movie.actors.size(); i++) {
                for (int j = i+1; j < movie.actors.size(); j++) {
                    Actor a1 = movie.actors.get(i);
                    Actor a2 = movie.actors.get(j); 
                    Edge edge = new Edge(movie, a1, a2);
                    a1.addEdge(edge);
                    a2.addEdge(edge);
                    edges.add(edge);
                }
            }
        }
        System.out.println("Nodes: " + actors.size());
        System.out.println("Edges: " + edges.size());

        long endTime1   = System.nanoTime();
        long totalTime1 = endTime1 - startTime1;
        System.out.println("Tid brukt: "+totalTime1/1000000 + "ms");



        // HER STARTER OPPGAVE 2    
        long startTime2 = System.nanoTime();
        System.out.println("\n\nOppgave 2: \n");

        Actor a1 = actors.get("nm2255973");
        Actor a2 = actors.get("nm0000460");
        Actor a3 = actors.get("nm0424060");
        Actor a4 = actors.get("nm0000243");
        Actor a5 = actors.get("nm4689420");
        Actor a6 = actors.get("nm0000365");
        Actor a7 = actors.get("nm0000288");
        Actor a8 = actors.get("nm0001401");
        Actor a9 = actors.get("nm0031483");
        Actor a10 = actors.get("nm0931324");


        
        LinkedHashMap<Actor, Movie>  kortesteVei = Bfs.bfsShortestPath(a1, a2);
        List<Actor> reversedKeys = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a1);
        for (Actor actor : reversedKeys) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a3, a4);
        reversedKeys = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a3);
        for (Actor actor : reversedKeys) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a5, a6);
        reversedKeys = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a5);
        for (Actor actor : reversedKeys) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a7, a8);
        reversedKeys = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a7);
        for (Actor actor : reversedKeys) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a9, a10);
        reversedKeys = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a9);
        for (Actor actor : reversedKeys) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");


        long endTime2   = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("Tid brukt: "+totalTime2/1000000 + "ms");




        // HER STARTER OPPGAVE 3    
        long startTime3 = System.nanoTime();
        System.out.println("\n\nOppgave 3: \n");
        Double weight = 0.0;

        LinkedHashMap<Actor, Movie>  chillestevei = Dijkstra.dijkstraShortestPath(actors, a1, a2);
        reversedKeys = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a1);
        for (Actor actor : reversedKeys) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a3, a4);
        reversedKeys = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a3);
        for (Actor actor : reversedKeys) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a5, a6);
        reversedKeys = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a5);
        for (Actor actor : reversedKeys) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a7, a8);
        reversedKeys = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a7);
        for (Actor actor : reversedKeys) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a9, a10);
        reversedKeys = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedKeys);
        System.out.println(a9);
        for (Actor actor : reversedKeys) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;




        long endTime3   = System.nanoTime();
        long totalTime3 = endTime3 - startTime3;
        System.out.println("Tid brukt: "+totalTime3/1000000 + "ms");

        long endTimeTot   = System.nanoTime();
        long totalTimeTot = endTimeTot - startTimeTot;
        System.out.println("\nTotal tid brukt: "+totalTimeTot/1000000 + "ms");

    }


}