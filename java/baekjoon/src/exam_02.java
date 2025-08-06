public class exam_02 {
    class Solution {
        public int[] skillOrders = new int[26];
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            int order =1;
            for(int i=0;i<skill.length();i++){
                skillOrders[skill.charAt(i)-'A'] =order;
                order++;
            }

            for(int i=0;i<skill_trees.length;i++){
                String curSkill = skill_trees[i];
                if(isPossibleSkillTree(curSkill)) answer++;
            }
            return answer;
        }
        public boolean isPossibleSkillTree(String skill){
            int curOrderToBe = 1;
            for(int j=0;j<skill.length();j++){
                int curOrder = skillOrders[skill.charAt(j)-'A'];
                if(curOrder==0) continue;
                if(curOrder != curOrderToBe){
                    return false;
                }
                curOrderToBe++;
            }
            return true;
        }
    }
}
