public class Mif {
    

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int length = 10;
        arr = erzeugen(length);
        play(length, arr);
    }

    static ArrayList<Integer> erzeugen(int max){
        ArrayList<Integer> auswahl = new ArrayList<>();
        for(int i = 1; i < max; ++i){
            auswahl.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Random ra =  new Random();
        while(auswahl.size() >= 1){
            int r = ra.nextInt(auswahl.size());
            while(r > auswahl.size()){
                r = ra.nextInt(auswahl.size()-1);
            }
            res.add(auswahl.get(r));
            auswahl.remove(r);
        }
        return res;
    }

    static void play(int Grenze, ArrayList<Integer> arr){
        List<Integer> arr_left = new ArrayList<>();
        List<Integer> arr_right = new ArrayList<>();
        System.out.println(arr);
        int best = 0;
        double b_p = 0.37;
        int boarder = (int)(b_p * Grenze);
        arr_left = arr.subList(0, boarder+1);
        arr_right = arr.subList(boarder + 1, arr.size());
        System.out.println("linke Hälfte " + arr_left + "\nrechte Hälfte " + arr_right);
        
        if(Collections.max(arr_left) == Collections.max((arr))){
            System.out.println("Strategie fehlgeschlagen, weil das beste Element schon unter den 37% war");
            return;
        }
        best = Collections.max((arr_left));
        System.out.println("bis jetzt bestes gefundene: " + Collections.max(arr_left) + "  am Index: " + arr.indexOf(Collections.max(arr_left)));

        for(int i = b +1; i < arr.size(); ++i){
            if(arr.get(i) > best){
                best = arr.get(i);
                break;
            }
        }

        if(Collections.max(arr) == best)
            System.out.println("Strategie ist aufgegangen, bestes Element " + best + "  am Index: " + arr.indexOf(best));
        else
            System.out.println("Strategie fehlgeschlagen, besseres Element gefunden: " + best + "  das beste ist aber: " + Collections.max(arr) + " am Index: " + arr.indexOf(Collections.max(arr)));
    }
}
