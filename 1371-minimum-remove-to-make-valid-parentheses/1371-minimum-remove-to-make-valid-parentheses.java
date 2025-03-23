class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> parenthesesStack = new Stack<>();
        Set<Integer> indicesToRemove = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(currentChar == '('){
                parenthesesStack.push(i);
            }else if(currentChar == ')'){
                if(!parenthesesStack.isEmpty()){
                    parenthesesStack.pop();
                }else{
                    indicesToRemove.add(i);
                } 
            }
        }
        while(!parenthesesStack.isEmpty()){
            indicesToRemove.add(parenthesesStack.pop());
        }
        StringBuilder validString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!indicesToRemove.contains(i)){
                validString.append(s.charAt(i));
            }
        }
        return validString.toString();
    }
}