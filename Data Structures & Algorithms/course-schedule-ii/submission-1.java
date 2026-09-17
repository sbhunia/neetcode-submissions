class Solution {
    /*
    0 DFS -> 1 -> 2


    */
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    List<Integer> courseOrder = new ArrayList<>();
    Set<Integer> path = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //first lets create empty adjacency list in terms of Map
        for(int i=0; i<numCourses; i++)
            adjList.put(i, new ArrayList<>());
        // now add the edges / prereqs as edge to the adjacency list 
        for(int[] prereq: prerequisites)
            adjList.get(prereq[0]).add(prereq[1]);
        
        for(int course =0; course< numCourses; course++){
            if(!dfs(course)){
                return new int [] {};
            }
        }
        int [] order = new int[courseOrder.size()];
        for(int i=0; i<courseOrder.size(); i++)
            order[i]=courseOrder.get(i);
        return order;   
    }
    boolean dfs(int course){
        // find if it arrive at a loop, i.e. already a course is in path
        if(path.contains(course))
            return false;
        if(courseOrder.contains(course))
            return true;
        path.add(course);
        for(int prereq: adjList.get(course)){
            if(!dfs(prereq)){
                return false;
            }
        }
        // after satisfying the prereqs check if the course has already been 
        // taken or not. 
        
        courseOrder.add(course);
        path.remove(course);
        adjList.put(course, new ArrayList<>());
        return true;
    }
}
