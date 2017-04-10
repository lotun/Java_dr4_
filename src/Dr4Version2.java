/**
 * Created by Alex on 28.03.2017.
 */

import sun.reflect.generics.tree.Tree;

import java.security.PublicKey;
import java.util.*;

import static java.lang.System.gc;

public class Dr4Version2 {
    static int sizeAbon = 1000000; //количесво абонентов

    public static void main(String args[]){
        TreeMap<Integer,Telrfon> abonent = new TreeMap<Integer,Telrfon>();
        TreeMap<Integer,Long> HashNom = new TreeMap<>();
        int k1,k2,k3,k4,n;

        //для генерации мы создадим заготовки для имен и фамилий
        //теперь заполним эти поля
        //для упрощение проигнорируем возможность женского имени и мужской фамилии или наоборот
        String[] name = {"Ваня","Петя","Степа","Саша","Миша","Лена","Света","Инна","Юля","Аня"};
        String[] listName = {"Иванов","Петров","Сидоров","Савельев","Романов","Минаева","Медведева","Инаева","Саратова","Севаноа"};
        String[] nam = {"7916","7926","7985","7977","7999","7495","7499","7968","7496","7498"};



        //Генерация номеров
        for (int i = 0; i<sizeAbon; i++){
            k3 = 0 + (int) (Math.random() * 9);//cслучайный код
            n = 1000000 + (int) (Math.random() * 9000000);//случайный номер
            HashNom.put(i,Long.valueOf(nam[k3]+n+""));
        }

        //основноая коллекция, генерация

        //заполнение данных

        for (int i = 0; abonent.size()<sizeAbon; i++){
            Telrfon ab = new Telrfon();
            k1 = 0 + (int) (Math.random() * 9);//Случайное имя
            k2 = 0 + (int) (Math.random() * 9);//Случайная фамилия

            Integer k5 = new Integer(0 + (int) (Math.random() * sizeAbon-1));

            ab.fio.name=name[k1];
            ab.fio.lastNmae=listName[k2];
            ab.nambe=HashNom.get(k5);

            //генерация листа контактов
            for (short k = 0;k<20;k++){

                Integer k6 = new Integer(0 + (int) (Math.random() * sizeAbon-1));
                ab.list.add(HashNom.get(k6));
            }
            abonent.put(i,ab);
            ab=null;
        }

        gc();
        abonent.comparator();
        System.out.println("Генерация завершена");


        //пробегаем коллекцию в обратном порядке иищем есть ли номер абонента в контактах кого то из абонентов.
        //если есть, его статус увеличивается на 1
        int proc = HashNom.size()/10;
        int k = 0;
        for (Map.Entry<Integer, Long> iterHash : HashNom.entrySet()){
            k++;
            for (Map.Entry<Integer, Telrfon> iter : abonent.entrySet()){
                Telrfon h = iter.getValue();
                    if(h.list.contains(iterHash.getValue())) {
                        h.status++;
                        h=null;
                        break;
                    }
            }
            if (k % proc == 1) System.out.println((k / proc)*10 + " процентов выполнено");
        }

        //берем только абонентов чей номер встречается более 20 раз
        for (Map.Entry<Integer, Telrfon> iter : abonent.entrySet()) {
            Telrfon j =iter.getValue();
            if(j.status>20){System.out.println(j);}

        }
    }
}
