class Solution {
    void bfs(List<List<Integer>> list ,int src2 ,boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src2);
        while(!q.isEmpty()){
            int src = q.remove();
            if(!vis[src]){
                vis[src] = true;
                for(int i=0; i<list.get(src).size(); i++){
                    int dest = list.get(src).get(i);
                    q.add(dest);
                }
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
            list2.add(i);
        }
        for(int i=0;i<arr.length;i++){
            list.get(arr[i][0]).add(arr[i][1]);
        }
        boolean vis[] = new boolean[n];
        
        bfs(list , k , vis);
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                for(int j=0; j<list.get(i).size(); j++){
                    int dest = list.get(i).get(j);
                    if(vis[dest]){
                        return list2;
                    }
                }
            }
        }
        List<Integer> list3 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                list3.add(i);
            }
        }
        return list3;
    }
}