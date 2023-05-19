import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Punto {

    private double x;
    private double y;


    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public static int leerNumeroPuntos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de puntos");
        int numPuntos = sc.nextInt();
        return numPuntos;
    }

    public static List<Punto> ingresarPuntos(int numPuntos){
        List<Punto> listaPuntos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numPuntos; i++) {
            System.out.println("Ingrese la componente X del punto "+i);
            double x = sc.nextDouble();
            System.out.println("Ingrese la componente Y del punto "+i);
            double y = sc.nextDouble();
            listaPuntos.add(new Punto(x,y));
        }
        return listaPuntos;
    }

    public static List<Double> calcularDistancias(List<Punto> listaPuntos){
        List<Double> listaDistancias = new ArrayList<>();
        for (int i = 0; i < listaPuntos.size()-1; i++) {
            for (int j = i+1; j < listaPuntos.size(); j++) {
                Punto punto1 = listaPuntos.get(i);
                Punto punto2 = listaPuntos.get(j);
                double dist = punto1.calcularDistancia(punto2);
                System.out.println("d"+i+" dist: "+dist);
                listaDistancias.add(dist);
            }
        }
        return listaDistancias;
    }

    public static double obtenerMayor(List<Double> listaDistacias){
        double mayor=0;
        for (int i = 0; i < listaDistacias.size(); i++) {
            if(i==0){
                mayor=listaDistacias.get(i);
            } else if (listaDistacias.get(i)>=mayor) {
                mayor=listaDistacias.get(i);
            }
        }
        return mayor;
    }

    public static double obtenerMayor2(List<Double> listaDistacias){
        double mayor=listaDistacias.stream()
                .mapToDouble(x->x)
                .max()
                .orElseThrow(NoSuchElementException::new);
        return mayor;
    }

    public static double obtenerMenor2(List<Double> listaDistacias){
        double mayor=listaDistacias.stream()
                .mapToDouble(x->x)
                .min()
                .orElseThrow(NoSuchElementException::new);
        return mayor;
    }

    public static double obtenerMenor(List<Double> listaDistacias){
        double mayor=0;
        for (int i = 0; i < listaDistacias.size(); i++) {
            if(i==0){
                mayor=listaDistacias.get(i);
            } else if (listaDistacias.get(i)<=mayor) {
                mayor=listaDistacias.get(i);
            }
        }
        return mayor;
    }

    public double calcularDistancia(Punto punto2){
        double dist = Math.sqrt(Math.pow(x-punto2.getX(),2)+Math.pow(y-punto2.getY(),2));
        return dist;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
