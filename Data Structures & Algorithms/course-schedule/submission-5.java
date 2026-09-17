class Solution {
    Map<Integer, List<Integer>> adjMap;
    HashSet<Integer> visited;
    HashSet<Integer> path = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        adjMap = new HashMap<Integer, List<Integer>>();
        for(int i=0; i< numCourses; i++)
            adjMap.put(i, new ArrayList<>());
        
        visited = new HashSet<>();
        for(int[] prereq : prerequisites)
            adjMap.get(prereq[0]).add(prereq[1]);
        
        for(int course: adjMap.keySet()){
            if(!visited.contains(course)){
                if(!dfs(course))
                    return false;
            }
        }
        return true;

    }
    boolean dfs(int course){
        if(path.contains(course)) // cycle detected
            return false;
        path.add(course);
        visited.add(course);
        for(int prereq: adjMap.get(course)){
            if(! dfs(prereq))
                return false;
        }
        path.remove(course);
        adjMap.put(course, new ArrayList<>());
        return true;
    }

}
