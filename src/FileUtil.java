/**
 * Description: Utility to operate files.
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtil {
    private String folder = "data/";

    // create folder to store files
    FileUtil(){
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    /**
     * Description: create file.
     *
     * @param filePath  path to store file
     */
    public void createFile(String filePath) {
        // create file
        try {
            File file = new File(folder+filePath);
            if (file.createNewFile()) {
                System.out.println("create file success: " + file.getName());
            } else {
                System.out.println("file exists.");
            }
        } catch (IOException e) {
            System.out.println("create file fail.");
            e.printStackTrace();
        }
    }

    /**
     * Description: reading from file.
     *
     * @param filePath  path to store file
     * @return          an array with each line of the file
     */
    public String[] readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(folder+filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("read file fail.");
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }

    /**
     * Description: write content to file, only if it is not in file.
     *
     * @param filePath  path to store file
     * @param content   the content need to write to file
     * @return          write success or not
     */
    public boolean writeFile(String filePath, String content, boolean unique) {
        // content already in file, return
        if (unique && containsString(filePath, content)) {
            System.out.println("ERROR! Already in file!");
            return false;
        }

        try (FileWriter writer = new FileWriter(folder+filePath,true)) {
            writer.write(content+"\n");
            System.out.println("write file success.");
            return true;
        } catch (IOException e) {
            System.out.println("write file fail.");
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Description: judge if specific string is in file.
     *
     * @param filePath      path to store file
     * @param searchString  string to search
     * @return              true if file contains string; false if not.
     */
    public boolean containsString(String filePath, String searchString) {
        boolean inFile = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(folder+filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(searchString)) {
                    inFile = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("containString: read file error.");
            e.printStackTrace();
        }
        return inFile;
    }

//    public static void main(String[] args) {
//        FileUtil fileUtil = new FileUtil();
//        String filePath = "example.txt";
//        fileUtil.createFile(filePath);
//        String inn = "wyh"+" "+"123";
//        fileUtil.writeFile(filePath, inn, true);
//        String[] res = fileUtil.readFile(filePath);
//        System.out.println(Arrays.toString(res));
//        System.out.println(fileUtil.containsString("example.txt","wyh 12345"));
//    }


}
