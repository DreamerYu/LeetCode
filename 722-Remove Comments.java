class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
        // List<String> res = new ArrayList<>();
        // boolean line = false;
        // boolean delete = false;
        // StringBuilder build = new StringBuilder();
        // for(int i = 0; i < source.length; i++){
        //     line = true;
        //     int index = 0;
        //     while(index < source[i].length()){
        //         if(source[i].charAt(index) == '/'){
        //             if(index < source[i].length() - 1){
        //                 if(source[i].charAt(index+ 1) == '/'){
        //                     if(build.length() > 0 && build.toString() != "") res.add(build.toString());
        //                     build = new StringBuilder();
        //                     break;
        //                 }else if(source[i].charAt(index + 1) == '*'){
        //                     delete = true;
        //                     index += 2;
        //                     line = false;
        //                     continue;
        //                 }
        //             }
        //         }
        //         if(index < source[i].length() - 1 && source[i].charAt(index) == '*' && source[i].charAt(index + 1) == '/'){
        //             delete = false;
        //             index += 2;
        //             line = true;
        //             continue;
        //         }
        //         if(!delete) build.append(source[i].charAt(index));
        //         index++;
        //     }
        //     if(!delete && line){
        //         if(build.length() > 0 && build.toString() != "") res.add(build.toString());
        //         build = new StringBuilder();
        //     }
        // }
        // return res;
    }
}