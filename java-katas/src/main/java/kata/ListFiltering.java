package kata;

import java.util.List;

public class ListFiltering {

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(Integer.class::isInstance)
                .toList();
    }

}
