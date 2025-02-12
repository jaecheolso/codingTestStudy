package level1;

public class Lessons388351 {

    // 테스트 코드
    public static void main(String[] args) {
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday = 5; // 금요일

        System.out.println(solution(schedules, timelogs, startday)); // 예상 결과: 2
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int startTime = schedules[i];
            int hour = startTime / 100;
            int minute = startTime % 100;

            // 10분 추가 (분이 60 이상이면 시간 보정)
            minute += 10;
            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            int latestTime = hour * 100 + minute;

            boolean allOnTime = true;

            for (int j = 0; j < timelogs[i].length; j++) { // 평일만 확인
                int dayIndex = (startday + j) % 7; // 현재 요일 계산
                if (dayIndex == 6 || dayIndex == 0) continue; // 토요일(6), 일요일(0) 제외

                // 해당 요일에 대한 출근 기록 찾기
                int checkTime = timelogs[i][j];

                if (checkTime > latestTime) { // 너무 늦게 온 경우만 실패 처리
                    allOnTime = false;
                    break;
                }
            }

            if (allOnTime) answer++;
        }

        return answer;
    }
}
