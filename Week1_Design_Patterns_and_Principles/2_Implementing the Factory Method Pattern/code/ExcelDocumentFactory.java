package factory;
import document.Document;
import document.ExcelDocument;
public class ExcelDocumentFactory extends DocumentFactory{
@Override
public Document createdocument()
{
	return new ExcelDocument();
}
}
