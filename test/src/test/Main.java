package test;

public class Main {

	public static void main(String[] args) throws Exception {

//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 할당된 버퍼에 값 넣어주기
//
//		int basket = 0, cases = 0;
//
//		StringTokenizer st = new StringTokenizer(bf.readLine()); // StringTokenizer인자값에 입력 문자열 넣음
//		basket = Integer.parseInt(st.nextToken()); // 배열의 길이
//		cases = Integer.parseInt(st.nextToken()); // 입력 행 갯수
//
//		ArrayList<String> testArr = new ArrayList<>(); //
//		ArrayList<Integer> inputArr = new ArrayList<>(); //
//		ArrayList<Integer> hintArr = new ArrayList<>(); // 힌트 배열

		int basket = read();
		int cases = read();

		int[][] testArr = new int[105][3];
		int[] valueArr = new int[105];
		int[] hintArr = new int[105];

		// 테스트 배열에 입력값 넣기
		for (int i = 0; i < cases; i++) {
			testArr[i][0] = read();
			testArr[i][1] = read();
			testArr[i][2] = read();
		}

		// 테스트 배열에서 뒤부터 검증하며 실제 배열에 input 하기
		for (int i = cases - 1; i >= 0; i--) {
			int startIdx = testArr[i][0]; // 첫번째 호출
			int endIdx = testArr[i][1]; // 두번째 호출
			int value = testArr[i][2]; // 세번째 호출

			int cur = startIdx;
			while (cur <= endIdx) {
				int hint = hintArr[cur];

				if (hint != 0) {
					cur = hint + 1;
					continue;
				}

				valueArr[cur] = value;
				hintArr[cur] = endIdx; // 종점 위치 설정
				cur += 1;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= basket; i++) {
			result.append(valueArr[i]).append(" ");
		}
		System.out.println(result);
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		return n;
	}
}
