package lab3.human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorysBible {
    private static List<String> beginList = new ArrayList(Arrays.asList("Короче, пацаны, анекдот. Говорят, что физика Роберта Уотсона однажды арестовала полиция за превышение скорости. А он им и говорит: ", "Внимание, анекдот. Звонит мужик в полицию: 'Ало! Полиция? У нас тут соседи травкой торгуют!' Ему отвечают: 'И сколько за кг?' 'Ну, десять баксов.' А диспетчер ему: ", "Тихо все! Значит так... Везут в автозаке чукчу и других заключенных, поймали на границе. Видит водитель: по встречке фура летит, прямо в кутузку. \n" +
            "Он шепчет чукче: 'Мы щас столкнемся, отвлеки зэков, чтоб панику не подняли'. А чукча и говорит остальным: 'Хотите, я чихну, и машина развалится!'. Взял да и чихнул. \n" +
            "Машина - в щепки. Из под обломков вылезает полицейский, и говорит: "));
    private static List<String> endList = new ArrayList(Arrays.asList("'Дурак ты, чукча, и шутки у тебя дурацкие.'", "'Отлично, берите! Совсем не дорого!'", "'Если бы знал, что так будет, никогда не изобрёл бы радар!'"));

    public static void addBeginning(String begin){
        beginList.add(begin);
    }
    public static void addEnding(String end){
        endList.add(end);
    }

    public static List<String> getBeginList(){
        return beginList;
    }
    public static List<String> getEndList(){
        return endList;
    }
}
