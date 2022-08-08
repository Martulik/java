package textMarkup;

import java.util.List;

public class Strong extends Markdown {
    Strong(List<TextInterface> list) {
        super(list, "__");
    }
}
