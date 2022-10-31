import java.util.*;

public class Dijkstra {

    static HashMap<Actor, Edge> dijkstra(HashMap<String, Actor> actors, Actor from, Actor to){
        HashMap<Actor, Edge> parents = new HashMap<Actor, Edge>();
        HashMap<Actor, Double> cost = new HashMap<Actor, Double>();
        ArrayList<HashMap<Actor, Edge>> list = new ArrayList();
        Actor v = null;
        Actor u = null;
        double min = Double.POSITIVE_INFINITY;

        for (Actor actor : actors.values()) {
            cost.put(actor, Double.POSITIVE_INFINITY);
        }
        cost.put(from, 0.0);

        while (!cost.isEmpty()){
            for (Actor actor : cost.keySet()) {
                if(cost.get(actor) <= min){
                    min = cost.get(actor);
                    v = actor;
                }
            }

            for (Edge edge : v.edges) {
                u = edge.getOtherActor(v);

                if(cost.containsKey(u) && (cost.get(v) + edge.weight) < cost.get(u)){
                    cost.put(u, (cost.get(v) + edge.weight));
                    parents.put(u, edge);
                }

                if(u == to){
                    list.add(parents);
                }
            }
            cost.remove(v);
            min = Double.POSITIVE_INFINITY;
        }
        return parents;
    }

     static LinkedHashMap<Actor, Movie> dijkstraShortestPath(HashMap<String, Actor> actors, Actor from, Actor to){
        HashMap<Actor, Edge> parents = dijkstra(actors, from, to);
        Actor v = to;
        LinkedHashMap<Actor, Movie> path = new LinkedHashMap<Actor, Movie>();
        while (parents.get(v) != null){
            path.put(v, parents.get(v).movie);
            v = parents.get(v).getOtherActor(v);
        }
        return path;
    }
}
