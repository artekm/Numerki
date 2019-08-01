package numerki;
public abstract class FileChecker {

	public abstract String getType();
	public abstract String getTypeExt();

	public abstract boolean checkHeader(File file);
	public abstract boolean checkExtension(File file);
}
