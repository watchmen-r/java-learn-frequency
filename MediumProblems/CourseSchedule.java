import java.util.ArrayDeque;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
        }

        // 入次数が0のものを格納する
        Queue<Integer> zero = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                zero.add(i);
            }
        }

        int index = 0;
        while (!zero.isEmpty()) {
            index++;
            int nowCourse = zero.poll();

            for (int[] pre : prerequisites) {
                if (pre[1] == nowCourse) {
                    indegree[pre[0]]--;

                    if (indegree[pre[0]] == 0) {
                        zero.add(pre[0]);
                    }
                }
            }
        }
        return index == numCourses ? true : false;
    }
}