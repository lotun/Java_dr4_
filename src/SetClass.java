import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 04.04.2017.
 */
public class SetClass {
    public static void main(String args[]){
        //создадим и заполним множество
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        for (int i = 0;i<100;i++){
            int k1 = 0 + (int) (Math.random() * 40);
            int k2 = 0 + (int) (Math.random() * 40);
            set1.add(k1);
            set2.add(k2);
        }
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(union(set1,set2));
        System.out.println(intersect(set1,set2));

    }
    public static Set<Integer> union(Set<Integer> setK1, Set<Integer> setK2){
        setK1.addAll(setK2);
        return setK1;
    }
    public static Set<Integer> intersect(Set<Integer> setK1, Set<Integer> setK2){
        setK1.retainAll(setK2);
        return setK1;
    }
}
