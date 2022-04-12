package textMarkup;

public class Text implements TextInterface {
    String string;

    public Text(String s) {
        string = s;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(string);
    }
}
