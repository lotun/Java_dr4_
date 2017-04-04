import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Alex on 04.04.2017.
 */
public class Remove {
    public static void main(String args[]){
        ArrayList<Integer> n = new ArrayList<Integer>();
        for (int i =0;i<70;i++){
            n.add(i);
        }
        System.out.println(n);

        for (ListIterator<Integer> iter = n.listIterator();iter.hasNext();){
            if (iter.next() % 2 == 1){
                iter.remove();
            }
        }
        System.out.println(n);
    }
}
