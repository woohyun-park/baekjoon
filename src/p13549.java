import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class p13549 {
    //pos와 time을 변수로 가지는 Position 클래스 확립
    static class Position{
        int pos;
        int time;

        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) {

        //이미 방문한 포지션들을 프루닝해주기 위한 리스트 선언
        boolean[] visited = new boolean[100001];

        //사용자 인풋 및 에러확인
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if (a < 0 || a > 100000 || b < 0 || a > 100000) {
            System.out.println("Invalid Input");
            return;
        }

        //큐 선언 및 시작점 큐에 삽입
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(a, 0));

        //반복문
        while(!q.isEmpty()){

            //큐의 pos와 time을 임시저장 후 dequeue
            int tempPos = q.peek().pos;
            int tempTime = q.peek().time;
            q.poll();

            //해당 포지션이 아직 방문되지 않았을 경우,
            //각 상황에 따라 알맞은 pos와 time으로 새로운 Position을 생성해서 큐에 삽입 후
            //해당 포지션을 방문으로 마크
            if(tempPos == b){
                System.out.println(tempTime);
                return;
            }
            if(tempPos * 2 <= 100000 && !visited[tempPos*2]){
                q.add(new Position(tempPos*2, tempTime));
                visited[tempPos*2] = true;
            }
            if(tempPos - 1 >= 0 && !visited[tempPos-1]){
                q.add(new Position(tempPos-1, tempTime+1));
                visited[tempPos - 1] = true;
            }
            if(tempPos + 1 <= 100000 && !visited[tempPos+1]){
                q.add(new Position(tempPos+1, tempTime+1));
                visited[tempPos + 1] = true;
            }
        }
    }
}