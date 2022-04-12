package textMarkup;

import java.util.List;

abstract class Markdown implements TextInterface {
    private final List<TextInterface> markdownList;
    private final String mark;

    Markdown(List<TextInterface> list, String mark) {
        markdownList = list;
        this.mark = mark;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(mark);
        for (TextInterface m : markdownList) {
            m.toMarkdown(stringBuilder);
        }
        stringBuilder.append(mark);
    }
}
