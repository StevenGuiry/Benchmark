package benchmark;

public class UnionExamples {

    private static int find(int[] a, int id) {
        return a[id]==id ? id : find(a,a[id]);
    }

    static void quickUnionv1(int[] a, int p, int q) {
        a[find(a,q)]=p;
    }

    static void quickUnionv2(int[] a, int p, int q) {
        a[find(a,q)] = find(a,p);
    }

    static void unionBySize(int [] a, int p, int q) {
        int rootp = find(a,p);
        int rootq = find(a,q);

        int biggerRoot = a[rootp]<a[rootq] ? rootp : rootq;
        int smallerRoot=biggerRoot==rootp ? rootq : rootp;

        int smallSize=a[smallerRoot];
        a[smallerRoot]= biggerRoot;
        a[biggerRoot]+=smallSize;
    }
}
