/**
 * Created by Alex on 30.03.2017.
 */

import java.util.HashSet;
import java.util.Set;

public class Telrfon {
    Fio fio = new Fio();
    long nambe;
    Set<Long> list = new HashSet<>();
    int status=0;




    public String toString() {
        return fio.name+"   "+fio.lastNmae+"    "+nambe+"   "+list.size()+"   "+status+"\n";
    }

}
