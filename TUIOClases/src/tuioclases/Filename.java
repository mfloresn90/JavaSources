package tuioclases;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author XxYoshiBlackxX
 */
class Filename {

    private String fullPath;
    private File fe;

    public Filename(String str) {
        fe = new File(str);
        fullPath = str;
    }

    public String getPath() throws IOException {
        String absolutePath = fe.getAbsolutePath();
    	String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
        filePath += "\\";
        return filePath;
    }

    public String getNameWithExtension() {
        String name = fe.getName();
        return name;
    }
    
    public String getNameWithOutExtension() {
        String fullname = fe.getName();
        if (fullname == null) return null;
        int pos = fullname.lastIndexOf(".");
        if (pos == -1) return fullname;
        return fullname.substring(0, pos);
    }
    
    public String getExtension() {
        String name = fe.getName();
        return name.substring(name.lastIndexOf('.'), name.length());
    }
    
}