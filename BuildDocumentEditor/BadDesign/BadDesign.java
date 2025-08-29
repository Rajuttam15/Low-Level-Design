package BuildDocumentEditor.BadDesign;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
public class BadDesign {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addtext("Hello World");
        editor.addImage("image.jpg");
        String rendered = editor.renderDocument();
        System.out.println(rendered);
        editor.saveToFile();
    }
}
class DocumentEditor {
    private List<String> DocumentElements;
    private String renderedDocument;

    public DocumentEditor() {
        this.DocumentElements = new ArrayList<>();
        this.renderedDocument = "";
    }

    public void addtext(String text) {
        DocumentElements.add(text);
        renderedDocument += text + "\n";
    }
    public void addImage(String imagePath) {
        DocumentElements.add(imagePath);
        renderedDocument += "Image: " + imagePath + "\n";
    }
    //renders the document by checking the type at the runtime
        public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : DocumentElements) {
                if (element.length() > 4 && 
                   (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }
    //save to file
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderedDocument);
            writer.close();
            System.out.println("Document saved to document.txt");
        }
        catch(IOException e) {
            System.out.println("An error occurred while saving the document.");
            e.printStackTrace();
        }
    }
}