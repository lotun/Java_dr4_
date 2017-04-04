import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Alex on 04.04.2017.
 */
public class Employee {
    public static void main(String args[]){
        ArrayList<Emp> work = new ArrayList<Emp>();

        String[] name = {"Ваня","Петя","Степа","Саша","Миша","Коля","Влад","Макс","Марат","Виктор"};
        String[] listName = {"Иванов","Петров","Сидоров","Савельев","Романов","Минаев","Медведев","Инаев","Саратов","Севанов"};

        int k1,k2,k3;
        for (int i = 0; i<10; i++) {
            Emp wo = new Emp();
            k1 = 0 + (int) (Math.random() * 9);//Случайное имя
            k2 = 0 + (int) (Math.random() * 9);//Случайная фамилия
            k3 = 0 + (int) (Math.random() * 40);//стаж

            wo.fio.name = name[k1];
            wo.fio.lastNmae = listName[k2];//,"Петров","Сидоров","Савельев","Романов"
            wo.workAge = k3; //,\"Петя\",\"Степа\",\"Саша\",\"Миша\""
            work.add(wo);
        }
        System.out.println(work);

        printEmployee(work,7);
    }



    public static void printEmployee(Collection collec, int workAge){
        for (Iterator<Emp> iter = collec.iterator(); iter.hasNext();) {
            Emp d = iter.next();
            if (d.workAge == workAge) {
                System.out.println(d);
            }
        }
    }
}
