class ticketMachineClass implements Runnable{
    static int ticket =10000;
    int machine;
    Thread t;

    ticketMachineClass(String name){
        machine=0;
        t = new Thread(this,name);
        t.start();
    }

    public void run(){
        int r;
        while((r=buyTicket())!= 0){
            if(r>0){
                machine = machine + r;
            }
        }
        System.out.println(t.getName()+"°â¥X¤F"+machine+"²¼");
       
    }

    private static synchronized int buyTicket(){
        int r = (int)(Math.random()*4)+1;
        if(ticket>=r){
            ticket = ticket-r;
            return r;
        }
        else if(ticket == 0){
            return 0;
        }
        else{
            return -1;
        }
    }

}
public class hw {
    public static void main(String[] args){

        ticketMachineClass m1 = new ticketMachineClass("machin1");
        ticketMachineClass m2 = new ticketMachineClass("machin2");
        ticketMachineClass m3 = new ticketMachineClass("machin3");
        ticketMachineClass m4 = new ticketMachineClass("machin4");

    } 
}
