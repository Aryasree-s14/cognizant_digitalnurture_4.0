package factory;
import document.Document;
import document.WordDocument;
public class WordDocumentFactory extends DocumentFactory {
@Override
public Document createdocument() {
	return new WordDocument();
}
}
