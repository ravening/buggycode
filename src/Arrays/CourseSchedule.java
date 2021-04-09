package src.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    /*
    DFS
     */
    public boolean courseSchedule(int numCourse, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (var i = 0; i < numCourse; i++) {
            adjList.add(new ArrayList<>());
        }

        for (var pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourse];

        for (var i = 0; i < numCourse; i++) {
            if (dfs(i, adjList, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> adjList, int[] visited) {
        visited[course] = 1;

        for (var i = 0; i < adjList.get(course).size(); i++) {
            int tmp = adjList.get(course).get(i);
            if (visited[tmp] == 1) {
                return true;
            }

            if (visited[tmp] == 0) {
                if (dfs(tmp, adjList, visited)) {
                    return true;
                }
            }
        }

        visited[course] = 2;
        return false;
    }

    public boolean solution(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1)
            return true;

        if (numCourses == 2 && prerequisites[0][0] == prerequisites[0][1])
            return false;

        int[] indegree = new int[numCourses];

        for (int[] array : prerequisites) {
            indegree[array[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (var i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] pre: prerequisites) {
                if (pre[1] == course) {
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }

        for (int i : indegree) {
            if (i != 0)
                return false;
        }

        return true;
    }


}
