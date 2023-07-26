import java.util.*;

public class OliveYoung2 {
    static List<String> filesToCheck = new ArrayList<>();
    static List<String> foldersToCheck = new ArrayList<>();
    public static void main(String[] args) {
        Map<String,List<String>> folderTree = new LinkedHashMap<>();
        Set<String> selectedFolders = new LinkedHashSet<>();
        Set<String> selectedFiles = new LinkedHashSet<>();
        Map<String,String> folderMap = new LinkedHashMap<>();
        Map<String,List<String>> fileTree = new LinkedHashMap<>();
        int fileNumber =0;
        int fileSize =0;
        String[][] folders = {{"food","root"},{"meat","food"},{"fruit","food"},{"animal","root"}};
        String[][] files = {{"cat","1B","animal"},{"dog","2B","animal"},{"apple","4B","fruit"},{"fire","83B","root"},{"fork","1KB","meat"},
                {"beef","8KB","meat"}};
        String[] selected = {"root","meat"};
        String[] excepted = {"fork","apple"};
        int[] answer = new int[2];
        makeFolderTree(folders, folderTree); //부모-자식 폴더
        makeFileTree(files,fileTree,excepted); // 부모폴더 - 자식파일
        makeFolderMap(folders,folderMap); // 자식-부모 폴더
        makeSelectedFolders(selected,selectedFolders,folderTree); //중복되는 폴더 삭제
        makeSelectedFiles(selectedFolders,selectedFiles,fileTree);
        addToFileSizeAndNumber(fileNumber, fileSize, files,selectedFiles,answer);
        System.out.println(selectedFiles);
        System.out.println(selectedFolders);
        System.out.println(folderMap);
        System.out.println(fileTree);
        System.out.println(folderTree);
        System.out.println(answer[0]+" "+answer[1]);
    }

    private static void addToFileSizeAndNumber(int fileNumber, int fileSize, String[][] files,Set<String> selectedFiles,int[] answer) {
        for(String file : selectedFiles){
            for(int j = 0; j< files.length; j++){
                if(file.equals(files[j][0])){ //이름이 같다면
                    fileNumber++;
                    String fileByte = files[j][1];
                    fileSize = caculateFileSize(fileSize, fileByte);
                }
            }
        }
        answer[0] =fileSize;
        answer[1] =fileNumber;
    }
    private static int caculateFileSize(int fileSize, String fileByte) {
        if(fileByte.charAt(fileByte.length()-2) !='K'){ //b로 끝난다면
            fileByte = fileByte.substring(0, fileByte.length()-1);
            fileSize += (Integer.parseInt(fileByte));
        }
        else{
            fileByte = fileByte.substring(0, fileByte.length()-2);
            fileSize +=(Integer.parseInt(fileByte)*1024);
        }
        return fileSize;
    }

    private static void makeSelectedFiles(Set<String> selectedFolders,Set<String> selectedFiles,Map<String,List<String>> fileTree) {
        for(String folderSelected :selectedFolders){
            if(!fileTree.containsKey(folderSelected)){
                continue;
            }
            List<String> filesToCheck = fileTree.get(folderSelected);
            for(int i=0;i<filesToCheck.size();i++){
                selectedFiles.add(filesToCheck.get(i));
            }
        }
    }

    private static void makeSelectedFolders(String[] selected,Set<String> selectedFolders,Map<String,List<String>> folderTree) {
//        for(String child : folderMap.keySet()){
//            selectedFolders.add(findParent(child));
//        }
        for(int i=0;i<selected.length;i++){
            addToSelectedFolder(selected[i],selectedFolders,folderTree);
        }

    }

    public static void addToSelectedFolder(String folder,Set<String> selectedFolders,Map<String,List<String>> folderTree){
        selectedFolders.add(folder);
        if(folderTree.containsKey(folder)){
            for(String childFolder : folderTree.get(folder)){
                addToSelectedFolder(childFolder,selectedFolders,folderTree);
            }
            return;
        }
    }
    private static void makeFolderMap(String[][] folders,Map<String,String> folderMap) {
        for(int i = 0; i< folders.length; i++){
            folderMap.put(folders[i][0], folders[i][1]);
        }
    }
    private static void makeFolderTree(String[][] foldersOrFiles, Map<String, List<String>> folderTree) {
        for(int i = 0; i< foldersOrFiles.length; i++){
            List<String> newChild;
            if(folderTree.containsKey(foldersOrFiles[i][1])){
                newChild = folderTree.get(foldersOrFiles[i][1]);
            }
            else{
                newChild = new ArrayList<>();
            }
            newChild.add(foldersOrFiles[i][0]);
            folderTree.put(foldersOrFiles[i][1],newChild);
        }
    }
    private static void makeFileTree(String[][] foldersOrFiles, Map<String, List<String>> Tree,String[] excepted) {
        for(int i = 0; i< foldersOrFiles.length; i++){
            List<String> newChild;
            if(Tree.containsKey(foldersOrFiles[i][2])){
                newChild = Tree.get(foldersOrFiles[i][2]);
            }
            else{
                newChild = new ArrayList<>();
            }
            boolean exceptFile =false; //예외 검사를 이후에 해도 좋을듯
            for(int j=0;j< excepted.length;j++){
                if(excepted[j].equals(foldersOrFiles[i][0])){
                    exceptFile = true;
                }
            }
            if(exceptFile) continue;
            newChild.add(foldersOrFiles[i][0]);
            Tree.put(foldersOrFiles[i][2],newChild);
        }
    }
}
