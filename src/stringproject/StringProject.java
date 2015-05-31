
package stringproject;

public class StringProject {

    static final String in = "1. Найти наибольшее количество предложений текста, в которых есть одинаковые слова." +
                             "2. Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.";
    
    public static void main(String[] args) {
        //ChangeStr(in);
        Text t = new Text(in);
        t.swapFirstLast();
        System.out.println(t);
    }
    
}
