// Efectuaţi înmultirea a două polinoame de grad fix, în cazul în care coeficienţii
//polinoamelor sunt stocaţi în liste.

//import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

class MyException extends Exception{

    public MyException(String s) {
        super(s);
    }
}

class Mux{

    public Palinom inmultire(Palinom p1, Palinom p2){
        Palinom rezultat =new Palinom();
        Termen t,t1;
        for (int i = 0; i < p1.termeni.size(); i++) {
            t=p1.termeni.get(i);
            for (int j = 0; j < p2.termeni.size(); j++){
                t1=p2.termeni.get(j);
                Termen temp=new Termen();
                temp.putere=t.putere+ t1.putere;
                temp.coeficient= t.coeficient * t1.coeficient;

                rezultat.termeni.add(temp);
            }
        }

        return rezultat;
    }
}
class Termen{
    public int coeficient;
    public int putere;

}
class Palinom {

    public int grad;
    ArrayList<Termen> termeni = new ArrayList<>();

    public void setPolinom(int g) {

        try {
            if (g <= 0) {
                throw new IllegalArgumentException("Gradul polinomului trebuie să fie un număr pozitiv nenul.");
            }
            grad = g;
            Random rand = new Random();


            for (int i = 0; i < g; i++) {
                Termen t = new Termen();
                t.coeficient = rand.nextInt(100);
                t.putere = rand.nextInt(10);
                termeni.add(t);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
        //finally {
        //    System.out.println("Aici poate avea loc inchiderea fisierului");
        //}
    }

    public void getPolinom() throws MyException {
        try {

            if (termeni == null || termeni.isEmpty()) {
                throw new MyException("Polinomul nu are termeni.");
            }
            Termen t;
            for (int i = 0; i < termeni.size(); i++) {
                t = termeni.get(i);
                System.out.println(t.coeficient + "x^" + t.putere);
            }
        } catch (MyException e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) throws MyException {
        System.out.println("Hello world!");
        Palinom p1=new Palinom();
        Palinom p2=new Palinom();
        p1.setPolinom(2);
        p1.getPolinom();
        System.out.println(" ");
        p2.setPolinom(3);
        p2.getPolinom();
        System.out.println(" ");
        Mux m =new Mux();
        Palinom pRez=m.inmultire(p1,p2);
        pRez.getPolinom();

        p2.setPolinom(-2);
    }
}

