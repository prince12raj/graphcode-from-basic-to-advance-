import java.util.*;
public class C_Restructuring_Company {
    static class DSU{
        int parent[], size[];
        DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int find(int x){
            if(parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }
        void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb) return;

            if(size[pa]<size[pb]){
                parent[pa]=pb;
                size[pb]+=size[pa];
            }else{
                parent[pb]=pa;
                size[pa]+=size[pb];
            }
        }
    }
    static int next[];
    static int getNext(int x){
        if(next[x]==x) return x;
        return next[x]=getNext(next[x]);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        DSU dsu=new DSU(n);
        next=new int[n+2];
        for(int i=1;i<=n+1;i++){
            next[i]=i;
        }
        while(q-- >0){
            int type=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(type==1){
                dsu.union(x,y);
            }
            else if(type==2){
                int cur=getNext(x);
                while(cur<y){
                    dsu.union(cur,cur+1);
                    next[cur]=cur+1;
                    cur=getNext(cur);
                }
            }
            else{

                if(dsu.find(x)==dsu.find(y))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}