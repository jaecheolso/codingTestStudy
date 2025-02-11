package level1;

public class Lessons388351 {

    // 테스트 코드
    public static void main(String[] args) {
        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday = 1; // 월요일

        System.out.println(solution(schedules, timelogs, startday)); // 예상 결과: 2
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int startTime = schedules[i];
            int latestTime = startTime + 10;
            boolean allDaysOnTime = true;

            for (int j = 0; j < 7; j++) {
                int dayOfWeek = (startday + j) % 7; // 요일 계산 (0: 월요일, ..., 6: 일요일)
                if (dayOfWeek == 5 || dayOfWeek == 6) continue; // 토, 일 제외

                boolean attendedOnTime = false;
                for (int time : timelogs[i]) {
                    if (time >= startTime && time <= latestTime) {
                        attendedOnTime = true;
                        break;
                    }
                }

                if (!attendedOnTime) {
                    allDaysOnTime = false;
                    break;
                }
            }

            if (allDaysOnTime) answer++;
        }

        return answer;
    }
}
