import java.util.*;

class Main{
    static HashMap<String, Boolean> visit;
    static HashMap<String, ArrayList<String>> graph;

    public static void main(String[] args){
        graph = new HashMap<>();
        visit = new HashMap<>();
        graph.put("A",new ArrayList<>(Arrays.asList("D","C","B")));
        graph.put("B",new ArrayList<>(Arrays.asList("F","A")));
        graph.put("C",new ArrayList<>(Arrays.asList("E","A","F")));
        graph.put("D",new ArrayList<>(Arrays.asList("A")));
        graph.put("E",new ArrayList<>(Arrays.asList("C")));
        graph.put("F",new ArrayList<>(Arrays.asList("C","B")));
        visitSet(false);
        dfs("A");
        System.out.println();
        visitSet(false);
        bfs("A");
    }
    static void bfs(String Start){
        visit.put(Start,true);
        System.out.print(Start+" ");
        ArrayList<String> que = new ArrayList<>();
        que.add(Start);

        while(! que.isEmpty()){
            String x = que.remove(0);
            for(String y : graph.get(x)){
                if(visit.get(y)){
                    continue;
                }
                que.add(y);
                visit.put(y,true);
                System.out.print(y+" ");
            }
        }
    }

    static void dfs(String x){
        visit.put(x,true);
        System.out.print(x+" ");

        for(String y : graph.get(x)){
            if(visit.get(y)){
                continue;
            }
            dfs(y);
        }
    }
    static void visitSet(boolean bool){
        visit.clear();
        for(String key : graph.keySet()){
            visit.put(key, false);
        }
    }
}