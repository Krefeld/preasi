import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class test {
    static ArrayList<String> output = new ArrayList<>();
    static FileWriter myWriter;
    public static void main(String[] args) {
        String temo = "var bild = " + '"' + "image" + '"' + ";for(var i = 1; i < 21; ++i){setImageURL(bild+i,"  + '"' + "Lessing.jpg" + '"' + ");}";
        String out_first = "onEvent(";
        String end = "; ++i){\nmyLoop(1,i+1);\n}\n});";
        String out = '"' + "click" + '"' + ",function(){\n" + temo + "for(i = 0; i <";
        String temp = '"' + "image";
        for(int i = 0; i < 21; ++i){
            String finl = out_first + temp + String.valueOf(i+1) + '"' + ',' + out + (i+1) + end;
            output.add(finl+"\n"); 
        }

        //var bild = "image";for(var i = 1; i < 21; ++i){setImageURL(bild+i,"Lessing.jpg");

        //onEvent(image2"click",function(){});

        System.out.println(output);
        try {
            myWriter = new FileWriter("!test.txt");
            for(String i : output){
                myWriter.write(i + "\n");
            }
            myWriter.close();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
