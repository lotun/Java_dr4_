/**
 * Created by Alex on 28.03.2017.
 */

import java.security.PublicKey;
import java.util.*;

import static java.lang.System.gc;

public class Dr4 {
    static int sizeAbon = 10000; //количесво абонентов

    public static void main(String args[]){
        //для генерации мы создадим заготовки для имен и фамилий
        //теперь заполним эти поля
        //для упрощение проигнорируем возможность женского имени и мужской фамилии или наоборот
        String[] name = {"Ваня","Петя","Степа","Саша","Миша","Лена","Света","Инна","Юля","Аня"};
        String[] listName = {"Иванов","Петров","Сидоров","Савельев","Романов","Минаева","Медведева","Инаева","Саратова","Севаноа"};
        String[] nam = {"7916","7926","7985","7977","7999","7495","7499","7968","7496","7498"};
        long[] namm; //массив номеров
        namm=new long[sizeAbon];

        int k1,k2,k3,k4,n;
        //Генерация номеров
        for (int i = 0; i<sizeAbon; i++){
            k3 = 0 + (int) (Math.random() * 9);//cслучайный код
            n = 1000000 + (int) (Math.random() * 9000000);//случайный номер
            namm[i] = Long.valueOf(nam[k3]+n+"");
        }

        //основноая коллекция, генерация
        ArrayList<Telrfon> abonent = new ArrayList<Telrfon>();

        //заполнение данных

        for (int i = 0; abonent.size()<sizeAbon; i++){
            Telrfon ab = new Telrfon();
             k1 = 0 + (int) (Math.random() * 9);//Случайное имя
             k2 = 0 + (int) (Math.random() * 9);//Случайная фамилия
             k3 = 0 + (int) (Math.random() * sizeAbon-1);//Случайный номер

            ab.fio.name=name[k1];
            ab.fio.lastNmae=listName[k2];
            ab.nambe=namm[k3];
            //генерация листа контактов
            for (short k = 0;k<10;k++){
                 k4 = 0 + (int) (Math.random() * sizeAbon-1);
                ab.list.add(namm[k4]);
            }
            abonent.add(i,ab);
            ab=null;
        }
        namm=null;
        gc();
        System.out.println("Генерация завершена");


        //пробегаем коллекцию в обратном порядке иищем есть ли номер абонента в контактах кого то из абонентов.
        //если есть, его статус увеличивается на 1
        for (ListIterator<Telrfon> iter = abonent.listIterator();iter.hasNext();){
            long statNambo=iter.next().nambe;
            for (int k = 0;k<sizeAbon;k++) {
                if(abonent.get(k).list.contains(statNambo)) abonent.get(k).status++;
            }
        }

        //берем только абонентов чей номер встречается более 20 раз
        for (ListIterator<Telrfon> iter = abonent.listIterator();iter.hasNext();) {
            Telrfon j =iter.next();
            if(j.status>20){System.out.println(j);}

        }
    }
}
