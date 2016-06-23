package ObserverPattern;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

	
	public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();

        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());

	    meteoStation.set(25, 730);
        meteoStation.set(-10, 754);
    }
}


interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void set(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer{
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer{

    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather is changed. Temperature = " + temp + ", Pressure = " + presser + ".");
    }
}

class FileObserver implements Observer{

    @Override
    public void handleEvent(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Weather is changed. Temperature = " + temp + ", Pressure = " + presser + ".");
            pw.println();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}