package textMarkup;

import java.util.List;

public class Strikeout extends Markdown {
    Strikeout(List<TextInterface> list) {
        super(list, "~");
    }
}
