package link.imcloud.jrs.utills;

import java.util.ArrayList;
import java.util.List;

public class UploadUtil {
    public static boolean isPhotoFileByName(String fileName){
        String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        return isPhotoFile(ext);
    }
    public static boolean isPhotoFile(String type){
        List<String> fileTypes = new ArrayList<String>();
        fileTypes.add("jpg");
        return fileTypes.contains(type.toLowerCase());
    }
}
