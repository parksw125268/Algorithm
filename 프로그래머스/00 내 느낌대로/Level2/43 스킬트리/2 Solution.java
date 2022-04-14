class Solution {
    String skill; String[] skill_trees;
    int cnt = 0;
    public int solution(String skill, String[] skill_trees) {
        this.skill = skill;  this.skill_trees = skill_trees;
        for(int i=0;i<skill_trees.length;i++){
            String newStr = removeJopSkill(skill_trees[i]); //잡스킬 제거
            if (isRightSeq(newStr)){ //순서맞는지
                cnt++;
            }
        }
        return cnt;
    }
    boolean isRightSeq(String liteSkill){
        for(int i=0;i<liteSkill.length();i++){
            if(skill.charAt(i) != liteSkill.charAt(i)){
                return false;
            }
        }
        return true;
    }
    String removeJopSkill(String s){
        String newS = "";
        for(int i=0;i<s.length();i++){
            String tempStr = s.substring(i,i+1);
            if(skill.contains(tempStr)){
                newS += tempStr;
            }
        }
        return newS;
    }
}