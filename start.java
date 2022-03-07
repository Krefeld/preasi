//import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
public class test{
    public static void main(String[] args) {
        akzeptor a= new akzeptor("H://eclipse Q1//Akzeptoren//Input");   
        System.out.println(a.testInput("ab"));
        a.test();
    }

    static class akzeptor{
        Knoten start;
        ArrayList<Knoten> Zustand = new ArrayList<>();
        ArrayList<Knoten> Ende = new ArrayList<>();
        ArrayList<String> Eingabe = new ArrayList<>();
        class Knoten{
            String name;
            ArrayList<Knoten> next;
            public Knoten(String name){
                this.name = name;
            }

            public void setNext(ArrayList<Knoten> next){
                this.next = next;
            }
        }


        void test(){
            System.out.println(Zustand + " " + Eingabe + " " + start +"  " + Ende);
        }
        public akzeptor(String pfad){
            //H:\eclipse Q1\Akzeptoren\Input
            createZustand(pfad + "Zustand.txt");
            createEingabeif(pfad + "Eingabe.txt");
            createStart(pfad + "start.txt");
            createEnde(pfad + "Ende.txt");
            createFunktion(pfad + "Ub.txt");

        }

        void getInput(String pfad, ArrayList<String> arr){
            String data;
            try{
                File myObject = new File(pfad);
                Scanner scan = new Scanner(myObject);
                while(scan.hasNextLine()){
                    data = scan.nextLine();
                    arr.add(data);
                }
                scan.close();
            }catch(FileNotFoundException e){
                
            }
        }

        void createZustand(String pfad){
            ArrayList<String> List = new ArrayList<>();
            getInput(pfad, List);

            for(int i = 0; i < List.size(); ++i){
                String temp = "";
                for(int x = 0; x < List.get(i).length(); ++x){
                   if(List.get(i).charAt(x) == ','){
                       Zustand.add(new Knoten(temp));
                       temp =  "";
                    }else{
                        temp += List.get(i).charAt(x);
                    } 
                }
                Zustand.add(new Knoten(temp));
            }
        }

        void createEingabeif(String pfad){
            ArrayList<String> List = new ArrayList<>();
            getInput(pfad, List);

            for(int i = 0; i < List.size(); ++i){
                String temp = "";
                for(int x = 0; x < List.get(i).length(); ++x){
                        
                    if(List.get(i).charAt(x) == ','){
                        Eingabe.add(temp);
                        temp = "";
                    }else{
                        temp += List.get(i).charAt(x);
                    }
                }
                Eingabe.add(temp);
            }
            
        }

        void createEnde(String pfad){
            ArrayList<String> List = new ArrayList<>();
            getInput(pfad, List);

            for(String i : List){
                String temp = "";
                for(int x = 0; x < i.length(); ++x){
                    if(i.charAt(x) == ','){
                        for(int y = 0; y < Zustand.size(); ++y){
                            if(temp.compareTo(Zustand.get(y).name) == 0){
                                Ende.add(Zustand.get(y));
                                temp = "";
                            }  
                        }
                    }else{
                        temp += i.charAt(x);
                    }
                }
            }
        }

        void createStart(String pfad){
            ArrayList<String> List = new ArrayList<>();
            getInput(pfad, List);
            
            for(Knoten i : Zustand){
                if(List.get(0).compareTo(i.name) == 0){
                    start = i;
                }
            }
        }

        void createFunktion(String pfad){
            ArrayList<String> List = new ArrayList<>();
            getInput(pfad, List);

            for(int i = 0; i < List.size(); ++i){
                String temp = "";
                ArrayList<Knoten> tempList = new ArrayList<>();

                for(int x = 0; x < List.get(i).length(); ++x){
                    if(List.get(i).charAt(x) == ','){
                        for(Knoten y : Zustand){
                            if(y.name.compareTo(temp) == 0){
                                tempList.add(y);
                                temp = "";
                            }
                        }
                    }else{
                        temp += List.get(i).charAt(x);
                    }
                }
                for(Knoten y : Zustand){
                    if(y.name.compareTo(temp) == 0){
                        tempList.add(y);
                        temp = "";
                    }
                }
                Zustand.get(i).setNext(tempList);
            }
        }

        boolean testInput(String in){
            Knoten starten = start;
            for(int i = 0; i < in.length(); ++i){
                char buchstabe = in.charAt(i);
                for(int x = 0; x < Eingabe.size(); ++x){
                    if(Character.toString(buchstabe).compareTo(Eingabe.get(x)) == 0){
                        starten = starten.next.get(x);
                    }
                }
            }

            if(Ende.contains(starten)){
                return true;
            }
            return false;
        }


    }
}
