interface switchable{
    void on();
    void off();
 boolean isOn();
    default void toggle(){
        if(isOn()){
            off();
        } else {
            on();
        }
    }
}

class Fan implements switchable{
     boolean isOn = false;
    @Override
    public void on() {
        isOn = true;
        System.out.println("Fan is on");
    }

    @Override
    public void off() {
        isOn = false;
        System.out.println("Fan is off");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

class light implements switchable{
   boolean isOn = false;
    @Override
    public void on() {
        isOn = true;
        System.out.println("Light is on");
    }

    @Override
    public void off() {
        isOn = false;
        System.out.println("Light is off");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}

public class Remotecontrol{

    public static void main(String[] args) {
        switchable[] devices = {new Fan(), new light()};

        for(switchable device : devices){
            device.toggle();
        }

        SwitchPolicy Policy1 = new SwitchPolicy() {
    
    public boolean mySwitchOn(switchable device, int hour){

    return hour >=6 && hour <=10;
    }
    };
 }

   
}

interface SwitchPolicy{
    boolean mySwitchOn(switchable device,int hour);
}


