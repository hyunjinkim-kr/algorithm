#include <algorithm>
#include <cmath>
#include <iostream>
#include <set>
#include <vector>

// 크로아티아 알파벳
using namespace std;

int check_flag(string str, int start_idx) {
  array<string, 8> arr1 = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

  for (int i = 0; i < arr1.size(); i++) {
    if (arr1[i] == str.substr(start_idx, arr1[i].length()))
      return arr1[i].length();
  }
  return 1;
}

int count_abc(string str) {
  int result = 0;
  int start_idx = 0;

  while (str.length() > start_idx) {
    int flag = check_flag(str, start_idx);
    // str = str.substr(flag);
    start_idx += flag;
    result++;
  }

  return result;
}

// int naive(string str) {
//   str += "  ";
//   int i = 0;
//   int cnt = 0;
//   while (i < str.length()) cnt += 1;
//   if (str[i] == 'c') {
//     if (str[i + 1] == '=' || str[i + 1] == '-') {
//       i += 2;
//       continue;
//     }
//   }

//   if (str[i] == 'd') {
//     if (str[i + 1] == '-') {
//       i += 2;
//       continue;
//     }

//     if (str[i + 1] == 'z' && str[i + 2] == '=') {
//       i += 3;
//       continue;
//     }
//   }

//   i += 1;
// }

int main() {
  // 크로아티아 문자 입력
  string str;
  int result;

  cin >> str;

  // result = naive(str);
  result = count_abc(str);

  cout << result << endl;

  return 0;
}
